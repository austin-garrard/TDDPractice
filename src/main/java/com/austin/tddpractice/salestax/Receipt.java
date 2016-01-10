package com.austin.tddpractice.salestax;


public class Receipt {
    private String text;
    private PurchaseParser purchaseParser;

    public Receipt(String text, PurchaseParser purchaseParser) {
        this.text = text;
        this.purchaseParser = purchaseParser;
        create();
    }

    private void create() {
        String[] purchaseStrings = text.split("\n");
        for(String purchaseString : purchaseStrings) {
            purchaseParser.parse(purchaseString);
        }
    }
}
