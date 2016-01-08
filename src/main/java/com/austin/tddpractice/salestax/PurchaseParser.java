package com.austin.tddpractice.salestax;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PurchaseParser {
    private PurchaseFactory purchaseFactory;

    public PurchaseParser(PurchaseFactory purchaseFactory) {
        this.purchaseFactory = purchaseFactory;
    }

    public Purchase parse(String purchaseString) {
        List<String> tokens = new LinkedList(Arrays.asList(purchaseString.split(" ")));

        int count = Integer.parseInt(tokens.remove(0));

        boolean domestic = isDomestic(tokens);

        String item = parseItem(tokens);

        double basePrice = Double.parseDouble(tokens.remove(0));

        return purchaseFactory.create(count, item, basePrice, domestic);
    }

    private boolean isDomestic(List<String> tokens) {
        String domesticString = tokens.get(0);
        boolean domestic = true;
        if(domesticString.equals("imported")) {
            domestic = false;
            tokens.remove(0);
        }
        return domestic;
    }


    private String parseItem(List<String> tokens) {
        String item = "";

        String token = tokens.remove(0);
        while(!token.equals("at")) {
            item += token + " ";
            token = tokens.remove(0);
        }

        item = item.substring(0, item.length()-1);
        return item;
    }
}
