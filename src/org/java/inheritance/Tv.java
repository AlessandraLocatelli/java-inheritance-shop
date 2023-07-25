package org.java.inheritance;

import java.math.BigDecimal;

public class Tv extends Product{

    int dimension;
    String type;


    public Tv(String name, String brand, BigDecimal price, BigDecimal vat, int dimension, String type) {
        super(name, brand, price, vat);
        this.dimension = dimension;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Tv{" +
                "code=" +getCode() +
                ",name=" + getName() +
                ",brand=" + getBrand() +
                ",price=" + getPrice() +
                ",vat=" + getVat() +
                ",dimension=" + dimension +
                ",type='" + type + '\'' +
                '}';
    }
}
