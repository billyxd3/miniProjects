package com.softserve.dto;

import com.softserve.annotation.Column;
import com.softserve.annotation.Table;

@Table(name = "cars")
public class Car {
    @Column(name = "id")
    private int id;
    @Column(name = "brand",length = 30)
    private String brand;
    @Column(name ="model",length = 50)
    private String model;
    @Column(name = "year",length = 4)
    private int year;
    @Column(name = "number",length = 10)
    private String number;
    @Column(name = "vin_code",length = 18)
    private String vinCode;

    public Car(int id, String brand, String model, int year, String number, String vinCode) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.number = number;
        this.vinCode = vinCode;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getNumber() {
        return number;
    }

    public String getVinCode() {
        return vinCode;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", number='" + number + '\'' +
                ", vinCode='" + vinCode + '\'' +
                '}';
    }
}
