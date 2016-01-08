package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PurchaseParserTests {

    PurchaseFactory purchaseFactory;
    PurchaseParser purchaseParser;

    @Before
    public void setup() {
        purchaseFactory = mock(PurchaseFactory.class);

        purchaseParser = new PurchaseParser(purchaseFactory);
    }

    @Test
    public void shouldCreateDomesticPurchase() {
        purchaseParser.parse("1 music CD at 14.99");

        verify(purchaseFactory).create(1, "music CD", 14.99, true);
    }

    @Test
    public void shouldCreateImportedPurchase() {
        purchaseParser.parse("1 imported bottle of perfume at 47.50");

        verify(purchaseFactory).create(1, "bottle of perfume", 47.50, false);
    }

}
