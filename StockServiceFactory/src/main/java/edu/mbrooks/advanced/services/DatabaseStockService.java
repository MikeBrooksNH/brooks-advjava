package edu.mbrooks.advanced.services;

import edu.mbrooks.advanced.model.StockQuote;
import edu.mbrooks.advanced.util.DatabaseConnectionException;
import edu.mbrooks.advanced.util.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {
       private List<StockQuote> stockQuotes = null;

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        // todo - this is a pretty lame implementation why?
        // Because your going through all the quotes in the DB to get only 1
        //
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from quotes where symbol = '" + symbol + "'";

            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                this.stockQuotes.add(new StockQuote(price, time, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes.get(0);
    }


    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until)  throws StockServiceException {

        // this just calls the overloadded method with an interval of daily...

        return getQuote(symbol, from, until, StockQuote.Interval.DAILY );
    }


    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, StockQuote.Interval interval)  throws StockServiceException {

        boolean hasFrequecyBeenMet = false;

        int intervalCheck = 0;
        int fuzzyTime = 0;
        int month = 0;

        List<StockQuote> returned_stockQuotes = new ArrayList<StockQuote>();

        SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String queryFromDate = queryDateFormat.format(from.getTime());
        String queryUntilDate = queryDateFormat.format(until.getTime());

        // a calendar variable
        Calendar calendar = Calendar.getInstance();


        String queryString = "select symbol, time, price from quotes where symbol = '" + symbol + "' and time > '"
                + queryFromDate + "' and time < '" + queryUntilDate + "'";

        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();

            // real simple - loop through the quotes in the results set from the DB
            ResultSet resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");

                // we have all the quotes within the range, but we need to check what the interval is...

                // let's make the date something that usable for comparing the intervals
                calendar.setTime(time);

                switch (interval) {
                    case HOURLY:
                        fuzzyTime =  calendar.get(Calendar.YEAR) + calendar.get(Calendar.DAY_OF_YEAR) + calendar.get(Calendar.HOUR_OF_DAY);
                        break;
                    case DAILY:
                        fuzzyTime =  calendar.get(Calendar.YEAR) + calendar.get(Calendar.DAY_OF_YEAR);
                        break;
                    case WEEKLY:
                        fuzzyTime =  calendar.get(Calendar.YEAR) + calendar.get(Calendar.WEEK_OF_YEAR);
                        break;
                }
                if (fuzzyTime != intervalCheck) {
                    intervalCheck = fuzzyTime;
                    returned_stockQuotes.add(new StockQuote(price, time, symbol));
                }

            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (returned_stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }

        return returned_stockQuotes;
    }

}
