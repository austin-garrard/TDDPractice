package com.austin.tddpractice.salestax;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double domesticRate = .1;
        double importedRate = .05;

        List<String> exemptItems = new ArrayList<String>();
        exemptItems.add("book");
        exemptItems.add("chocolate bar");
        exemptItems.add("headache pills");
        exemptItems.add("box of chocolates");

        PurchaseFactory purchaseFactory = new PurchaseFactory(domesticRate, importedRate, exemptItems);
        PurchaseParser purchaseParser = new PurchaseParser(purchaseFactory);

        String example1 = "1 book at 12.49\n" +
                          "1 music CD at 14.99\n" +
                          "1 chocolate bar at 0.85";
        Receipt receipt1 = new Receipt(example1, purchaseParser);
        System.out.println(receipt1);

//        String example2 = "1 imported box of chocolates at 10.00\n" +
//                          "1 imported bottle of perfume at 47.50";
//
//        String example3 = "1 imported bottle of perfume at 27.99\n" +
//                          "1 bottle of perfume at 18.99\n" +
//                          "1 packet of headache pills at 9.75\n" +
//                          "1 imported box of chocolates at 11.25";
    }
}



