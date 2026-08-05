package edu.mbrooks.advanced.services;


import edu.mbrooks.advanced.model.Person;
import edu.mbrooks.advanced.model.PersonStocks;
import edu.mbrooks.advanced.model.StockSymbols;
import edu.mbrooks.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DatabasePersonService implements PersonService {


    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPerson() throws PersonServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();


        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     */



    @Override
    public void addOrUpdatePerson(Person person) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }

    /**
     * Get a list of all a person's symbols.
     *
     * @param person the person
     * @return a list of StockSymbols instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<StockSymbols> getStockSymbols(Person person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<StockSymbols> symbols = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonStocks.class);
            criteria.add(Restrictions.eq("person", person));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            List<PersonStocks> list = criteria.list();
            for (PersonStocks PersonStocks : list) {
                symbols.add(PersonStocks.getStockSymbols());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return symbols;

    }


    /**
     * Assign a StockSymbols to a person.
     *
     * @param StockSymbols  The StockSymbols to assign
     * @param person The person to assign the StockSymbols too.
     */
    @Override
    public void addStockToPerson(StockSymbols StockSymbols, Person person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersonStocks PersonStocks = new PersonStocks();
            PersonStocks.setStockSymbols(StockSymbols);
            PersonStocks.setPerson(person);
            session.saveOrUpdate(PersonStocks);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }



}
