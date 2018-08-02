/**
 * Program Name:    StampCollector.java
 * Author:          Michael Brooks
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     A person that has stamps (and what they are)
 *                  This is the class to demontrate dependency injection
 */
package edu.mbrooks.advancedjava.main;

import java.util.List;
import edu.mbrooks.advancedjava.impl.*;

/**
 *
 * @author michaelbrooks
 * This is putting together a stamp collector with a collection of stamps
 */
public class StampCollector {

    private Person collector;
    private List<Stamp> stamps;

    /**
     *
     * @param Person collector's information
     * @param List<Stamp> the person's stamp collection
     */
    StampCollector(Person collector, List<Stamp> stamps) {
        this.collector = collector;
        this.stamps = stamps;
    }

    /**
     * iterate through the list of stamps displaying to the terminal window
     */
    public void printStamps() {
        for (Stamp aStamp : this.stamps ) {
            System.out.println(aStamp.toString());
        }
    }
}
