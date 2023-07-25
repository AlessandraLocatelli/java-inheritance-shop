package org.java.inheritance;

import java.math.BigDecimal;

public class Smarthphones extends Product {

   long imeiCode;
   int memory;




    public Smarthphones(String name, String brand, BigDecimal price, BigDecimal vat, long imeiCode, int memory) {
        super(name, brand, price, vat);
        this.imeiCode = imeiCode;
        this.memory = memory;
    }
}
