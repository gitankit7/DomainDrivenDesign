package com.thoughtworks.ddd_workshop.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.copyOf;

public class Cart {

  private List<Item> items;

  public void addItem(Item item) {
    if (items == null) {
      items = new ArrayList<>();
    }
    items.add(item);
  }

  public List<Item> getItems() {
    return copyOf(items);
  }

  public void remove(Product p) {
    items.stream()
        .filter(item -> item.getProduct().equals(p))
        .findFirst()
        .ifPresent(item -> items.remove(item));
  }
}
