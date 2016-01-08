package com.austin.tddpractice.salestax;


public class SalesTax {
    private double domesticRate;
    private double importedRate;

    public SalesTax(double domesticRate, double importedRate) {
        this.domesticRate = domesticRate;
        this.importedRate = importedRate;
    }

    public double of(double amount, boolean imported) {
        double tax = amount * domesticRate;

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
