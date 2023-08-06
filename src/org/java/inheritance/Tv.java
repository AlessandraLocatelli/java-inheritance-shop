package org.java.inheritance;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tv extends Product{

    private int dimension;
    private boolean isSmart;


    public Tv(String name, String brand, BigDecimal price, BigDecimal vat, int dimension, boolean isSmart)
    throws RuntimeException
    {
        super(name, brand, price, vat);

        if(dimension < 32 || dimension > 100)
            throw new RuntimeException("Insert a number between 32-100 for dimension.");

        this.dimension = dimension;
        this.isSmart = isSmart;
    }


    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        if(dimension < 32 || dimension > 100)
            throw new RuntimeException("Insert a number between 32-100.");

        this.dimension = dimension;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }


    @Override
    public BigDecimal getDiscountPrice(boolean ownsAFidelityCard) {

        BigDecimal fullPrice = getFullPrice();
        BigDecimal priceWithDiscount = BigDecimal.ZERO;
        BigDecimal discountOnPrice = BigDecimal.ZERO;

        if(!isSmart)
        {
            discountOnPrice = fullPrice.multiply(new BigDecimal("0.10"));
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

        String string = super.toString() + " ,dimension= "+dimension;

        if(isSmart)
        {
            string += "smart";
        }

        return  "TV{"+string+"}";


    }
}
