package edu.mbrooks.advanced.apps.stockquote;

import edu.mbrooks.advanced.model.*;
import edu.mbrooks.advanced.services.*;
import edu.mbrooks.advanced.util.DatabaseUtils;
import edu.mbrooks.advanced.services.StockTradingServiceException;
import edu.mbrooks.advanced.xml.Stock;
import edu.mbrooks.advanced.xml.Stocks;
import org.hibernate.Session;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static edu.mbrooks.advanced.util.DatabaseUtils.getSessionFactory;

/**
 * A simple application that shows the StockService in action.
 */
public class BasicStockQuoteApplication {

    private StockService stockService;

    // an example of how to use enum - not part of assignment 3 but useful for assignment 4

    /**
     * An enumeration that indicates how the program terminates (ends)
     */
    private enum ProgramTerminationStatusEnum {

        // for now, we just have normal or abnormal but could more specific ones as needed.
        NORMAL(0),
        ABNORMAL(-1),
        STOCKTRADING(-2),
        DATE(-3),
        PRICE(-4);

        // when the program exits, this value will be reported to underlying OS
        private int statusCode;

        /**
         * Create a new  ProgramTerminationStatusEnum
         *
         * @param statusCodeValue the value to return the OS. A value of 0
         *                        indicates success or normal termination.
         *                        non 0 numbers indicate abnormal termination.
         */
        private ProgramTerminationStatusEnum(int statusCodeValue) {
            this.statusCode = statusCodeValue;
        }

        /**
         * @return The value sent to OS when the program ends.
         */
        private int getStatusCode() {
            return statusCode;
        }
    }

    /**
     * Create a new Application.
     *
     * @param stockService the StockService this application instance should use for
     *                     stock queries.
     *                     <p/>
     *                     NOTE: this is a example of Dependency Injection in action.
     */
    public BasicStockQuoteApplication(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Given a <CODE>stockQuery</CODE> get back a the info about the stock to display to th user.
     *
     * @param stockQuery the stock to get data for.
     * @return a String with the stock data in it.
     * @throws StockServiceException If data about the stock can't be retrieved. This is a
     *                               fatal error.
     */
    public String displayStockQuotes(StockQuery stockQuery) throws StockServiceException {
        StringBuilder stringBuilder = new StringBuilder();

        List<StockQuote> stockQuotes =
                stockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());

        stringBuilder.append("Stock quotes for: " + stockQuery.getSymbol() + "\n");
        for (StockQuote stockQuote : stockQuotes) {
            stringBuilder.append(stockQuote.toString());
        }

        return stringBuilder.toString();
    }

    /**
     * Terminate the application.
     *
     * @param statusCode        an enum value that indicates if the program terminated ok or not.
     * @param diagnosticMessage A message to display to the user when the program ends.
     *                          This should be an error message in the case of abnormal termination
     *                          <p/>
     *                          NOTE: This is an example of DRY in action.
     *                          A program should only have one exit point. This makes it easy to do any clean up
     *                          operations before a program quits from just one place in the code.
     *                          It also makes for a consistent user experience.
     */
    private static void exit(ProgramTerminationStatusEnum statusCode, String diagnosticMessage) {
        if (statusCode == ProgramTerminationStatusEnum.NORMAL) {
            System.out.println(diagnosticMessage);
        } else if (statusCode == ProgramTerminationStatusEnum.ABNORMAL) {
            System.err.println(diagnosticMessage);
        } else {
            throw new IllegalStateException("Unknown ProgramTerminationStatusEnum.");
        }
        System.exit(statusCode.getStatusCode());
    }

    /**
     * Run the StockTicker application.
     * <p/>
     * When invoking the program supply one ore more stock symbols.
     *
     * @param args one or more stock symbols
     */
    public static void main(String[] args)  throws JAXBException {

        // be optimistic init to positive values
        ProgramTerminationStatusEnum exitStatus = ProgramTerminationStatusEnum.NORMAL;
        String programTerminationMessage = "Normal program termination.";
        Quotes quote = new Quotes();

        if (args.length != 3) {
            exit(ProgramTerminationStatusEnum.ABNORMAL,
                    "Please supply 3 arguments a stock symbol, a start date (MM/DD/YYYY) and end date (MM/DD/YYYY)");
        }


        Stocks stocks = new Stocks();


        // Read XML data
        File file = new File("stock_info.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        stocks = (Stocks) unmarshaller.unmarshal(file);


        try {
            StockQuery stockQuery = new StockQuery(args[0], args[1], args[2]);
            DatabaseStockService dbstockService = StockServiceFactory.getInstance();
            StockQuote q = dbstockService.getQuote(args[0]);

            //Call this 1 time - there is no preconcieved notion that it is being called multiple times AND the loop line is much easier to read - succinct
            List<StockQuote> tempList = dbstockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil(), StockQuote.Interval.WEEKLY);

            for (StockQuote aQuote : tempList) {
                System.out.println(aQuote.toString());
            }

            BasicStockQuoteApplication basicStockQuoteApplication = new BasicStockQuoteApplication(dbstockService);
            basicStockQuoteApplication.displayStockQuotes(stockQuery);
        } catch (ParseException e) {
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "Invalid date data: " + e.getMessage();
        } catch (StockServiceException e) {
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "StockService failed: " + e.getMessage();
        }


        try {
            Connection connection = DatabaseUtils.getHibernateConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person;");

            DatabasePersonService PersonStocks = ServiceFactory.getInstance(); // DatabasePersonService();
            PersonStocks ph = new PersonStocks();
            Person person = new Person();


            while (resultSet.next()) {
                person.setId(resultSet.getInt("ID"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setBirthDate(resultSet.getTimestamp("birth_date"));

                System.out.println(person.toString());
                List<StockSymbols> phl = PersonStocks.getStockSymbols(person);
                for (StockSymbols h : phl) {
                    System.out.println("\t" + h.toString());
                }
            }

            // print out all the stocks
            for (Stock stock : stocks.getStock()) {
                System.out.println(stock.toString());
                System.out.println("Beginning Transaction...");

                quote.setSymbol(stock.getSymbol());

                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator(',');
                symbols.setDecimalSeparator('.');
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.0#", symbols);
                decimalFormat.setParseBigDecimal(true);

                // parse the string
                try {
                    quote.setPrice((BigDecimal) decimalFormat.parse(stock.getPrice()));
                    //quote.setPrice(new BigDecimal(stock.getPrice()));
                } catch (ParseException pe) {
                    System.out.println("Error parsing the quote price");
                    System.exit(-1);
                }
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date parsedDate = dateFormat.parse(stock.getTime());
                    quote.setTime(new java.sql.Timestamp(parsedDate.getTime()));
                } catch(Exception e) {
                    System.out.println("Error Setting the correct date format");
                    System.exit(-1);
                }

                // write the XML data to the DB
                Session session = getSessionFactory().openSession();

                session.beginTransaction();
                session.save(quote);
                session.getTransaction().commit();
                session.close();
                System.out.println(quote.toString());

            }

        } catch (Exception e) {
            System.out.println("Handle Exception...");
            System.out.println(e.toString());
            System.exit(-1);
        }

        try {
            StockTradingService stocktradingservice = WebStockServiceFactory.getInstance();

            Quotes tmpQuote = new Quotes();
            tmpQuote = stocktradingservice.getWebServiceQuote("INTC");

            Session session = getSessionFactory().openSession();

            session.beginTransaction();
            session.save(tmpQuote);
            session.getTransaction().commit();
            session.close();

            System.out.println(tmpQuote.toString());
        } catch (StockTradingServiceException e) {
            System.out.println("Error getting the stock quote from the web service");
            System.out.println(e);
            System.exit(-1);
        }
    }
}
