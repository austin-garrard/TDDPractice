package com.austin.tddpractice.salestax;


public class SalesTax {
    private double rate;
    private boolean imported;
    private final double importedRate = .05;

    public SalesTax(double rate, boolean imported) {
        this.rate = rate;
        this.imported = imported;
    }

    public double of(double amount) {
        double tax = amount * rate;

        if(imported) {
            tax += amount*importedRate;
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


}
