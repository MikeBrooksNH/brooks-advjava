package edu.mbrooks.advanced.services;

import edu.mbrooks.advanced.model.StockQuote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * An implementation of the StockService that returns hard coded data.
 */
public abstract class SimpleStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol)  throws StockServiceException {
        // a dead simple implementation.
        try {
            return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
        } catch (Exception e) {

            throw new StockServiceException("Error getting quote");
        }
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {
        try {
            // a dead simple implementation.
            List<StockQuote> stockQuotes = new ArrayList<>();
            Date aDay = from.getTime();
            while (until.after(aDay)) {
                stockQuotes.add(new StockQuote(new BigDecimal(100), aDay, symbol));
                from.add(Calendar.DAY_OF_YEAR, 1);
                aDay = from.getTime();
            }
            return stockQuotes;

        }  catch (Exception e) {

            throw new StockServiceException("Error getting quote");
        }

    }
}
