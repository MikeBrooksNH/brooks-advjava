package edu.mbrooks.advanced.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Quotes {

    private int id;
    private String symbol;
    private Timestamp time;
    private BigDecimal price;

    /**
     * Constructor that initializes the symbol to INTC and the price to 59.99
     */
    public Quotes () {
        try {
            symbol = "INTC";
            price = new BigDecimal("59.99");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * getter for the row ID
     * @return id dtabase column id
     */
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    /**
     * setter for the record ID - used for testing
     * @param id database id column
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the stock symbol
     * @return symbol stock symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, length = 4)
    public String getSymbol() {
        return symbol;
    }

    /**
     * setter for the symbol
     * @param symbol to set this record to
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * getter for this record
     * @return Timestamp time of the quote
     */
    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    /**
     * setter for the time of the quote
     * @param time time of the quote
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * getter for the price contained in this record
     * @return price quote price at the time
     */
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * setter for the price on this record
     * @param price quote price at the time
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
        Quotes quotes = (Quotes) o;
        return id == quotes.id &&
                price == quotes.price &&
                Objects.equals(symbol, quotes.symbol) &&
                Objects.equals(time, quotes.time);
    }

    /**
     *
     * @return hashcode for this object
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, time, price);
    }


    /**
     * Create a standard string for this class
     * @return string standard string format
     */
    public String toString() {
        return "Quote{ symbol='" + symbol +
                "', price=" + price +
                ", date=" + time +
                "}";
    }

}
