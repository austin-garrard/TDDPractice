package com.austin.tddpractice.salestax;


public class Purchase {
    private int count;
    private final String item;
    private double basePrice;
    private final boolean domestic;
    private boolean exempt;

    public Purchase(int count, String item, double basePrice, boolean domestic, boolean exempt) {
        this.count = count;
        this.item = item;
        this.basePrice = basePrice;
        this.domestic = domestic;
        this.exempt = exempt;
    }
}
