/**
 * Program Name:    Iperson.java
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

    String getName();
    void setName(String name);

    String getAddress();
    void setAddress(String address);

    String getSocialSecurityNumber();
    void setSocialSecurityNumber(String ssn);

    java.util.GregorianCalendar getDOB();
    void setDateOfBirth(GregorianCalendar DateOfBirth);

}
