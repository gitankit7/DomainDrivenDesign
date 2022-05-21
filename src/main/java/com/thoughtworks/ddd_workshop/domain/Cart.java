package com.thoughtworks.ddd_workshop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.List.copyOf;

public class Cart {

  private List<Item> items;
  private List<String> removedItemsName;

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
      Optional<Item> first = items.stream()
              .filter(item -> item.getProduct().equals(p))
              .findFirst();
        first.ifPresent(item -> {items.remove(item);
        if(removedItemsName == null) {
            removedItemsName = new ArrayList<>();
        }
            removedItemsName.add(p.getName());
        });
  }

    public List<String> getRemovedItems() {
        return copyOf(removedItemsName);
    }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Cart cart = (Cart) o;
//    return items.equals(cart.items);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(items);
//  }
}
