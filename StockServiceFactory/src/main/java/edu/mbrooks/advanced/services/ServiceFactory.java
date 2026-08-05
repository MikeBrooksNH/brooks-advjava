package edu.mbrooks.advanced.services;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}


    /**
     *
     * @return get a <CODE>PersonService</CODE> instance
     */
    public static DatabasePersonService getInstance() {
        return new DatabasePersonService();
    }


}
