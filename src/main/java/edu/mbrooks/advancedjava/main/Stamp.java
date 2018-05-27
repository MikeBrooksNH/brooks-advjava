/**
 * Program Name:    Stamp.java
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     Collection of stamps
 */
package edu.mbrooks.advancedjava.main;

/**
 *
 * @author michaelbrooks
 * This is to setup a stamp collection
 */
public class Stamp  extends Collectable {

    private String country;

    public Stamp () {
        super.setName("");
        super.setValue("0");
        super.setYear("0000");
        this.country = "";
    }


    public Stamp (String name, String val, String yr, String country) {
        super.setName(name);
        super.setValue(val);
        super.setYear(yr);
        this.country = country;
    }


    public void setStamp (String name, String val, String yr, String country) {
        super.setName(name);
        super.setValue(val);
        super.setYear(yr);
        this.country = country;
    }

    public String toString() {
        return "Stamp{name : " +  super.getName() + ", value : " + super.getValue() + ", year : " + super.getYear() + ", country : " + this.country + " }";
    }

}
