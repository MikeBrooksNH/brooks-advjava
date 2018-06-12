package edu.mbrooks.advancedjava.stockquote;

import edu.mbrooks.advancedjava.stockfactory.StockFactory;
import edu.mbrooks.advancedjava.stockservice.StockService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StockQuoteTest extends TestCase {

    private static boolean isSetup = false;

    private StockFactory sFactory;
    private StockService aService;
    private StockQuote quote;
    private Calendar cal;
    private SimpleDateFormat sdf;

    @Before
    public void setup () {
        if (isSetup) {
            return;
        }

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            cal.setTime(sdf.parse("2018-06-01 12:00"));// all done
        } catch (Exception e) {
            System.out.println(e);
        }

        //sFactory = new StockFactory();
        // aService = sFactory.getStockService();
        //quote = NASDAQ.getQuote("APPL");

        isSetup = true;

    }

    @Test
    public void testSetGetTickerSymbol() {

        String expectedResult = "APL";

        StockQuote aStock = new StockQuote("APL", cal,120F);

        assertTrue("stockquote Setter / Getter: ", expectedResult == aStock.getTickerSymbol());

    }

    @Test
    public void testToString() {

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StockQuote aStock = new StockQuote("IBM", cal, 101F, 100.1F, "International Business Machines", "AMEX");

        try {
            cal.setTime(sdf.parse("2018-05-02 12:00"));// all done
        } catch (Exception e) {
            System.out.println(e);
        }

        String expectedResult = "{ " + '"' + "symbol" + '"' + ": " + '"' + "IBM" + '"' +  ", "
                + '"' + "ask" + '"' + ": " + '"' + "101.00"  + '"' +  ", "
                + '"' + "QuoteDate" + '"' + ": " + '"' + "2018-05-02 12:00"  + '"' +  ", "
                + '"' + "bid" + '"' + ": " + '"' + "100.10"  + '"' +  ", "
                + '"' + "CompanyName" + '"' + ": " + '"' + "International Business Machines"  + '"' +  ", "
                + '"' + "Exchange" + '"' + ": " + '"' + "AMEX"  + '"' +  " }";

        aStock = new StockQuote("IBM", cal, 101F, 100.1F, "International Business Machines", "AMEX");

        String compareString = aStock.toString();
        assertTrue("stockquote toString ", expectedResult.compareTo(compareString) == 0);
    }

    @Test
    public void testNoParamConstructor() {

        String expectedResult = "APL";
        StockQuote aStock = new StockQuote();

        assertTrue("No Param Contructor", aStock.getTickerSymbol() == expectedResult);
    }

    @Test
    public void testConstructorWithBid() {

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StockQuote aStock;
        try {
            cal.setTime(sdf.parse("2018-05-02 12:00"));// all done
        } catch (Exception e) {
            System.out.println(e);
        }

        String expectedResult = "{ " + '"' + "symbol" + '"' + ": " + '"' + "IBM" + '"' +  ", "
                + '"' + "ask" + '"' + ": " + '"' + "101.00"  + '"' +  ", "
                + '"' + "QuoteDate" + '"' + ": " + '"' + "2018-05-02 12:00"  + '"' +  ", "
                + '"' + "bid" + '"' + ": " + '"' + "100.10"  + '"' +  ", "
                + '"' + "CompanyName" + '"' + ": " + '"' + "Apple"  + '"' +  ", "
                + '"' + "Exchange" + '"' + ": " + '"' + "NASDAQ"  + '"' +  " }";

        aStock =  new StockQuote("IBM", cal, 101F, 100.1F);

        String compareString = aStock.toString();
        assertTrue("stockquote toString ", expectedResult.compareTo(compareString) == 0);
    }

}