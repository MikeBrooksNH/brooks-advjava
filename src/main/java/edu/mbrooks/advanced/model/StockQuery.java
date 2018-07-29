package edu.mbrooks.advanced.model;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Calendar;

/**
 * This class is used to a single query to stock service.
 */

public class StockQuery extends StockData{

    private String symbol;
    private Calendar from;
    private Calendar until;

    /**
     * Create a new instance from string data. This constructor will convert
     * dates described as a String to Date objects.
     *
     * @param symbol the stock symbol
     * @param from   the start date as a string in the form of yyyy/MM/dd
     * @param until   the end date as a string in the form of yyyy/MM/dd
     * @throws ParseException if the format of the date String is incorrect. If this happens
     *                        the only recourse is to try again with a correctly formatted String.
     */
    public StockQuery(@NotNull String symbol, @NotNull String from, @NotNull String until) throws ParseException {
        super();
        this.symbol = symbol;
        this.from = Calendar.getInstance();
        this.until = Calendar.getInstance();
        System.out.println(simpleDateFormat);
        this.from.setTime(simpleDateFormat.parse(from));
        this.until.setTime(simpleDateFormat.parse(until));
    }

    /**
     * @return get the stock symbol associated with this query
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return get the start Calendar associated with this query
     */
    public Calendar getFrom() {
        return from;
    }

    /**
     * @return get the end Calendar associated with this query
     */
    public Calendar getUntil() {
        return until;
    }

    /**
     * setter for the symbol
     * @param symbol - stock symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * setter for the from date
     * @param from - from time
     */
    public void setFrom(String from) {
        try {
            this.from = Calendar.getInstance();
            this.from.setTime(simpleDateFormat.parse(from));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    /**
     * setter for the to date
     * @param until - until time
     */
    public void setUntil(String until) {
        try {
            this.until = Calendar.getInstance();
            this.until.setTime(simpleDateFormat.parse(until));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

}