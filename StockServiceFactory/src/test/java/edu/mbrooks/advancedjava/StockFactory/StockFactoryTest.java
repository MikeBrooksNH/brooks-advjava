package edu.mbrooks.advancedjava.stockfactory;

import junit.framework.TestCase;
import edu.mbrooks.advancedjava.stockservice.*;
import edu.mbrooks.advancedjava.stockquote.*;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class StockFactoryTest extends TestCase {

    private static boolean isSetup = false;

    private StockFactory sFactory;
    private StockService aService;
    private StockQuote quote;
    private Calendar cal;
    private SimpleDateFormat sdf;

    @BeforeClass
    public void setup () {
        if (isSetup) {
            return;
        }

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        quote = new StockQuote();
        sFactory = new StockFactory();
        aService = sFactory.getStockService(quote);

        isSetup = true;

    }



    public void testGetStockService() {


        String expectedResult = "{ " + '"' + "symbol" + '"' + " : " + '"' + "APL" + '"' +  ", "
                + '"' + "ask" + '"' + " : " + '"' + " 120.00"  + '"' +  ", "
                + '"' + "QuoteDate" + '"' + " : " + '"' + "6/1/2018"  + '"' +  ", "
                + '"' + "bid" + '"' + " : " + '"' + "0.00"  + '"' +  ", "
                + '"' + "CompanyName" + '"' + " : " + '"' + "null"  + '"' +  ", "
                + '"' + "Exchange" + '"' + " : " + '"' + "null"  + '"' +  ", " + " }";



        StockQuote quote = new StockQuote();

        StockFactory sFactory = new StockFactory();
        StockService apple = sFactory.getStockService(quote);

        assertTrue("Check Factory returns an Instance : ", apple != null);

    }
}