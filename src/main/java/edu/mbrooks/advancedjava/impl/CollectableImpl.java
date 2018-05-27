/**
 * Program Name:    Collectable.java
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
     * @return String person's name
     * what's being collected
     */
    public String getCollectableType() {
        return this.pileOf;
    }

    /**
     *
     * @param String
     * What kind of collection
     */
    public void setCollectableType(String collectionType) {
        this.pileOf = collectionType;
    }

    /**
     *
     * @return boolean
     * Can I get rich or not
     */
    // is it valuable or not
    public boolean getValuable() {
        return this.getRich;
    }

    /**
     *
     * @param boolean
     * Can I get rich or not with this collection
     */
    public void setValuable(boolean ofValue) {
        this.getRich = ofValue;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
