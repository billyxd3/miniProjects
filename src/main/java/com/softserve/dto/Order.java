package com.softserve.dto;

import com.softserve.annotation.Column;
import com.softserve.annotation.Table;

@Table(name = "orders")
public class Order {

    @Column(name = "id")
    private int id;
    @Column(name = "price")
    private double price;

    public Order(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
