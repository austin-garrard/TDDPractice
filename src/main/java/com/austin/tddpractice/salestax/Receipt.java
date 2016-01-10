package com.austin.tddpractice.salestax;


import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private String text;
    private PurchaseParser purchaseParser;
    private double totalSalesTax;
    private double total;
    private List<Purchase> purchases;

    public Receipt(String text, PurchaseParser purchaseParser) {
        this.text = text;
        this.purchaseParser = purchaseParser;
        create();
    }

    private void create() {
        totalSalesTax = 0.0;
        total = 0.0;
        purchases = new ArrayList<Purchase>();

        String[] purchaseStrings = text.split("\n");
        for(String purchaseString : purchaseStrings) {
            Purchase purchase = purchaseParser.parse(purchaseString);

            totalSalesTax += purchase.getSalesTax();
            total += purchase.getTotal();

            purchases.add(purchase);
        }
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        String output = "";

        for(Purchase p : purchases) {
            output += p.toString() + "\n";
        }

        output += String.format("Sales Taxes: %.2f\n", totalSalesTax);
        output += String.format("Total: %.2f", total);

        return output;
    }
}
