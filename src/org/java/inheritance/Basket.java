package org.java.inheritance;
import java.math.BigDecimal;
import java.util.Scanner;

//chiedere all'utente di inserire dati tramite scanner e chiedere se vuole
//uno smartphone, un televisore o delle cuffie e in base alla scelta, richiamare
//il costruttore opportuno.
//stampare gli elelementi presenti nel carrello, al termine, facendo un override
//del metodo toString()


public class Basket {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


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

            System.out.println("Insert type of product: 1.Smartphones, 2.Headphones, 3.TV. Otherwise digit '4' to exit.");
            String userChoice = sc.nextLine();

            switch (userChoice)
            {
                case "1":
                    System.out.println("Insert IMEI Code: ");
                    long imeiInput = Long.parseLong(sc.nextLine());
                    System.out.println("Insert Memory: ");
                    int memoryInput = Integer.parseInt(sc.nextLine());
                    Smartphones smartphone = new Smartphones(nameInput,brandInput,priceInput,vatInput,imeiInput,memoryInput);
                    break;
                case "2":
                    System.out.println("Insert color: ");
                    String colorInput = sc.nextLine();
                    System.out.println("Insert type (wireless or cablate ): ");
                    String headphonesTypeInput = sc.nextLine();
                    Headphones headphone = new Headphones(nameInput,brandInput,priceInput,vatInput,colorInput,headphonesTypeInput);
                    break;
                case "3":
                    System.out.println("Insert dimension: ");
                    int dimensionInput = Integer.parseInt(sc.nextLine());
                    System.out.println("Insert type (smart or not smart): ");
                    String tvTypeInput = sc.nextLine();
                    Tv tv = new Tv(nameInput,brandInput,priceInput,vatInput,dimensionInput,tvTypeInput);
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }






        }


        System.out.println("THANKS FOR SHOPPING WITH US!");


    sc.close();
    }



}
