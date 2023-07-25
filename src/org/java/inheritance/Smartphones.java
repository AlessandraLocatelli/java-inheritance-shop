package org.java.inheritance;

import java.math.BigDecimal;

public class Smartphones extends Product {

   long imeiCode;
   String memory;




    public Smartphones(String name, String brand, BigDecimal price, BigDecimal vat, long imeiCode, String memory) {
        super(name, brand, price, vat);
        this.imeiCode = imeiCode;
        this.memory = memory;
    }


    @Override
    public String toString() {



        return "Smartphones{" +
                "code=" +getCode() +
                ",name=" + getName() +
                ",brand=" + getBrand() +
                ",price=" + getPrice() +
                ",vat=" + getVat() +
                ",imeiCode=" + imeiCode +
                ",memory=" + memory +
                '}';
    }
}
