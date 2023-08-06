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




    public Product() {

    }

    public Product(String name, String brand, BigDecimal price, BigDecimal vat)  throws  RuntimeException
    {
        this.code = generateCode();

        if(name == null || name.isBlank())
            throw new RuntimeException("name cant be null or empty.");
        if(brand == null || brand.isBlank())
            throw new RuntimeException("brand cant be null or empty.");
        if(price.signum() == -1 || price.signum() == 0)
            throw new RuntimeException("price cant be negative or equal to zero.");
        if(vat.signum() == -1)
            throw  new RuntimeException("VAT cant be negative.");

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

    public void setName(String name) throws RuntimeException {
        if(name == null || name.isBlank())
            throw new RuntimeException("name cant be null or empty.");
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws RuntimeException {
        if(name == null || brand.isBlank())
            throw new RuntimeException("brand cant be null or empty.");
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws RuntimeException {
        if(price.signum() == -1 || price.signum() == 0)
            throw new RuntimeException("price cant be negative or equal to zero.");
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) throws RuntimeException {
        if(vat.signum() == -1)
            throw  new RuntimeException("VAT cant be negative.");

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
        return random.nextInt(1,100000);

    }


    public BigDecimal getDiscountPrice(boolean ownsAFidelityCard)
    {
        BigDecimal fullPrice = getFullPrice();
        BigDecimal discountOnPrice = fullPrice.multiply(new BigDecimal("0.02"));
        BigDecimal priceWithDiscount = fullPrice.subtract(discountOnPrice);

        return priceWithDiscount.setScale(2, RoundingMode.HALF_EVEN);

    }





    @Override
    public String toString() {
        return "code=" + code +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ",price with vat=" +getFullPrice()+
                ", price=" + price +
                ", vat=" + vat;
    }
}

