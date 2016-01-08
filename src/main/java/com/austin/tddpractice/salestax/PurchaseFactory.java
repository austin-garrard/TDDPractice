package com.austin.tddpractice.salestax;


public class PurchaseFactory {


    public Purchase create(int count, String item, double basePrice, boolean domestic, boolean exempt) {
        return new Purchase(count, item, basePrice, domestic, exempt);
    }
}
