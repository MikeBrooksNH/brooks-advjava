package edu.mbrooks.advancedjava.StockFactory;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import junit.framework.TestCase;
import edu.mbrooks.advancedjava.StockService.*;
import edu.mbrooks.advancedjava.StockFactory.*;
import edu.mbrooks.advancedjava.StockQuote.*;


public class StockFactoryTest extends TestCase {

    public void testGetStockService() {
        StockQuote quote = new StockQuote();

        StockFactory sFactory = new StockFactory();
        StockService NASDAQ = sFactory.getStockService();

        assertTrue("Check Factory returns an Instance : ", NASDAQ instanceof StockService);

    }
}