package edu.mbrooks.advancedjava.StockFactory;

import edu.mbrooks.advancedjava.StockQuote.StockQuote;
import edu.mbrooks.advancedjava.StockService.StockService;
import junit.framework.TestCase;

public class StockTraderTest extends TestCase {

    public void testGetQuote() {

        StockFactory sFactory = new StockFactory();
        StockService NASDAQ = sFactory.getStockService();
        StockQuote quote = NASDAQ.getQuote("APPL");

        assertTrue("Check Factory returns an Instance : ", quote.getTickerSymbol() == "APPL");

    }
}