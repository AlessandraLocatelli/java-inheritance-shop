package org.java.inheritance;

import java.math.BigDecimal;

public class Headphones extends Product {

    String color;
    boolean type;


    public Headphones(String name, String brand, BigDecimal price, BigDecimal vat, String color, boolean type) {
        super(name, brand, price, vat);
        this.color = color;
        this.type = type;
    }

}
