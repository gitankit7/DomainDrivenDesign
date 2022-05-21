package com.thoughtworks.ddd_workshop.domain;

import java.util.List;
import java.util.Objects;

public class Order {
    public Order(List<Product> productsList) {
        this.checkedOutCartProducts = productsList;
    }

    private List<Product> checkedOutCartProducts;

    public List<Product> getCheckedOutCartProducts() {
        return checkedOutCartProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return checkedOutCartProducts.equals(order.checkedOutCartProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkedOutCartProducts);
    }
}
