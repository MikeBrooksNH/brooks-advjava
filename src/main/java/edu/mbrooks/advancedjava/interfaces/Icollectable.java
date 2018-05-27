/**
 * Program Name:    Icollectable.java
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 */

package edu.mbrooks.advancedjava.interfaces;

/**
 *
 * @author michaelbrooks
 * This is a class to setup the basics of what a general collection informaiton is should have
 */
public interface Icollectable {

    // what's being collected
    String getCollectableType();
    void setCollectableType(String name);

    // is it valuable or not
    boolean getValuable();
    void setValuable(boolean ofValue);
}
