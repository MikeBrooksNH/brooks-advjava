/**
 * Program Name:    Collectable.java
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
public class Collectable
{
    private String name;
    private String year;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
