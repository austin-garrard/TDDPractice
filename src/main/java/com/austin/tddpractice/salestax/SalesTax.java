package com.austin.tddpractice.salestax;


import java.util.List;

public class SalesTax {
    private double domesticRate;
    private double importedRate;
    private List<String> exemptItems;

    public SalesTax(double domesticRate, double importedRate, List<String> exemptItems) {
        this.domesticRate = domesticRate;
        this.importedRate = importedRate;
        this.exemptItems = exemptItems;
    }

    public double of(Purchase purchase, boolean imported) {
        if(isExempt(purchase.getItem()))
            return 0.0;

        double tax = purchase.getBasePrice() * domesticRate;

        if(imported) {
            tax += purchase.getBasePrice()*importedRate;
        }

        return round(tax);
    }

    private double round(double tax) {
        int roundedTax = (int)(tax*100);
        while(roundedTax % 5 != 0) {
            roundedTax++;
        }
        return roundedTax / 100.0;
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
