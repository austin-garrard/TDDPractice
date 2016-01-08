package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SalesTaxTests {

    private SalesTax salesTax;

    @Before
    public void setup() {
        salesTax = new SalesTax(.1, .05);
    }

    @Test
    public void shouldCalculateDomesticSalesTax() {
        assertThat(salesTax.of(12.50, false), is(1.25));
    }

    @Test
    public void shouldCalculateImportedSalesTax() {
        assertThat(salesTax.of(10, true), is(1.5));
    }

    @Test
    public void shouldRoundUpToTheNearestPoint05() {
        assertThat(salesTax.of(14.99, false), is(1.5));
    }
}
