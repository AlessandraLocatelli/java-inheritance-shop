package org.java.inheritance;

import java.math.BigDecimal;

public class Smartphones extends Product {

   long imeiCode;
   int memory;




    public Smartphones(String name, String brand, BigDecimal price, BigDecimal vat, long imeiCode, int memory) {
        super(name, brand, price, vat);
        this.imeiCode = imeiCode;
        this.memory = memory;
    }
}
