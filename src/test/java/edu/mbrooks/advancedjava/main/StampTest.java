package edu.mbrooks.advancedjava.main;

import junit.framework.TestCase;

public class StampTest extends TestCase {

    public void testSetStampDefaultConstructor() {
        Stamp mystamp = new Stamp();

        assertTrue("Default Constructor", mystamp.getYear().equalsIgnoreCase("0000"));
    }

    public void testSetStampFullConstructor() {
        Stamp mystamp = new Stamp("Penny Black", "1 British Cent", "1840", "Great Britan");

        assertTrue("Full Constructor", mystamp.getYear().equalsIgnoreCase("1840"));
    }

    public void testSetStamp() {
        Stamp mystamp = new Stamp();
        String expectedResult = "Stamp{name : Sally Ride, value : Forever, year : 2018, country : US }";

        mystamp.setStamp("Sally Ride", "Forever", "2018", "US");

        assertTrue("Set Stamp", mystamp.toString().equalsIgnoreCase(expectedResult));
    }

  /*  public void testSetStamp() {
        Stamp mystamp = new Stamp();
        String expectedResult = "Stamp{name : Sally Ride, value : Forever, year : 2018, country : US }";

        mystamp.setStamp("Sally Ride", "Forever", "2018", "US");

        assertTrue("Set Stamp", mystamp.toString().equalsIgnoreCase(expectedResult));
    } */
}