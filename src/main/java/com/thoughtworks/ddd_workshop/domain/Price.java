package com.thoughtworks.ddd_workshop.domain;

import java.util.Currency;

public class Price {
    private Currency currency;
    private double amount;

    public Price(Currency currency, double value) {
        this.currency = currency;
        this.amount = value;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

}
