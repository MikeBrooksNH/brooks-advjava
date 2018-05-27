/**
 * Program Name:    Currency.java
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
    private enum Type {
        paper, coin;
    }

    private Type currencyType;

    Currency () {
        super.setName("");
        super.setValue("");
        super.setYear("0000");
        this.currencyType = Currency.Type.paper; // assume everything is paper unless it isn't...

    }
}

