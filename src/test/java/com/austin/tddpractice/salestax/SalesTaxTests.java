package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SalesTaxTests {

    private SalesTax domesticSalesTax;
    private SalesTax importedSalesTax;

    @Before
    public void setup() {
        domesticSalesTax = new SalesTax(.1, false);
        importedSalesTax = new SalesTax(.1, true);
    }

    @Test
    public void shouldCalculateBaseSalesTax() {
        assertThat(domesticSalesTax.of(12.50), is(1.25));
    }

    @Test
    public void shouldCalculateImportedSalesTax() {
        assertThat(importedSalesTax.of(10), is(1.5));
    }
}
