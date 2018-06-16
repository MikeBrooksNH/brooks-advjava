/*
 * Program Name:    StockFactory.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.StockFactory;
import edu.mbrooks.advancedjava.StockQuote.*;
import edu.mbrooks.advancedjava.StockFactory.*;
import edu.mbrooks.advancedjava.StockService.*;

/**
 *  The StockTrader class implements the SockService interface
 */
class StockTrader implements StockService {

    StockQuote quote = new StockQuote();

    /**
     * No argument contructor (temporarily setting the ticker symbol to APPL
     *
     */
    public StockTrader() {
        this.quote.setTickerSymbol("APPL");
    }

    /**
     *
     * @param symbol the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     * @return
     */
    public StockQuote getQuote(String symbol) {
        return (this.quote);
    }
}

/**
 * Factory class for returning instances of the StockService
 */
public class StockFactory {

    /**
     *
     * @return and instance of StockTrader
     */
    public StockService getStockService() {

        return (new StockTrader());
    }

}
