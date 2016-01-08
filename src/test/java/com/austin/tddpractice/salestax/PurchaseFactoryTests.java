package com.austin.tddpractice.salestax;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PurchaseFactoryTests {


    PurchaseFactory purchaseFactory;

    @Before
    public void setup() {
        List<String> exemptItems = new ArrayList<String>();
        exemptItems.add("book");
        exemptItems.add("headache pills");
       purchaseFactory = new PurchaseFactory(exemptItems);
    }

    @Test
    public void shouldCreateNonExemptPurchase() {
        Purchase purchase = purchaseFactory.create(1, "perfume", 14.49, true);

        assertTrue(purchase.equals(new Purchase(1, "perfume", 14.49, true, false)));
    }

    @Test
    public void shouldCreateExemptPurchase() {
        Purchase purchase = purchaseFactory.create(1, "book", 14.49, true);

        assertTrue(purchase.equals(new Purchase(1, "book", 14.49, true, true)));
    }
}
