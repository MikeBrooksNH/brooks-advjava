package edu.mbrooks.advanced.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class QuotesTest {

    public String symbol = "INTC";
    public BigDecimal price;
    public Timestamp time;
    public Quotes quote = new Quotes();
    public String expected_toString_result = "Quote{ symbol='INTC', price=57.08, date=";


    @Before
    public void TestSetters() {

        price = new BigDecimal("57.08");
        time = new Timestamp(Calendar.getInstance().getTimeInMillis());
        expected_toString_result += time.toString() + "}";

        quote.setTime(time);
        quote.setPrice(price);
        quote.setSymbol(symbol);
    }


         @Test
        public void testGetPrice() {
            assertEquals("Share price is correct", price, quote.getPrice());
        }

        @Test
        public void testGetDate() {
            assertEquals("Share date is correct", time, quote.getTime());
        }

        @Test
        public void testGetSymbol() {
            assertEquals("Symbol  is correct", symbol, quote.getSymbol());
        }

    @Test
    public void TesttoString() {
        assertEquals("toString matches", expected_toString_result, quote.toString());
    }
}