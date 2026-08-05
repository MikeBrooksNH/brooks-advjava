package edu.mbrooks.advanced.services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class StockTradingServiceFactoryTest {

    @Test
    public void testGetInstance() {
        StockTradingService stockService = WebStockServiceFactory.getInstance();
        assertNotNull(stockService);
    }
}
