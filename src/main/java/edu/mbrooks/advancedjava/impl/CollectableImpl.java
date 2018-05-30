/**
 * Program Name:    Collectable.java
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     Implementation of the collectable interface
 */

package edu.mbrooks.advancedjava.impl;

import edu.mbrooks.advancedjava.interfaces.Icollectable;

/**
 *
 * @author michaelbrooks
 * This is a class to setup if there is a collection of valuables, or a bunch of trash
 */
public class CollectableImpl implements Icollectable {

    String pileOf;
    boolean getRich;

    /**
     *
     * @return String what's being collected
     */
    public String getCollectableType() {
        return this.pileOf;
    }

    /**
     *
     * @param String what's being collected
     */
    public void setCollectableType(String collectionType) {
        this.pileOf = collectionType;
    }

    /**
     *
     * @return boolean  is there value in this collection or not
     */
    public boolean getValuable() {
        return this.getRich;
    }

    /**
     *
     * @param boolean is there value in this collection or not
     */
    public void setValuable(boolean ofValue) {
        this.getRich = ofValue;
    }

    @Override
    /**
     * putting the collection type and realative value posibility into a string
     */
    public String toString() {

        String retVal = this.pileOf;

        if (this.getRich) {
            retVal += " could be a valuable collection";
        } else {
            retVal += " might not be worth the time";
        }

        return retVal;
    }
}
