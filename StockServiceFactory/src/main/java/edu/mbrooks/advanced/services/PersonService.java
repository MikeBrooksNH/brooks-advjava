package edu.mbrooks.advanced.services;

import java.util.List;
import edu.mbrooks.advanced.model.Person;
import edu.mbrooks.advanced.model.StockSymbols;


public interface PersonService {


    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Person> getPerson() throws PersonServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdatePerson(Person person) throws PersonServiceException;

    /**
     * Get a list of all a person's hobbies.
     *
     * @return a list of hobby instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<StockSymbols> getStockSymbols(Person person) throws PersonServiceException;

    /**
     * Assign a hobby to a person.
     *
     * @param hobby  The hobby to assign
     * @param person The person to assign the hobby too.
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    public void addStockToPerson(StockSymbols hobby, Person person) throws PersonServiceException;


}
