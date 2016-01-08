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

        return  tax;
    }
}
