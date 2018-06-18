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

import edu.mbrooks.advancedjava.stockquote.StockQuote;

import java.util.Calendar;
import java.util.List;

/**
 * This is the stockservice interface
 */
public interface StockService {
    public StockQuote getQuote();
    public void addQuote(StockQuote q);
    public void printHist();
    public List<StockQuote> getQuoteHist(String symbol, Calendar from, Calendar until, StockQuote.Interval daily);



}
