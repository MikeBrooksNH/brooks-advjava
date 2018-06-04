/*
 * Program Name:    Main.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
*/

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.main;
import edu.mbrooks.advancedjava.StockQuote.*;
import edu.mbrooks.advancedjava.StockFactory.*;
import edu.mbrooks.advancedjava.StockService.*;

/**
 *  Main class for a command line interface to this program
 */
public class Main {

    /**
     *
     * @param args  is a string array of arguments to the main function
     *
     * Main method that is executed to run this from the command line
     */
    public static void main(String[] args) {

        StockQuote quote = new StockQuote();

        StockFactory sFactory = new StockFactory();
        StockService NASDAQ = sFactory.getStockService();

        StockQuote Apple = NASDAQ.getQuote("APL");

        System.out.println(Apple.toString());

    }
}
