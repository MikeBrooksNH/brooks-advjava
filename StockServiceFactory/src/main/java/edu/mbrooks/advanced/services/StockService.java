package edu.mbrooks.advanced.services;

import edu.mbrooks.advanced.model.StockQuote;

import java.util.Calendar;
import java.util.List;

/**
 * This API describes how to get stock data from an external resource.
 */
public interface StockService {


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
    StockQuote getQuote(String symbol) throws StockServiceException;

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException;


    /**
     * Overloaded method for specifying the frequency a stock quote should be returned in
     * @param symbol - stock symbol to look up
     * @param from - start of date range for quotes
     * @param until - end date for the quote range
     * @param interval - how oftenit should retrieve quotes for
     * @return List of quotes
     * @throws StockServiceException - indicates an issue with getting the list of stocks in the interval
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, StockQuote.Interval interval) throws StockServiceException;
}

