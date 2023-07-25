package org.java.inheritance;

import java.math.BigDecimal;

public class Headphones extends Product {

    String color;
    String type;


    public Headphones(String name, String brand, BigDecimal price, BigDecimal vat, String color, String type) {
        super(name, brand, price, vat);
        this.color = color;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Headphones{" +
                "name=" + getName() +
                ",brand=" + getBrand() +
                ",price=" + getPrice() +
                ",vat=" + getVat() +
                ",color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
