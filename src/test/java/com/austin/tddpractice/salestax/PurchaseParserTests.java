package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PurchaseParserTests {

    PurchaseFactory purchaseFactory;
    PurchaseParser purchaseParser;

    @Before
    public void setup() {
        purchaseFactory = mock(PurchaseFactory.class);
        List<String> exemptItems = new ArrayList<String>();
        exemptItems.add("book");
        exemptItems.add("headache pills");
        purchaseParser = new PurchaseParser(purchaseFactory, exemptItems);
    }

    @Test
    public void shouldCreateDomesticNonExemptPurchase() {
        purchaseParser.parse("1 music CD at 14.99");

        verify(purchaseFactory).create(1, "music CD", 14.99, true, false);
    }

    @Test
    public void shouldCreateDomesticExemptPurchase() {
        purchaseParser.parse("1 book at 12.49");

        verify(purchaseFactory).create(1, "book", 12.49, true, true);
    }

    @Test
    public void shouldCreateImportedNonExemptPurchase() {
        purchaseParser.parse("1 imported bottle of perfume at 47.50");

        verify(purchaseFactory).create(1, "bottle of perfume", 47.50, false, false);
    }

    @Test
    public void shouldCreatedImportedExemptPurchase() {
        purchaseParser.parse("1 imported headache pills at 12.49");

        verify(purchaseFactory).create(1, "headache pills", 12.49, false, true);
    }
}
