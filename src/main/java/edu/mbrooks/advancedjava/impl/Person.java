/**
 * Program Name:    Person.java
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     Implementation of the person interface
 */
package edu.mbrooks.advancedjava.impl;

import edu.mbrooks.advancedjava.interfaces.Iperson;

import java.util.GregorianCalendar;

/**
  * @author michaelbrooks
  * class implements a person
 */
public class Person implements Iperson {

    private String name;
    private String address;
    private String ssn;
    private java.util.GregorianCalendar dob;

    /**
     * Default constructor sets the name to an empty string
     */
    public Person (String name) {
        // this is not unusual for someone to be unnamed at birth...
        this.name = name;
    }


    /**
     *
     * @return String person's name
     */

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name person's name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return String person's address
     */

    public String getAddress() {
        return this.address;
    }

    /**
     *
     * @param address person's address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return String formatted as a 9 digit string in the form of 000-00-0000
     */

    public String getSocialSecurityNumber() {
        return ssn;
    }

    /**
     *
     * @param ssn person's social security number
     */

    public void setSocialSecurityNumber(String ssn) {
        this.ssn = ssn;
    }


    /**
     *
     * @return returns the date of birth
     */

    public java.util.GregorianCalendar getDOB() {
        return dob;
    }

    /**
     *
     * @param DateOfBirth Date the person was born
     */
    public void setDateOfBirth(GregorianCalendar DateOfBirth) {
        this.dob = DateOfBirth;
    }

}
