package com.austin.tddpractice.salestax;


import java.util.List;

public class PurchaseFactory {


    private double domesticRate;
    private double importedRate;
    private List<String> exemptItems;

    public PurchaseFactory(double domesticRate, double importedRate, List<String> exemptItems) {
        this.domesticRate = domesticRate;
        this.importedRate = importedRate;
        this.exemptItems = exemptItems;
    }

    public Purchase create(int count, String item, double basePrice, boolean domestic) {
        return new Purchase(count, item, basePrice, domestic, domesticRate, importedRate, exemptItems);
    }




}
