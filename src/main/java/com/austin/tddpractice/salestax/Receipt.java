package com.austin.tddpractice.salestax;


public class Receipt {
    private String text;
    private PurchaseParser purchaseParser;
    private double totalSalesTax;
    private double total;

    public Receipt(String text, PurchaseParser purchaseParser) {
        this.text = text;
        this.purchaseParser = purchaseParser;
        create();
    }

    private void create() {
        totalSalesTax = 0.0;
        total = 0.0;

        String[] purchaseStrings = text.split("\n");
        for(String purchaseString : purchaseStrings) {
            Purchase purchase = purchaseParser.parse(purchaseString);

            totalSalesTax += purchase.getSalesTax();
            total += purchase.getTotal();
        }
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotal() {
        return total;
    }
}
