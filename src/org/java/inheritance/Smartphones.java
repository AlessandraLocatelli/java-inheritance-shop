package org.java.inheritance;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphones extends Product {

private String imeiCode;
private int memory;


    public Smartphones(String name, String brand, BigDecimal price, BigDecimal vat, String imeiCode, int memory)
    throws RuntimeException
    {
        super(name, brand, price, vat);
        if(imeiCode == null || imeiCode.length() != 15 )
        {
            throw new RuntimeException("imeiCode should be 15 characters long.");
        }

        if(memory < 4 || memory > 128 )
        {
            throw new RuntimeException("Insert a number between 4-128 for memory.");
        }


        this.imeiCode = imeiCode;
        this.memory = memory;
    }


    public String getImeiCode() {
        return imeiCode;
    }

    public void setImeiCode(String imeiCode) {

        if(imeiCode == null || imeiCode.length() > 15)
        {
            throw new RuntimeException("imeiCode cant be longer than 15 characters.");
        }

        this.imeiCode = imeiCode;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {

        if(memory < 4 || memory > 128 )
        {
            throw new RuntimeException("Insert a number between 4-128");
        }
        this.memory = memory;
    }


    @Override
    public BigDecimal getDiscountPrice(boolean ownsAFidelityCard) {

        BigDecimal fullPrice = getFullPrice();
        BigDecimal priceWithDiscount = BigDecimal.ZERO;
        BigDecimal discountOnPrice = BigDecimal.ZERO;

        if(memory < 32)
        {
            discountOnPrice = fullPrice.multiply(new BigDecimal("0.05"));
            priceWithDiscount = fullPrice.subtract(discountOnPrice);

        }
        else
        {
            discountOnPrice = fullPrice.multiply(new BigDecimal("0.02"));
            priceWithDiscount = fullPrice.subtract(discountOnPrice);

        }

        return priceWithDiscount.setScale(2, RoundingMode.HALF_EVEN);

    }

    @Override
    public String toString() {
        return "Smartphones{" + super.toString()+
                "imeiCode='" + imeiCode + '\'' +
                ", memory=" + memory +
                '}';
    }
}
