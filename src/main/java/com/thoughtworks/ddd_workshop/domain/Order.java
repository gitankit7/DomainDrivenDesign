package com.thoughtworks.ddd_workshop.domain;

import java.util.List;

public class Order {
    public Order(List<Product> productsList) {
        this.checkedOutCartProducts = productsList;
    }

    private List<Product> checkedOutCartProducts;

    public List<Product> getCheckedOutCartProducts() {
        return checkedOutCartProducts;
    }
}
