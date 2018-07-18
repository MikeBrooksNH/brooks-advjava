package edu.mbrooks.advanced.services;

import edu.mbrooks.advanced.model.Quotes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class StockTradingServiceTest {

    StockTradingService stocktradingservice = new StockTradingService();

    Quotes testQuote = new Quotes();

    @Before
    public void TestCreateQuote() throws StockTradingServiceException {
          testQuote = stocktradingservice.getWebServiceQuote("INTC");
    }

    @Test
    public void TestQuoteValidate() {
    	assertEquals("Symbol is correct: ", testQuote.getSymbol(), "INTC");
    }
}
