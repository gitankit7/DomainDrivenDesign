package com.thoughtworks.ddd_workshop.domain;

public class Item {

  private final String name;

  public Item(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
