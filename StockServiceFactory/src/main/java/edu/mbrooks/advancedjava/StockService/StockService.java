/*
 * Program Name:    StockService.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.StockService;
import edu.mbrooks.advancedjava.StockQuote.*;
import edu.mbrooks.advancedjava.StockFactory.*;
import edu.mbrooks.advancedjava.StockService.*;

/**
 * This is the StockService interface
 */
public interface StockService {
    /**
     * Return the current price for a share of stock for the given symbol
     * @param symbol the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     * @return a <CODE>StockQuote </CODE> instance
     */
    StockQuote getQuote(String symbol);
}
