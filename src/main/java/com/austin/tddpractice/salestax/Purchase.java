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

    @Override
    public boolean equals(Object object) {
        Purchase otherPurchase = (Purchase)object;

        return count == otherPurchase.getCount()
                && item.equals(otherPurchase.getItem())
                && basePrice == otherPurchase.getBasePrice()
                && domestic == otherPurchase.isDomestic()
                && exempt == otherPurchase.isExempt();
    }

    public int getCount() {
        return count;
    }

    public String getItem() {
        return item;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public boolean isExempt() {
        return exempt;
    }
}
