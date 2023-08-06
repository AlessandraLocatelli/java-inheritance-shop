package org.java.inheritance;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Headphones extends Product {


    private String color;
    private boolean isWireless;


    public Headphones(String name, String brand, BigDecimal price, BigDecimal vat, String color, boolean isWireless)
    throws RuntimeException
    {
        super(name, brand, price, vat);

        if(color == null || color.isBlank())
            throw new RuntimeException("Insert a color.");

        this.color = color;
        this.isWireless = isWireless;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) throws RuntimeException {

        if(color == null || color.isBlank())
            throw new RuntimeException("Insert a color.");
        this.color = color;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }


    @Override
    public BigDecimal getDiscountPrice(boolean ownsAFidelityCard) {

        BigDecimal fullPrice = getFullPrice();
        BigDecimal priceWithDiscount = BigDecimal.ZERO;
        BigDecimal discountOnPrice = BigDecimal.ZERO;

        if(!isWireless)
        {
            discountOnPrice = fullPrice.multiply(new BigDecimal("0.07"));
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

        String string = super.toString()+" ,color= "+color;

        if(isWireless)
        {
            string += "wireless";
        }


        return "Headphones{" + string+"}";
    }




}
