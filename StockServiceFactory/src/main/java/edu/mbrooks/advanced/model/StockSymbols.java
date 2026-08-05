package edu.mbrooks.advanced.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class StockSymbols {
    private int id;
    private String symbol;
    private String companyName;
    private Collection<PersonStocks> personStocksBySymbolId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Symbol", nullable = false, length = 5)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "CompanyName", nullable = false, length = 50)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockSymbols that = (StockSymbols) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, companyName);
    }

    @Override
    public String toString() {
        return "StockSymbols{ symbol='" + symbol +
                "', companyName= '" + companyName +
                "'}";
    }
}
