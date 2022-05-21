package com.thoughtworks.ddd_workshop.domain;

import java.util.Currency;

public class Price {
    private Currency currency;
    private double value;

    public Price(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
