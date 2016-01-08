package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class SalesTaxTests {

    private SalesTax salesTax;
    private Purchase purchase;

    @Before
    public void setup() {
        List<String> exemptItems = new ArrayList<String>();
        exemptItems.add("book");
        exemptItems.add("headache pills");
        salesTax = new SalesTax(.1, .05, exemptItems);
        purchase = mock(Purchase.class);
    }

    @Test
    public void shouldCalculateNonExemptDomesticSalesTax() {
        when(purchase.getItem()).thenReturn("");
        when(purchase.getBasePrice()).thenReturn(12.50);
        when(purchase.isDomestic()).thenReturn(true);

        assertThat(salesTax.of(purchase), is(1.25));
    }

    @Test
    public void shouldCalculateNonExemptImportedSalesTax() {
        when(purchase.getItem()).thenReturn("");
        when(purchase.getBasePrice()).thenReturn(10.0);
        when(purchase.isDomestic()).thenReturn(false);

        assertThat(salesTax.of(purchase), is(1.5));
    }

    @Test
    public void shouldRoundUpToTheNearestPoint05() {
        when(purchase.getItem()).thenReturn("");
        when(purchase.getBasePrice()).thenReturn(14.99);
        when(purchase.isDomestic()).thenReturn(true);

        assertThat(salesTax.of(purchase), is(1.5));
    }
}
