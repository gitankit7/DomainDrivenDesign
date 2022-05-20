package com.thoughtworks.ddd_workshop.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.copyOf;

public class Cart {

    private List<CartItemWithQuantity> items;

    public void addItem(CartItemWithQuantity item) {
        if(items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public List<CartItemWithQuantity> getItems() {
        return copyOf(items);
    }
}
