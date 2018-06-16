package edu.mbrooks.advancedjava.StockQuote;

import junit.framework.TestCase;

public class StockQuoteTest extends TestCase {

    public void testSetGetTickerSymbol() {

        String expectedResult = "APPL";
        StockQuote aStock = new StockQuote();

        aStock.setTickerSymbol(expectedResult);

        assertTrue("StockQuote Setter / Getter: ", expectedResult == aStock.getTickerSymbol());

    }

    public void testToString() {

        String tickerSymbol = "APPL";
        String expectedResult = "{ " + '"' + "symbol" + '"' + ": " + '"' + "APPL" + '"' + " }";;
        StockQuote aStock = new StockQuote();

        aStock.setTickerSymbol(expectedResult);
        assertTrue("StockQuote toString ", expectedResult == aStock.getTickerSymbol());

    }
}