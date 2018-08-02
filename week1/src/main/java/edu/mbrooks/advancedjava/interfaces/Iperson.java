/**
 * Program Name:    Iperson.java
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 */

package edu.mbrooks.advancedjava.interfaces;

import java.util.GregorianCalendar;

/**
 *
 * @author michaelbrooks
 * This is a class to setup the basics of what a person should have
 */
public interface Iperson {

    // getter / setter for the person's name
    String getName();
    void setName(String name);

    // getter / setter for the address of the person
    String getAddress();
    void setAddress(String address);

    // getter / setter for the person's SSN
    String getSocialSecurityNumber();
    void setSocialSecurityNumber(String ssn);

    // getter / setter for DOB
    java.util.GregorianCalendar getDOB();
    void setDateOfBirth(GregorianCalendar DateOfBirth);

}
