package edu.mbrooks.advancedjava.stockquote;

import edu.mbrooks.advancedjava.stockfactory.StockFactory;
import edu.mbrooks.advancedjava.stockservice.StockService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
/*
    @Test
    public void testToString() {

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            cal.setTime(sdf.parse("2018-06-01 12:00"));// all done
        } catch (Exception e) {
            System.out.println(e);
        }



        String expectedResult = "{ " + '"' + "symbol" + '"' + " : " + '"' + "APL" + '"' +  ", "
                + '"' + "ask" + '"' + " : " + '"' + " 120.00"  + '"' +  ", "
                + '"' + "QuoteDate" + '"' + " : " + '"' + "6/1/2018"  + '"' +  ", "
                + '"' + "bid" + '"' + " : " + '"' + "0.00"  + '"' +  ", "
                + '"' + "CompanyName" + '"' + " : " + '"' + "null"  + '"' +  ", "
                + '"' + "Exchange" + '"' + " : " + '"' + "null"  + '"' +  ", " + " }";

        StockQuote aStock = new StockQuote("APL", cal,120F);
        //String s = Integer.toString(aStock.dateOfQuote.get(Calendar.MONTH) + 1) + "/" + Integer.toString(this.dateOfQuote.get(Calendar.DAY_OF_MONTH)) + "/" + Integer.toString(this.dateOfQuote.get(Calendar.YEAR));

        assertTrue("stockquote toString ", expectedResult == aStock.toString());
    }
*/
    @Test
    public void testNoParamConstructor() {

        String expectedResult = "APL";
        StockQuote aStock = new StockQuote();

        assertTrue("No Param Contructor", aStock.getTickerSymbol() == expectedResult);
    }

 }