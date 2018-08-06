package edu.mbrooks.advanced.servlet;


import edu.mbrooks.advanced.model.Quotes;
import edu.mbrooks.advanced.model.StockQuery;
import edu.mbrooks.advanced.model.StockQuote;
import edu.mbrooks.advanced.services.*;
import edu.mbrooks.advanced.util.ProgramConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * Example servlet from the apache tomcat distribution
 */
public class RequestQuoteInfo extends HttpServlet {

    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String FROM_PARAMETER_KEY = "from";
    private static final String UNTIL_PARAMETER_KEY = "until";
    private static final String FREQUENCY_PARAMETER_KEY = "frequency";

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
     *
     * @param request http request
     * @param response http response
     * @throws IOException i/o exception
     * @throws ServletException servlet exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // load the application properties

        ProgramConfiguration appSettings = new ProgramConfiguration();
        String cfgFileName = "/usr/local/server.properties";
        appSettings.load(cfgFileName);


        String DB_URL = appSettings.getConnectionString();
        String USER = appSettings.getDBUser();
        String PASS = appSettings.getDBPass();
        String VERSION = appSettings.getVersion();

        
        // get the request parameters from the calling jsp
        String symbol = request.getParameter(SYMBOL_PARAMETER_KEY);
        String from = request.getParameter(FROM_PARAMETER_KEY);
        String until = request.getParameter(UNTIL_PARAMETER_KEY);
        String frequency = request.getParameter(FREQUENCY_PARAMETER_KEY);

        ProgramTerminationStatusEnum exitStatus = ProgramTerminationStatusEnum.NORMAL;
        String programTerminationMessage = "Normal program termination.";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");

        //Using Bootstrap ((references to the online version only
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");

        out.println("<title>Request Stock Quote Information Example</title>");
        out.println("</head>");
        out.println("<body>");
/*
        out.println("<h2>Request Information from the Database Example</h2><br>");
        out.println("<h3>Properties File Contents</h3><br>");
        out.println("Connection String = " + DB_URL + "<br>");
        out.println("DB User = " + USER + "<br>");
        out.println("DB Password = " + PASS + "<br><hr>");

        out.println("Request URI: " + request.getRequestURI());
*/
        try {
            StockQuery stockQuery = new StockQuery(symbol, from, until);
            DatabaseStockService dbstockService = StockServiceFactory.getInstance();
            StockQuote q = dbstockService.getQuote(symbol, DB_URL, USER, PASS);

            out.println("<h3>Get a quotes from the DB using connection info in the properties file...</h3><br>");
            out.println(q.toString() + "<br><br><hr>");

            //Call this 1 time - there is no preconcieved notion that it is being called multiple times AND the loop line is much easier to read - succinct
            List<StockQuote> tempList = dbstockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil(), StockQuote.Interval.WEEKLY);

            out.println("<h3>Get a list of quotes...</h3><br>");
            out.println("<table  class=\"table table-striped\">");
            out.println("<tr><th>Symbol</th><th>Date</th><th>Price</th></tr>");
            for (StockQuote aQuote : tempList) {
                out.println("<tr>");
                out.println("<td>" + aQuote.getSymbol() + "</td>");
                out.println("<td>" + aQuote.getDate().toString() + "</td>");
                out.println("<td>" + aQuote.getPrice().toString() + "</td>");
            }
            out.println("</table>");

            out.println(PrintFooter.Footer(VERSION));
        } catch (ParseException e) {
            out.println("Parse Excpetion " + e);
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "Invalid date data: " + e.getMessage();

        } catch (StockServiceException e) {
            out.println("StockServiceException " + e);
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "StockService failed: " + e.getMessage();
        } catch (Exception e) {
            out.println("calls were:");
            out.print("dbstockService.getQuote(" + symbol + ", " + DB_URL +", " + USER + ", " + PASS + ");");
            out.println("Exception " + e);
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "StockService failed: " + e.getMessage();
        }

        out.println("</body>");
        out.println("</html>");
    }

    /**
     * We are going to perform the same operations for POST requests
     * as for GET methods, so this method just sends the request to
     * the doGet method.
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}