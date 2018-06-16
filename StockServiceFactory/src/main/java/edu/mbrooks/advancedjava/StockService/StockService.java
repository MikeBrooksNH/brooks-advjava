/*
 * Program Name:    StockService.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.stockservice;
import edu.mbrooks.advancedjava.stockquote.*;

import java.util.Calendar;
import java.util.List;

/**
 * This is the stockservice interface
 */
public interface StockService {
    /**
     * Return the current price for a share of stock for the given symbol
     * @param symbol the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     * @return a <CODE>stockquote </CODE> instance
     */
    public StockQuote getQuote();
    public void addQuote(StockQuote q);
    public void printHist();
    public List<StockQuote> getQuoteHist(String symbol, Calendar from, Calendar until);



}
