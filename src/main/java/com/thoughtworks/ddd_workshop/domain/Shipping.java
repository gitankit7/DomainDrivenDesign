package com.thoughtworks.ddd_workshop.domain;

public class Shipping {
    private Order order;

    public Shipping(Order order) {
       this.order = order;
    }

    public Double getShippingCost() {
        double cost = 0d;
        double weight = 0d;
        for(Product product:  order.getCheckedOutCartProducts()) {
            cost += product.getPrice().getAmount();
            weight += product.getWeight();
        }
        return cost + weight*0.1;
    }
}
