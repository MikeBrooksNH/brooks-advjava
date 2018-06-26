package edu.mbrooks.advanced.services;

import edu.mbrooks.advanced.model.StockQuery;
import edu.mbrooks.advanced.model.StockQuote;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    @Test
    public void testGetQuote() throws Exception {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuoteList() {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        try {
            List<StockQuote> stockQuote = new ArrayList<StockQuote>();
            StockQuery stockQuery = new StockQuery("IBM", "2018/01/01", "2018/08/01");

            List<StockQuote> tempList = databaseStockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
            for (StockQuote aQuote : tempList) {
                System.out.println(aQuote.toString());
            }

            // expecting 23 quotes returned for the time period specified for the symbol specified
            // Obviously this doesn't scale and is very specific to THIS run, actual test data needs to be inserted into the DB and
            // is accounted for for the next iteration using the insert_test_data.sql and remove_test_data.sql scripts...
            assertEquals("Histroy records returned in overloaded method", 23, tempList.size());
        } catch (Exception e)  {
            //
            // The exception is logged and a future version will handle specific exceptions when they ever occur
            // - I just ran into a real world scenario where an exception was handled, poorly, and never logged.
            System.out.println("handling the exception \n" + e.toString());

            // Bail
            System.exit(-1);
        }

    }
}
