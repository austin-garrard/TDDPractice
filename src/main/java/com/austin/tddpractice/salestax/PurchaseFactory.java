package com.austin.tddpractice.salestax;


import java.util.List;

public class PurchaseFactory {


    private List<String> exemptItems;

    public PurchaseFactory(List<String> exemptItems) {

        this.exemptItems = exemptItems;
    }

    public Purchase create(int count, String item, double basePrice, boolean domestic) {
        return new Purchase(count, item, basePrice, domestic, isExempt(item));
    }

    private boolean isExempt(String item) {
        for(String exemptItem : exemptItems) {
            if(item.equals(exemptItem)) {
                return true;
            }
        }
        return false;
    }


}
