package org.java.inheritance;

import java.math.BigDecimal;

public class Tv extends Product{

    int dimension;
    boolean type;


    public Tv(String name, String brand, BigDecimal price, BigDecimal vat, int dimension, boolean type) {
        super(name, brand, price, vat);
        this.dimension = dimension;
        this.type = type;
    }
}
