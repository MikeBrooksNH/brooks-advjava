/**
 * Program Name:    Currency.java
 * Author:          Michael Brooks
 * Version:         Version 1.0
 * Course:          Advanced Java Programming, Summer 2018
 * Copyright:       (C) 2018 Michael A. Brooks
 * Description:     collectable currency (coin / paper money collector)
 */
package edu.mbrooks.advancedjava.main;

/**
 *
 * @author michaelbrooks
 * This is for the collection of coins and paper money
 */
public class Currency  extends Collectable {
    public enum Type {
        paper, coin;
    }

    private Type currencyType;
    private String country;

    /**
     * Default constructor
     */
    public Currency () {
        super.setName("");
        super.setFaceValue("");
        super.setYear("0000");
        this.country = "";
        this.currencyType = Currency.Type.paper; // assume everything is paper unless it isn't...

    }

    /**
     *
     * @param String name of the item
     * @param String face value of the item
     * @param String yr of the minting
     * @param Sting country of origin
     * @param Curreny.Type type of currency - paper or coin
     *
     * Complete constructor
     *
     */
    public Currency (String name, String val, String yr, String country, Currency.Type cType) {
        super.setName(name);
        super.setFaceValue(val);
        super.setYear(yr);
        this.country = country;
        this.currencyType = cType;
    }

    /**
     *
     * @return Currency.Type type of currency - paper or coin
     *
     */
    public Type getCurrencyType() {
        return currencyType;
    }

    /**
     *
     * @param Currency.Type - paper or coin
     */
    public void setCurrencyType(Type currencyType) {
        this.currencyType = currencyType;
    }

    /**
     *
     * @return String country of origin
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param String country of origin
     */
    public void setCountry(String country) {
        this.country = country;
    }


}

