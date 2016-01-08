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
        salesTax = new SalesTax(.1);
    }

    @Test
    public void shouldCalculateBaseSalesTax() {
        assertThat(salesTax.of(12.50), is(1.25));
    }


}
