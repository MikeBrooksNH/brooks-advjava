/*
 * Program Name:    Main.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.StockQuote;
import edu.mbrooks.advancedjava.StockQuote.*;
import edu.mbrooks.advancedjava.StockFactory.*;
import edu.mbrooks.advancedjava.StockService.*;

/**
 *  StockQuote class is for storing information about a single stock
 */
public class StockQuote {

    private String tickerSymbol;

    /**
     *
     * @return string representing the tickerSymbol
     */
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    /**
     *
     * @param tickerSymbol a string that represens the stock's
     */
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    /**
     *  @return string representive of a JSON style string
     */
    @Override
    public String toString() {

        String returnValue = "";

        try {
            returnValue =  "{ " + '"' + "symbol" + '"' + ": " + '"' + this.tickerSymbol + '"' + " }";
        } catch (NullPointerException e) {
            System.out.println("Null Pointer exception...");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Some other exception is caught...");
            System.out.println(e);
        }

        return returnValue;
    }
}
