package edu.mbrooks.advanced.model;

import javax.persistence.*;

@Entity
@Table(name = "person_stocks", catalog = "stocks") // removed before catalog: schema = "stocks", 
public class PersonStocks {
    private int id;
    private Person person;
    private StockSymbols stocksymbols;

    /**
     * Create a PersonStocks that needs to be initialized
     */
    public PersonStocks() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStocks
     *
     * @param person the person to assign the stocksymbol to
     * @param stocksymbols  the stocksymbol to associate the person with
     */
    public PersonStocks(Person person, StockSymbols stocksymbols) {
        setStockSymbols(stocksymbols);
        setPerson(person);
    }

    /**
     * Primary Key - Unique ID for a particular row in the person_stocks table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person_stocks table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for a person based on id
     * @return get the Person associated with this stocksymbol
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person associated with the stocksymbol.
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * getter for a stock symbol based on the id
     * @return get the StockSymbol  associated with this Person
     */
    @ManyToOne
    @JoinColumn(name = "symbol_id", referencedColumnName = "ID", nullable = false)
    public StockSymbols getStockSymbols() {
        return stocksymbols;
    }

    /**
     * Specify the StockSymbol associated with the Person.
     *
     * @param stocksymbols a person instance
     */
    public void setStockSymbols(StockSymbols stocksymbols) {
        this.stocksymbols = stocksymbols;
    }

    /**
     *
     * @param o to compare
     * @return boolean if it is a PersonStock or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStocks that = (PersonStocks) o;

        if (id != that.id) return false;

        return true;
    }

    /**
     *
     * @return hashcode for this object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + stocksymbols.hashCode();
        return result;
    }

    /**
     *
     * @return standard string representation of this class
     */
    @Override
    public String toString() {
        return "PersonStocks{" +
                "id=" + id +
                ", person='" + person +
                "', stocksymbol='" + stocksymbols +
                "'}";
    }
}
