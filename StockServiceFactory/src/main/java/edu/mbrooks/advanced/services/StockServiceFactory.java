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
        return new DatabaseStockService(); /*{
            @Override
            public StockQuote getQuote(String symbol) throws StockServiceException {
                return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
            }

            @Override
            public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) { // throws StockServiceException {
                List<StockQuote> stockQuotes = new ArrayList<>();
                Date aDay = from.getTime();
                while (until.after(aDay))  {
                    stockQuotes.add(new StockQuote(new BigDecimal(100),aDay,symbol));
                    from.add(Calendar.DAY_OF_YEAR, 1);
                    aDay = from.getTime();
                }
                return stockQuotes;
            }
        }; */
    }

}
