/**
 * Program Name:    Collectable.java
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     Implementation of the collectable interface
 */
package edu.mbrooks.advancedjava.main;

/**
 *
 * @author michaelbrooks
 * This is a collection of something
 */
public class Collectable {
    private String name;
    private String year;
    private String faceValue;

    /**
     *
     * @return String name of the item is in the collection (i.e. "Penny Black" is the common name of a stamp)
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param String name of the item in the collection (i.e. "Penny Black" is the common name of a stamp)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return String year that the item is from (i.e. The Penny Black was from 1840)
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param String year that the item is from (i.e. The Penny Black was from 1840)
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return String face faceValue of the item (i.e. the Penny Black is 1 British Cent)
     */
    public String getFaceValue() {
        return faceValue;
    }

    /**
     *
     * @param String face faceValue of the item (i.e. the Penny Black is 1 British Cent)
     */
    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

}
