package edu.mbrooks.advancedjava.stockfactory;

import edu.mbrooks.advancedjava.stockquote.StockQuote;
import edu.mbrooks.advancedjava.stockservice.StockService;
import junit.framework.TestCase;
import org.junit.BeforeClass;
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

    @BeforeClass
    public void setup () {
        if (isSetup) {
            return;
        }

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //sFactory = new StockFactory();
        // aService = sFactory.getStockService();
        //quote = NASDAQ.getQuote("APPL");

        isSetup = true;

    }

    @Test
    public void testGetQuote() {

        StockQuote quote = new StockQuote("APL",cal,120F);
        assertTrue("Check Factory returns an Instance : ", quote.getTickerSymbol() == "APL");

    }
}