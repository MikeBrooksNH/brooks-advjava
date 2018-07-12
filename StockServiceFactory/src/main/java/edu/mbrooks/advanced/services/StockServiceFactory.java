package edu.mbrooks.advanced.services;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class StockServiceFactory {

    /**
     * Prevent instantiations
     */
    private StockServiceFactory() {}


    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */

   public static DatabaseStockService getInstance() {
        return new DatabaseStockService();
   }

}
