/*
 * Program Name:    StockFactory.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.stockfactory;
import edu.mbrooks.advancedjava.stockquote.*;
import edu.mbrooks.advancedjava.stockservice.*;

import java.util.*;

/**
 *  The BasicStockService class implements the SockService interface
 */
class BasicStockService implements StockService {

    private Calendar cal = Calendar.getInstance();
    private StockQuote quote;
    private List<StockQuote> historyQuotes = new ArrayList<>();


    /**
     * contructor requires a quote
     *
     */
    public BasicStockService(StockQuote quote) {
        this.quote = quote;
    }

    /**
     *
     * @return quote Stock Quote
     */
    public StockQuote getQuote() {
        return (this.quote);
    }


    /**
     * @param q Stock Quote
      */
    public void addQuote(StockQuote q) {
        this.historyQuotes.add(q);
        this.quote = q; // the latest quote is always available...
    }

    /**
     *
     * @param symbol
     * @param from
     * @param until
     * @return
     */
    public List<StockQuote> getQuoteHist(String symbol, Calendar from, Calendar until) {

        List<StockQuote> returnList = new ArrayList<>();

        for (StockQuote q : this.historyQuotes){
            if (q.getDateOfQuote().after(from) && q.getDateOfQuote().before(until)) {
                returnList.add(q);
            } else if (q.getDateOfQuote().compareTo(from) == 0) {
                returnList.add(q);
            } else if (q.getDateOfQuote().compareTo(until) == 0) {
                returnList.add(q);
            }
        }
        return returnList;
    }

    /**
     * print the full quote history
     */
    public void printHist() {
        for (StockQuote q : this.historyQuotes){
            System.out.println(q.toString());
        }

    }

}

/**
 * Factory class for returning instances of the stockservice
 */
public class StockFactory {

    /**
     *
     * @return and instance of BasicStockService
     */
    public StockService getStockService(StockQuote quote) {

        return (new BasicStockService(quote));
    }

}
