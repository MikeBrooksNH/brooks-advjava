/*
 * Program Name:    Main.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
*/

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava;
import edu.mbrooks.advancedjava.stockquote.*;
import edu.mbrooks.advancedjava.stockfactory.*;
import edu.mbrooks.advancedjava.stockservice.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *  Main class for a command line interface to this program
 */
public class Main {

    /**
     *
     * @param args  is a string array of arguments to the main function
     *
     * Main method that is executed to run this from the command line
     */
    public static void main(String[] args) {

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
        cal.setTime(sdf.parse("2018-05-04 1:34"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 104F, 103.75F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-05 2:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 103F, 102.5F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-06 2:10"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 103.20F, 102.98F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-07 2:15"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 103.25F, 102.75F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-08 2:40"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 103.10F, 102.5F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-09 3:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 103F, 102.5F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-10 3:30"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 102F, 101F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-11 4:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 100F, 99F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-12 5:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 99F, 98F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-13 8:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 98F, 97F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-13 9:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 97.5F, 97F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-13 9:30"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 96.25F, 96F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-16 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 96F, 95.75F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-05-17 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-06-01 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-06-02 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-06-03 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-07-01 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-07-02 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-07-03 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2017-06-01 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2017-06-02 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2017-06-03 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2017-07-01 12:00"));// all done
        IBM.addQuote(new StockQuote("IBM", cal, 95.75F, 95F, "International Business Machines", "AMEX"));

    } catch (Exception e) {
        System.out.println(e);
    }

        IBM.printHist();
        try {
            Calendar from = Calendar.getInstance();
            from.setTime(sdf.parse("2011-05-02 12:00"));
            Calendar until = Calendar.getInstance();
            until.setTime(sdf.parse("2018-07-31 12:00"));
            histList = IBM.getQuoteHist("IBM", from,until,StockQuote.Interval.MONTHLY);

            System.out.println();
            System.out.println("History Listing");
            System.out.println("-----------------------");
            for (StockQuote q : histList){
                System.out.println(q.toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
