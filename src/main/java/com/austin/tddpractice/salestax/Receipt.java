package com.austin.tddpractice.salestax;


public class Receipt {
    private String text;
    private PurchaseParser purchaseParser;
    private double totalSalesTax;

    public Receipt(String text, PurchaseParser purchaseParser) {
        this.text = text;
        this.purchaseParser = purchaseParser;
        create();
    }

    private void create() {
        totalSalesTax = 0.0;

        String[] purchaseStrings = text.split("\n");
        for(String purchaseString : purchaseStrings) {
            Purchase purchase = purchaseParser.parse(purchaseString);

            totalSalesTax += purchase.getSalesTax();
        }
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }
}
