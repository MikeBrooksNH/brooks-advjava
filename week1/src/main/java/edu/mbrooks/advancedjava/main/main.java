/**
 * Program Name:    main.java
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     executable to demonstrate the use of the StampCollector
 */
package edu.mbrooks.advancedjava.main;
import java.util.List;
import java.util.ArrayList;
import edu.mbrooks.advancedjava.impl.*;

/**
 *
 * @author michaelbrooks
 * This is to show the execution of the stamp collector
 */
public class main {

    public static void main(String[] args) {

        Person mike = new Person("Mike");
        List<Stamp> mikestamps = new ArrayList<Stamp>();
        Stamp postageStamp = new Stamp();

        // Stamp Collector let's all the work be done out in the things that make it up
        StampCollector collector = new StampCollector(mike, mikestamps);

        // Add a the Washington Bicentenial series to the stamp collection
        mikestamps.add(new Stamp("Washington Bicentenial", "0.5 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "1 Cent", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "1.5 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "2 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "3 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "4 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "5 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "6 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "7 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "8 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "9 Cents", "1932", "US"));
        mikestamps.add(new Stamp("Washington Bicentenial", "10 Cents", "1932", "US"));

        // loop through the list and use the .tostring method
        collector.printStamps();
    }

}
