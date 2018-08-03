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
public class RequestWebQuoteInfo extends HttpServlet {

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
        String cfgFileName = "server.properties";
        appSettings.load(cfgFileName);

        String DB_URL = appSettings.getConnectionString();
        String USER = appSettings.getDBUser();
        String PASS = appSettings.getDBPass();


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
        out.println("<title>Request Web Stock Quote Information Example</title>");
        out.println("</head>");
        out.println("<body>");
        //Get a web quote
        try {
            StockTradingService stocktradingservice = WebStockServiceFactory.getInstance();

            Quotes tmpQuote = new Quotes();
            tmpQuote = stocktradingservice.getWebServiceQuote(symbol);

            out.println(tmpQuote.toString() + "<br>");

        } catch (StockTradingServiceException e) {
            System.out.println("Error getting the stock quote from the web service");
            System.out.println(e);
            System.exit(-1);
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