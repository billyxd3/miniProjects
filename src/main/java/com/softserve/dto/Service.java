package com.softserve.dto;

import com.softserve.annotation.Column;
import com.softserve.annotation.Table;

@Table(name = "services")
public class Service {
    @Column(name = "id")
    private int id;
    @Column(name = "name",length = 30)
    private String name;
    @Column(name = "price")
    private double price;

    public Service(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
