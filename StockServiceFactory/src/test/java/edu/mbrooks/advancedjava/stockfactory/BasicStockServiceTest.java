package edu.mbrooks.advancedjava.stockfactory;

import edu.mbrooks.advancedjava.stockquote.StockQuote;
import edu.mbrooks.advancedjava.stockservice.StockService;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @Test
    public void testQuoteHistoryHourly() {

        Calendar cal = Calendar.getInstance();
        List<StockQuote> histList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StockQuote bQuote = new StockQuote("IBM", cal, 100F, 98F, "International Business Machines", "AMEX");
        StockFactory sFactory = new StockFactory();
        StockService IBM = sFactory.getStockService(bQuote);

        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-01 11:34"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 100F, 98.9F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-02 12:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 101F, 100.1F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-03 1:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 99F, 98.6F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 1:34"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 104F, 103.75F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 2:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 103F, 102.5F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 2:10"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 103.20F, 102.98F, "International Business Machines", "AMEX"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Calendar from = Calendar.getInstance();
            from.setTime(sdf.parse("2011-05-02 12:00"));
            Calendar until = Calendar.getInstance();
            until.setTime(sdf.parse("2018-07-31 12:00"));
            histList = IBM.getQuoteHist("IBM", from,until,StockQuote.Interval.HOURLY);
        } catch (Exception e) {
            System.out.println(e);
        }

        // expecting 5 of the 6 items in the list
        assertTrue("Histroy records returned", histList.size() == 5);


    }

    @Test
    public void testQuoteHistoryDAILY() {

        Calendar cal = Calendar.getInstance();
        List<StockQuote> histList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StockQuote bQuote = new StockQuote("IBM", cal, 100F, 98F, "International Business Machines", "AMEX");
        StockFactory sFactory = new StockFactory();
        StockService IBM = sFactory.getStockService(bQuote);

        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-01 11:34"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 100F, 98.9F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-02 12:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 101F, 100.1F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-03 1:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 99F, 98.6F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 1:34"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 104F, 103.75F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 2:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 103F, 102.5F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 2:10"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 103.20F, 102.98F, "International Business Machines", "AMEX"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Calendar from = Calendar.getInstance();
            from.setTime(sdf.parse("2011-05-02 12:00"));
            Calendar until = Calendar.getInstance();
            until.setTime(sdf.parse("2018-07-31 12:00"));
            histList = IBM.getQuoteHist("IBM", from,until,StockQuote.Interval.DAILY);
        } catch (Exception e) {
            System.out.println(e);
        }

        // expecting 4 days are covered for the 6 items in the list
        assertTrue("Histroy records returned", histList.size() == 4);


    }
    @Test
    public void testQuoteHistoryDAILYOverloaded() {

        Calendar cal = Calendar.getInstance();
        List<StockQuote> histList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StockQuote bQuote = new StockQuote("IBM", cal, 100F, 98F, "International Business Machines", "AMEX");
        StockFactory sFactory = new StockFactory();
        StockService IBM = sFactory.getStockService(bQuote);

        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-01 11:34"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 100F, 98.9F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-02 12:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 101F, 100.1F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-03 1:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 99F, 98.6F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 1:34"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 104F, 103.75F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 2:00"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 103F, 102.5F, "International Business Machines", "AMEX"));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse("2018-05-05 2:10"));// all done
            IBM.addQuote(new StockQuote("IBM", cal, 103.20F, 102.98F, "International Business Machines", "AMEX"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Calendar from = Calendar.getInstance();
            from.setTime(sdf.parse("2011-05-02 12:00"));
            Calendar until = Calendar.getInstance();
            until.setTime(sdf.parse("2018-07-31 12:00"));
            histList = IBM.getQuoteHist("IBM", from,until);
        } catch (Exception e) {
            System.out.println(e);
        }

        // expecting 4 days are covered for the 6 items in the list
        assertTrue("Histroy records returned in overloaded method", histList.size() == 4);


    }

}