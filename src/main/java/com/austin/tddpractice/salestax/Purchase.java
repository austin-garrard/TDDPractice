package com.austin.tddpractice.salestax;


import java.util.List;

public class Purchase {
    private int count;
    private final String item;
    private double basePrice;
    private final boolean domestic;
    private double domesticRate;
    private double importedRate;
    private List<String> exemptItems;

    public Purchase(int count, String item, double basePrice, boolean domestic, double domesticRate, double importedRate, List<String> exemptItems) {
        this.count = count;
        this.item = item;
        this.basePrice = basePrice;
        this.domestic = domestic;
        this.domesticRate = domesticRate;
        this.importedRate = importedRate;
        this.exemptItems = exemptItems;
    }


    @Override
    public String toString() {
        return String.format("%d %s: %.2f", count, item, getTotal());
    }

    public double getSalesTax() {
        double domesticTax = isExempt(item)
                ? 0.0
                : basePrice * domesticRate;

        double importedTax = domestic
                ? 0.0
                : basePrice * importedRate;

        return round(domesticTax + importedTax);
    }

    public double getTotal() {
        return basePrice + getSalesTax();
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
