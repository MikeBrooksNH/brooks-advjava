package edu.mbrooks.advanced.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Objects;

@Entity
public class StockSymbols {
    private int id;
    private String symbol;
    private String companyName;
    private Collection<PersonStocks> personStocksBySymbolId;

    /**
     * getter for id for this record
     * @return id - database id column
     */
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    /**
     * setter for the id of this record - this is only used for testing
     * @param id - database id column
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the symbol
     * @return symbol - stock symbol
     */
    @Basic
    @Column(name = "Symbol", nullable = false, length = 5)
    public String getSymbol() {
        return symbol;
    }

    /**
     * setter for the record's symbol
     * @param symbol - stock symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * getter for the company name for this record
     * @return companyName - name of the company for the stock
     */
    @Basic
    @Column(name = "CompanyName", length = 50)
    public String getCompanyName() {
        return companyName;
    }

    /**
     * setter for the company name
     * @param companyName - name of the company for the stock
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * verify that the objects are the same
     * @param o Object to compare
     * @return boolean if the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockSymbols that = (StockSymbols) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(companyName, that.companyName);
    }

    /**
     *
     * @return hashcode for this object
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, companyName);
    }

    /**
     * Create a standard string for this class
     * @return string - standard string for this object
     */
    @Override
    public String toString() {
        return "StockSymbols{ symbol='" + symbol +
                "', companyName= '" + companyName +
                "'}";
    }
}
