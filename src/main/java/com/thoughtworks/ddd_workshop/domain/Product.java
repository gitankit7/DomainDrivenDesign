package com.thoughtworks.ddd_workshop.domain;

import java.util.Objects;

public final class Product {
  private final String name;

  public Product(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "Product[" +
            "name=" + name + ']';
  }

}
