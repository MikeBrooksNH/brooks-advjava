/**
 * Program Name:    Stamp.java
 * Author:          Michael Brooks
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

    /**
     *  Default, no argument, constructor
     *      Initializes Name and country to empty string, value is set to 0 as well as the year
     */
    public Stamp () {
        super.setName("");
        super.setFaceValue("0");
        super.setYear("0000");
        this.country = "";
    }


    /**
     *
     * @param String Name of the item
     * @param String Face Value of the item
     * @param String Year (BP is use the 4 digit year)
     * @param String Country of origin
     */
    public Stamp (String name, String val, String yr, String country) {
        super.setName(name);
        super.setFaceValue(val);
        super.setYear(yr);
        this.country = country;
    }

    /**
     *
     * @param String Name of the item
     * @param String Face Value of the item
     * @param String Year (BP is use the 4 digit year)
     * @param String Country of origin
     */
    public void setStamp (String name, String val, String yr, String country) {
        super.setName(name);
        super.setFaceValue(val);
        super.setYear(yr);
        this.country = country;
    }

    /**
     *
     * @return String to include all the information about this stamp
     */
    public String toString() {
        return "Stamp{name : " +  super.getName() + ", value : " + super.getFaceValue() + ", year : " + super.getYear() + ", country : " + this.country + " }";
    }

}
