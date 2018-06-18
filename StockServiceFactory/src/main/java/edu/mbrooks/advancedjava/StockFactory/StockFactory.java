/*
 * Program Name:    StockFactory.java
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018
 */

/**
 * @author Michael Brooks
 * @version 1.0
 */
package edu.mbrooks.advancedjava.stockfactory;

import com.sun.prism.impl.ps.CachingEllipseRep;
import edu.mbrooks.advancedjava.stockquote.StockQuote;
import edu.mbrooks.advancedjava.stockservice.StockService;

import java.util.*;

/**
 *  The BasicStockService class implements the SockService interface
 */
class BasicStockService implements StockService {

    /**
     * emum for which quarter a date is in
     */
    private enum Quarter {
        Q1, Q2, Q3, Q4;
    }

    private Calendar cal = Calendar.getInstance();
    private StockQuote quote;
    private List<StockQuote> historyQuotes = new ArrayList<>();

    /**
     * contructor requires a quote
     *
     */
    public BasicStockService(StockQuote quote) {
        this.quote = quote;
    }

    /**
     *
     * @return quote Stock Quote
     */
    public StockQuote getQuote() {
        return (this.quote);
    }


    /**
     * @param q Stock Quote
      */
    public void addQuote(StockQuote q) {
        this.historyQuotes.add(q);
        this.quote = q; // the latest quote is always available...
    }

    /**
     *  This is a class private method that returns if the date on the quote is within the specifiec date range.
     *
     * @param chkDate   - is the date to compare
     * @param from      - start of the date range
     * @param until     - end of the date range
     * @return boolean  - either is or isn't in the date range
     */
    private boolean isQuoteInDateRange(Calendar chkDate, Calendar from, Calendar until) {

        boolean returnValue = false;

        if (chkDate.after(from) && chkDate.before(until)) {
            returnValue = true;
        } else if (chkDate.compareTo(from) == 0) {
            returnValue = true;
        } else if (chkDate.compareTo(until) == 0) {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     *
     * This is special adaptation of the Annual interval
     * While it is every 3 months, it is specific 3 month intervals
     *      Jan - Mar   =   Q1
     *      Apr - June  =   Q2
     *      Jul - Sep   =   Q3
     *      Oct - Dec   =   Q4
     *  We are assuming that the a Fiscal Quarter will line up directly with the
     *  month start and end dates rather than being "full weeks" to mark quartley boundries.
     *  (in real life, we would have to account for that scenario)
     *
     * @param chkDate   -   Date to check for what quarter it is
     * @return          -   The quater the for the date
     */
    private Quarter whatQuarter (Calendar chkDate) {

        int month = chkDate.get(Calendar.MONTH);

        Quarter returnValue = Quarter.Q1; // bogus return value...

        if ((month >= 0) && (month <= 2)) {
            returnValue = Quarter.Q1;
        } else if ((month >= 3) && (month <= 5)) {
            returnValue = Quarter.Q2;
        } else if ((month >= 6) && (month <= 8)) {
            returnValue = Quarter.Q3;
        } else if  ((month >= 9) && (month <= 11)) {
            returnValue = Quarter.Q4;
        }
        return returnValue;
    }

    /**
     *
     * @param symbol
     * @param from
     * @param until
     * @return
     */
    public List<StockQuote> getQuoteHist(String symbol, Calendar from, Calendar until, StockQuote.Interval frequency) {
        boolean hasFrequecyBeenMet = false;
        int intervalCheck = 0;
        int fuzzyTime = 0;
        boolean q1Check = false;
        boolean q2Check = false;
        boolean q3Check = false;
        boolean q4Check = false;

        List<StockQuote> returnList = new ArrayList<>();

        for (StockQuote q : this.historyQuotes){

            if (isQuoteInDateRange(q.getDateOfQuote(), from, until)) {

                switch (frequency) {
                    case HOURLY:
                        // interval needs to be some key... Using YEAR+Month+Day+Hour to get something unique
                        if  (isQuoteInDateRange(q.getDateOfQuote(),q.getDateOfQuote(),q.getDateOfQuote())) {
                            fuzzyTime =  q.getDateOfQuote().get(Calendar.YEAR) + q.getDateOfQuote().get(Calendar.DAY_OF_YEAR) + q.getDateOfQuote().get(Calendar.HOUR_OF_DAY);
                            if (fuzzyTime != intervalCheck) {
                                intervalCheck = fuzzyTime;
                                returnList.add(q);
                            }
                        }
                        break;

                     case DAILY:
                            if (q.getDateOfQuote().get(Calendar.DAY_OF_YEAR)  != intervalCheck) {
                                intervalCheck = q.getDateOfQuote().get(Calendar.DAY_OF_YEAR);
                                returnList.add(q);
                            }
                            break;
                    case WEEKLY:
                       if (q.getDateOfQuote().get(Calendar.WEEK_OF_YEAR) != intervalCheck) {
                            intervalCheck = q.getDateOfQuote().get(Calendar.WEEK_OF_YEAR);
                            returnList.add(q);
                        }
                        break;
                    case MONTHLY:
                        if (q.getDateOfQuote().get(Calendar.MONTH) != intervalCheck) {
                            intervalCheck = q.getDateOfQuote().get(Calendar.MONTH);
                            returnList.add(q);
                        }
                        break;
                    case QUARTERLY:

                        int month = q.getDateOfQuote().get(Calendar.MONTH);

                        if (q.getDateOfQuote().get(Calendar.YEAR) != intervalCheck) {
                            // flipping this on the annual rollover
                            intervalCheck = q.getDateOfQuote().get(Calendar.YEAR);
                            // reset quarterly flags on the turn of the year
                            q1Check = false;
                            q2Check = false;
                            q3Check = false;
                            q4Check = false;
                        }

                        switch (whatQuarter(q.getDateOfQuote())) {
                            case Q1:
                                if (!q1Check) {
                                    q1Check = true;
                                    returnList.add(q);
                                }
                                break;
                            case Q2:
                                if (!q2Check) {
                                    q2Check = true;
                                    returnList.add(q);
                                }
                                break;
                            case Q3:
                                if (!q3Check) {
                                    q3Check = true;
                                    returnList.add(q);
                                }
                                break;
                            case Q4:
                                if (!q4Check) {
                                    q4Check = true;
                                    returnList.add(q);
                                }
                                break;
                        }
                        break;
                    case ANNUALLY:
                        if (q.getDateOfQuote().get(Calendar.YEAR) != intervalCheck) {
                            intervalCheck = q.getDateOfQuote().get(Calendar.YEAR);
                            returnList.add(q);
                        }
                        break;
                }



/*                if (frequency == StockQuote.Interval.DAILY) {
                    if (q.getDateOfQuote().get(Calendar.DAY_OF_YEAR)  != intervalCheck) {
                        // for now we're assuming a quote a day
                        intervalCheck = q.getDateOfQuote().get(Calendar.DAY_OF_YEAR);
                        returnList.add(q);
                    }
                } else if (frequency == StockQuote.Interval.WEEKLY) {
                    if (q.getDateOfQuote().get(Calendar.WEEK_OF_YEAR) != intervalCheck) {
                        intervalCheck = q.getDateOfQuote().get(Calendar.WEEK_OF_YEAR);
                        returnList.add(q);
                    }
                } else if (frequency == StockQuote.Interval.MONTHLY) {
                    if (q.getDateOfQuote().get(Calendar.MONTH) != intervalCheck) {
                        intervalCheck = q.getDateOfQuote().get(Calendar.MONTH);
                        returnList.add(q);
                    }
                } else if (frequency == StockQuote.Interval.QUARTERLY) {

                    int month = q.getDateOfQuote().get(Calendar.MONTH);

                    if (q.getDateOfQuote().get(Calendar.YEAR) != intervalCheck) {
                        // flipping this on the annual rollover
                        intervalCheck = q.getDateOfQuote().get(Calendar.YEAR);
                        // reset quarterly flags on the turn of the year
                        q1Check = false;
                        q2Check = false;
                        q3Check = false;
                        q4Check = false;
                    }

                    switch (whatQuarter(q.getDateOfQuote())) {
                        case Q1:
                            if (!q1Check) {
                                q1Check = true;
                                returnList.add(q);
                            }
                            break;
                        case Q2:
                            if (!q2Check) {
                                q2Check = true;
                                returnList.add(q);
                            }
                            break;
                        case Q3:
                            if (!q3Check) {
                                q3Check = true;
                                returnList.add(q);
                            }
                            break;
                        case Q4:
                            if (!q4Check) {
                                q4Check = true;
                                returnList.add(q);
                            }
                            break;
                    }

                }  else if (frequency == StockQuote.Interval.ANNUALLY) {
                         if (q.getDateOfQuote().get(Calendar.YEAR) != intervalCheck) {
                            intervalCheck = q.getDateOfQuote().get(Calendar.YEAR);
                            returnList.add(q);
                    }
                }*/
            }
        }
        return returnList;
    }

    /**
     * print the full quote history
     */
    public void printHist() {
        for (StockQuote q : this.historyQuotes){
            System.out.println(q.toString());
        }
    }
}

/**
 * Factory class for returning instances of the stockservice
 */
public class StockFactory {
    /**
     * Returns a Stock service
     *
     * @param quote that is a Stock Quote
     *
     * @return and instance of BasicStockService
     */
    public StockService getStockService(StockQuote quote) {
        return (new BasicStockService(quote));
    }

}
