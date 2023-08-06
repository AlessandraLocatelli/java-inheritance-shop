package org.java.inheritance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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

    boolean isRunning = true;


    while(isRunning)
    {

        System.out.println("Do you want to add a product to your basket (y/n)?");
        String userChoice = sc.nextLine();

        if (userChoice.equalsIgnoreCase("y"))
        {

            System.out.println("Which product? Insert 1 for smartphones, 2 for TV, 3 for headphones.");
            String productChoice = sc.nextLine();

                System.out.println("Name: ");
                String nameInput = sc.nextLine();
                System.out.println("Brand: ");
                String brandInput = sc.nextLine();

                BigDecimal priceInput = BigDecimal.ZERO;
                BigDecimal vatInput = BigDecimal.ZERO;

                try{
                System.out.println("Price: ");
                priceInput = new BigDecimal(sc.nextLine());
                System.out.println("VAT: ");
                vatInput = new BigDecimal(sc.nextLine());
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid format for price and/or vat.");
                }


            switch (productChoice) {
                case "1":

                    String imeiCodeInput = null;
                    int memoryInput = 0;
                    Smartphones smartphones = null;

                    try {
                        System.out.println("IMEI CODE: ");
                        imeiCodeInput = sc.nextLine();
                        System.out.println("Memory in GB: ");
                        memoryInput = Integer.parseInt(sc.nextLine());
                        smartphones = new Smartphones(nameInput, brandInput, priceInput, vatInput, imeiCodeInput, memoryInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format for imei code and/or memory.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    myShoppingList.add(smartphones);
                    break;

                    case "2":

                    int dimensionInput = 0;
                    Tv tv = null;

                    System.out.println("smart: (y/n)");
                    String isSmartString = sc.nextLine();
                    boolean isSmart = isSmartString.equalsIgnoreCase("y");

                    try{
                    System.out.println("dimension: ");
                    dimensionInput = Integer.parseInt(sc.nextLine());
                    tv = new Tv(nameInput,brandInput,priceInput,vatInput,dimensionInput,isSmart);
                    }
                    catch (NumberFormatException e) {
                    System.out.println("Invalid format for dimension.");
                    } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                     }

                    myShoppingList.add(tv);
                    break;

                case "3":

                    Headphones headphones = null;

                    System.out.println("Color: ");
                    String colorInput = sc.nextLine();

                    System.out.println("Wireless: (y/n)");
                    String isWirelessString = sc.nextLine();
                    boolean isWireless = isWirelessString.equalsIgnoreCase("y");

                    try{

                        headphones = new Headphones(nameInput,brandInput,priceInput,vatInput,colorInput,isWireless);
                    }
                    catch (RuntimeException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    myShoppingList.add(headphones);
                    break;


                default:
                    System.out.println("Invalid choice. Choose between 1-3.");
                    break;

            }

        }
        else if(userChoice.equalsIgnoreCase("n"))
        {

            break;

        }
        else
        {
            System.out.println("Insert 'y' or 'n'");


        }

    }

       if(!myShoppingList.isEmpty()){
        System.out.println("Do you have our fidelity card? (y/n)");
        String userInput = sc.nextLine();
        boolean ownsAFidelityCard = userInput.equalsIgnoreCase("y");

        BigDecimal total = BigDecimal.ZERO;

        System.out.println("Your shopping list: ");

        for(Product p : myShoppingList)
        {
            System.out.println(p);

            if(ownsAFidelityCard)
            {
                total = total.add(p.getDiscountPrice(ownsAFidelityCard));
                System.out.println(p.getName()+" Price with discount: "+p.getDiscountPrice(ownsAFidelityCard));
            }
            else{
            total = total.add(p.getFullPrice());
            System.out.println(p.getName()+" Price: "+p.getFullPrice());
            }
        }

        System.out.println("TOTAL "+total);
        System.out.println("THANKS FOR SHOPPING WITH US!");
       }
       else
       {
           System.out.println("WE HOPE TO SEE YOU AGAIN!");
       }


    sc.close();
    }



}
