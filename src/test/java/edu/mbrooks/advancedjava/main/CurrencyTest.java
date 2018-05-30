package edu.mbrooks.advancedjava.main;

import junit.framework.TestCase;

public class CurrencyTest extends TestCase {

    public void testGetCurrencyTypePaper() {
        Currency bill = new Currency("Silver Certificate", "$1.00","1900", "US", Currency.Type.paper);

        assertTrue("Check Currency Type - Paper", bill.getCurrencyType() == Currency.Type.paper);
    }

    public void testGetCurrencyTypeCoin() {
        Currency bill = new Currency("Indian Head Nickle", "5 Cents","1936", "US", Currency.Type.coin);

        assertTrue("Check Currency Type - Coin", bill.getCurrencyType() == Currency.Type.coin);
    }

}