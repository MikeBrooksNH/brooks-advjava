/*
 * Program Name:    Main.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.stockquote;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *  stockquote class is for storing information about a single stock
 *
 *  This is an immutable class - once created, it cannot change because a stock quote happens at a moment in time an never changes
 */
@Immutable
public class StockQuote {

    private final Calendar today = Calendar.getInstance();

    private String tickerSymbol;
    private Calendar dateOfQuote;
    private float ask;
    private float bid;
    private String CompanyName;
    private String  exchange;   // Need a service to return the exchange the ticker symbol is on


    public enum Interval {
        HOURLY, DAILY, WEEKLY, MONTHLY, QUARTERLY, ANNUALLY;
    }
    /**
     * Contructor starting point... this is what every constructor will do first to ensure everything is always inited to something...
     */
    private void Init() {
        this.tickerSymbol = "APL";
        this.dateOfQuote = today;
        this.ask = 0;
        this.bid = 0;
        this.CompanyName = "Apple";
        this.exchange = "NASDAQ";
    }

    /**
     * no param constructor default the ticker symbol to APPL
     */
   public StockQuote() {
       Init();
    }

    /**
     *
     * @param tickerSymbol is the ticker symbol for the stock
     * @param dateOfQuote  is the date of the quote
     * @param ask          is the ask price
     */
    public StockQuote(String tickerSymbol, Calendar dateOfQuote, float ask) {
        Init();
        this.tickerSymbol = tickerSymbol;
        this.dateOfQuote = dateOfQuote;
        this.ask = ask;
    }

    /**
     *
     * @param tickerSymbol is the ticker symbol for the stock
     * @param dateOfQuote  is the date of the quote
     * @param ask          is the ask price for buying
     * @param bid          is the bid price for selling
     */
    public StockQuote(String tickerSymbol, Calendar dateOfQuote, float ask, float bid) {
        Init();
        this.tickerSymbol = tickerSymbol;
        this.dateOfQuote = dateOfQuote;
        this.ask = ask;
        this.bid = bid;
    }

    /**
     *
     * @param tickerSymbol is the ticker symbol for the stock
     * @param dateOfQuote  is the date of the quote
     * @param ask          is the ask price for buying
     * @param bid          is the bid price for selling
     * @param companyName  is the full company name
     */
    public StockQuote(String tickerSymbol, Calendar dateOfQuote, float ask, float bid, String companyName) {
        Init();
        this.tickerSymbol = tickerSymbol;
        this.dateOfQuote = dateOfQuote;
        this.bid = bid;
        this.ask = ask;
        this.CompanyName = companyName;
    }

    /**
     *
     * @param tickerSymbol is the ticker symbol for the stock
     * @param dateOfQuote  is the date of the quote
     * @param ask          is the ask price for buying
     * @param bid          is the bid price for selling
     * @param companyName  is the full company name
     * @param exchange     is the exchange this stock is traded on
     */
    public StockQuote(String tickerSymbol, Calendar dateOfQuote, float ask, float bid, String companyName, String exchange) {
        Init();
        this.tickerSymbol = tickerSymbol;

        if (dateOfQuote != null) {
            this.dateOfQuote = dateOfQuote;
        }

        this.ask = ask;
        this.bid = bid;
        this.CompanyName = companyName;
        this.exchange = exchange;
    }

    /**
     *
     * @return string representing the tickerSymbol
     */
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    /**
     *  @return string representive of a JSON style string
     */
    @Override
    @NotNull
    public String toString() throws NullPointerException {

        String returnValue = "";
        String formattedDate = "";

        try {
            SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            formattedDate = sdf.format(this.dateOfQuote.getTime());

            returnValue =  "{ " + '"' + "symbol" + '"' + ": " + '"' + this.tickerSymbol + '"' + ", " + '"' + "ask" + '"' + ": " + '"' + String.format("%.2f", this.ask)   + '"' +
                     ", " + '"' + "QuoteDate" + '"' + ": " + '"' + formattedDate + '"' +
                    ", " + '"' + "bid" + '"' + ": " + '"' + String.format("%.2f", this.bid)  + '"' +
                    ", " + '"' + "CompanyName" + '"' + ": " + '"' + this.CompanyName  + '"' +
                    ", " + '"' + "Exchange" + '"' + ": " + '"' + this.exchange  + '"' +
                     " }";
        } catch (NullPointerException e) {
            System.out.println("Null Pointer exception...");
            //throw (e);
        } catch (Exception e) {
            System.out.println("Some other exception is caught...");
            System.out.println(e);
            throw (e);
        }

        return returnValue;
    }

    /**
     *
     * @return dateOfQuote which is a Calendar class type
     */
    public Calendar getDateOfQuote() {
        return dateOfQuote;
    }
}
