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
        Product product = new Product(nameInput, brandInput, priceInput, vatInput);

        boolean exit = false;

        while (!exit){
        System.out.println("Insert type of product: 1.Smartphones, 2.Headphones, 3.TV. Otherwise digit '4' to exit.");
        String userChoice = sc.nextLine();

            switch (userChoice)
            {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
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
