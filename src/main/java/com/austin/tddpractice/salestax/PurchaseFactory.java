package com.austin.tddpractice.salestax;


import java.util.List;

public class PurchaseFactory {


    public Purchase create(int count, String item, double basePrice, boolean domestic) {
        return new Purchase(count, item, basePrice, domestic);
    }




}
