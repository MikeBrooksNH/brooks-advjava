package edu.mbrooks.advancedjava.stockfactory;

import edu.mbrooks.advancedjava.stockquote.StockQuote;
import edu.mbrooks.advancedjava.stockservice.StockService;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BasicStockServiceTest extends TestCase {

    private static boolean isSetup = false;

    private StockFactory sFactory;
    private StockService aService;
    private StockQuote quote;
    private Calendar cal;
    private SimpleDateFormat sdf;

    @Test
    public void testGetQuote() {

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            cal.setTime(sdf.parse("2018-05-01 12:00"));
        } catch (Exception e) {
            System.out.println(e);
        }
        sFactory = new StockFactory();
        quote = new StockQuote("IBM", cal, 100F, 98F, "International Business Machines", "AMEX");
        aService = sFactory.getStockService(quote);

        assertTrue("Check Factory returns an Instance : ", this.quote.getTickerSymbol().compareToIgnoreCase("IBM") == 0);
    }

    @Test
    public void testAddQuote() {

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            cal.setTime(sdf.parse("2018-05-01 12:00"));
        } catch (Exception e) {
            System.out.println(e);
        }
        sFactory = new StockFactory();
        quote = new StockQuote("IBM", cal, 100F, 98F, "International Business Machines", "AMEX");
        aService = sFactory.getStockService(quote);

        aService.addQuote(new StockQuote("IBM", cal, 555F, 550F, "International Business Machines", "AMEX"));
        assertTrue("Check Factory returns an Instance : ", this.aService.getQuote().getTickerSymbol() == "IBM");

    }

    @Test
    public void testAddQuoteNegative() {

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            cal.setTime(sdf.parse("2018-05-01 12:00"));
        } catch (Exception e) {
            System.out.println(e);
        }
        sFactory = new StockFactory();
        quote = new StockQuote("IBM", cal, 100F, 98F, "International Business Machines", "AMEX");
        aService = sFactory.getStockService(quote);

        aService.addQuote(new StockQuote("IBM", cal, 555F, 550F, "International Business Machines", "AMEX"));
        assertFalse("Check Factory returns an Instance : ", this.aService.getQuote().getTickerSymbol() == "APL");

    }

}