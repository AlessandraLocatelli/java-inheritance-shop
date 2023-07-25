package org.java.inheritance;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

//chiedere all'utente di inserire dati tramite scanner e chiedere se vuole
//uno smartphone, un televisore o delle cuffie e in base alla scelta, richiamare
//il costruttore opportuno.
//stampare gli elelementi presenti nel carrello, al termine, facendo un override
//del metodo toString()


public class Basket {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> myShoppingList = new ArrayList<>();



        boolean exit = false;

        while (!exit){


            System.out.print("Insert name: ");
            String nameInput = sc.nextLine();
            System.out.print("Insert brand: ");
            String brandInput = sc.nextLine();
            System.out.print("Insert price: ");
            String priceStringInput = sc.nextLine();
            BigDecimal priceInput = new BigDecimal(priceStringInput);
            System.out.print("Insert VAT: ");
            String vatStringInput = sc.nextLine();
            BigDecimal vatInput = new BigDecimal(vatStringInput);
            Product product = new Product(nameInput,brandInput,priceInput,vatInput);


            System.out.println("Insert type of product: 1.Smartphones, 2.Headphones, 3.TV.");
            String userProductChoice = sc.nextLine();


            switch (userProductChoice)
            {
                case "1":
                    System.out.println("Insert IMEI Code: ");
                    long imeiInput = Long.parseLong(sc.nextLine());
                    System.out.println("Insert Memory in GB: ");
                    String memoryInput = sc.nextLine();
                    Smartphones smartphone = new Smartphones(nameInput,brandInput,priceInput,vatInput,imeiInput,memoryInput);
                    System.out.println(smartphone);
                    System.out.println("Price with VAT: "+smartphone.getFullPrice());
                    myShoppingList.add(smartphone);
                    break;
                case "2":
                    System.out.println("Insert color: ");
                    String colorInput = sc.nextLine();
                    System.out.println("Insert type (wireless or cablate ): ");
                    String headphonesTypeInput = sc.nextLine();
                    Headphones headphone = new Headphones(nameInput,brandInput,priceInput,vatInput,colorInput,headphonesTypeInput);
                    System.out.println(headphone);
                    System.out.println("Price with VAT: "+headphone.getFullPrice());
                    myShoppingList.add(headphone);
                    break;
                case "3":
                    System.out.println("Insert dimension: ");
                    int dimensionInput = Integer.parseInt(sc.nextLine());
                    System.out.println("Insert type (smart or not smart): ");
                    String tvTypeInput = sc.nextLine();
                    Tv tv = new Tv(nameInput,brandInput,priceInput,vatInput,dimensionInput,tvTypeInput);
                    System.out.println(tv);
                    System.out.println("Price with VAT: "+tv.getFullPrice());
                    myShoppingList.add(tv);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

            System.out.println("Do you want to add more products to your basket? (YES/NO)");
            String userChoice = sc.nextLine();

            if(userChoice.equalsIgnoreCase("NO"))
            {
                exit = true;
                break;
            }




        }


        System.out.println("Your shopping list is: ");
        for (Product currentProduct : myShoppingList)
        {
            System.out.println(currentProduct);
        }
        System.out.println("THANKS FOR SHOPPING WITH US!");





    sc.close();
    }



}
