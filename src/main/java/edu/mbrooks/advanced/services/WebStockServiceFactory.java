package edu.mbrooks.advanced.services;

public class WebStockServiceFactory {

    /**
     * Prevent instantiations
     */
    private WebStockServiceFactory() {}


    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockTradingService getInstance() {
        return new StockTradingService();
    }



}
