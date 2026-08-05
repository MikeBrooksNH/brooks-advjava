package edu.mbrooks.advanced.services;
// information regarding methods for retrieving quote information:
// https://github.com/WojciechZankowski/iextrading4j/blob/master/iextrading4j-api/src/main/java/pl/zankowski/iextrading4j/api/stocks/Quote.java

import edu.mbrooks.advanced.model.Quotes;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Stock Trading Service is an adapter class between how Quotes are being used for this program and how they are
 * received from the web.
 *
 */

// This class needs to throw and exception called StockTradingServiceException
public  class StockTradingService implements WebStockService {

    private String symbol;
    private BigDecimal latestPrice;
    private Timestamp latestQuoteTime;

    /**
     *
     * @param stockSymbol is the symbol to lookup through the web stock service
     * @return a stockquote that can be stored to the database
     */
    public Quotes getWebServiceQuote(String stockSymbol) throws StockTradingServiceException {
        Quotes localQuote = new Quotes();

        final IEXTradingClient iexTradingClient = IEXTradingClient.create();
        pl.zankowski.iextrading4j.api.stocks.Quote plquote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol(stockSymbol)
                .build());

        localQuote.setSymbol(stockSymbol);
        localQuote.setPrice(plquote.getLatestPrice());

        try {
            Timestamp t = new Timestamp(plquote.getLatestUpdate());
            localQuote.setTime(t);
        } catch (Exception e) {
            System.out.println("Error Setting the correct date format");
            System.out.println(e);
            throw new StockTradingServiceException("Error Retrieving quote from web service", e);
        }

        return localQuote;
    }

}
