package org.java.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

//classe che gestisce tutti i prodotti dello shop
public class Product {

    //CAMPI
    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal vat;



   //COSTRUTTORI

    public Product(String name, String brand, BigDecimal price, BigDecimal vat)
    {
        this.code = generateCode();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;

    }



    //GET E SET

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }


    //METODI


    public BigDecimal getFullPrice()
    {
        BigDecimal vatOnPrice = price.multiply(vat);
        BigDecimal fullPrice = price.add(vatOnPrice);

        return fullPrice.setScale(2, RoundingMode.HALF_EVEN );

    }


    private int generateCode()
    {
        Random random = new Random();
        return random.nextInt(1,10000);

    }


}
