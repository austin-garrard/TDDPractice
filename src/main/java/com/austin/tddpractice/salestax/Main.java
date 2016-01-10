package com.austin.tddpractice.salestax;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String example1 = "1 book at 12.49\n" +
                          "1 music CD at 14.99\n" +
                          "1 chocolate bar at 0.85";

        String example2 = "1 imported box of chocolates at 10.00\n" +
                          "1 imported bottle of perfume at 47.50";

        String example3 = "1 imported bottle of perfume at 27.99\n" +
                          "1 bottle of perfume at 18.99\n" +
                          "1 packet of headache pills at 9.75\n" +
                          "1 imported box of chocolates at 11.25";

        List<String> exemptItems = new ArrayList<String>();
        exemptItems.add("book");
        exemptItems.add("chocolate bar");
        exemptItems.add("headache pills");
        exemptItems.add("box of chocolates");

        String[] purchaseStrings = example3.split("\n");
        PurchaseFactory purchaseFactory= new PurchaseFactory(.1, .05, exemptItems);
        PurchaseParser purchaseParser= new PurchaseParser(purchaseFactory);

        double totalSalesTax = 0.0;
        double total = 0.0;
        for(String purchaseString : purchaseStrings) {
            Purchase purchase = purchaseParser.parse(purchaseString);
            System.out.println(purchase.toString());
            totalSalesTax += purchase.getSalesTax();
            total += purchase.getTotal();

        }
        System.out.printf("Sales Taxes: %.2f\n", totalSalesTax);
        System.out.printf("Total: %.2f\n", total);



    }
}



