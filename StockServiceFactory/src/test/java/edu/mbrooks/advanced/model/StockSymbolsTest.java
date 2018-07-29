package edu.mbrooks.advanced.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockSymbolsTest {

    final static int id = 10;
    final static String symbol = "INTC";
    final static String companyName = "Intel";

    /**
     * Testing helper method for generating Hobby test data
     *
     * @return a StockSymbols object that uses static constants for data.
     */
    public static StockSymbols createStock() {
        StockSymbols stocksymbol = new StockSymbols();
        stocksymbol.setId(id);
        stocksymbol.setSymbol(symbol);
        stocksymbol.setCompanyName(companyName);
        return stocksymbol;
    }

    @Test
    public void testHobbySettersAndGetters() {
        StockSymbols symbol = createStock();
        int expected_id_result = 10;
        String expected_symbol_result = "INTC";
        String expected_companyName_result = "Intel";

        assertEquals("Stock ID", expected_id_result, symbol.getId());
        assertEquals("Stock Symbol", expected_symbol_result, symbol.getSymbol() );
        assertEquals("Name", expected_companyName_result, symbol.getCompanyName());

    }

    @Test
    public void testToString() {
        String expected_result = "StockSymbols{ symbol='INTC', companyName= 'Intel'}";
        StockSymbols symbol = createStock();
        System.out.println(symbol.toString());
        assertEquals("toString", expected_result,symbol.toString());
    }
}