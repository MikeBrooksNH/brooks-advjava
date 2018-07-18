package edu.mbrooks.advanced.services;

import edu.mbrooks.advanced.model.Quotes;

/**
 * This API describes how to get stock data from an external resource.
 */
public interface WebStockService {


    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param stockSymbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    public Quotes getWebServiceQuote(String stockSymbol) throws StockTradingServiceException;

    }


