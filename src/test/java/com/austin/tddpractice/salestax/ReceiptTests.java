package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ReceiptTests {

    PurchaseParser purchaseParser;
    String text;
    Receipt receipt;
    List<Purchase> purchaseMocks;


    @Before
    public void setup() {
        text = "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";

        purchaseParser = mock(PurchaseParser.class);

        purchaseMocks = new ArrayList<Purchase>();
        for(int i = 0; i < 3; i++) {
            Purchase p = mock(Purchase.class);
            when(purchaseParser.parse(anyString())).thenReturn(p);
            purchaseMocks.add(p);
        }
    }

    @Test
    public void shouldProcessAllPurchases() {
        receipt = new Receipt(text, purchaseParser);

        verify(purchaseParser, times(3)).parse(anyString());
    }

    @Test
    public void shouldCalculateTotalSalesTax() {
        for(Purchase p : purchaseMocks) {
            when(p.getSalesTax()).thenReturn(1.0);
        }

        receipt = new Receipt(text, purchaseParser);

        assertThat(receipt.getTotalSalesTax(), is(3.0));
    }


    @Test
    public void shouldCalculateTotalPrice() {
        for(Purchase p : purchaseMocks) {
            when(p.getTotal()).thenReturn(1.0);
        }

        receipt = new Receipt(text, purchaseParser);

        assertThat(receipt.getTotal(), is(3.0));
    }

    @Test
    public void shouldPrintDetails() {
        for(Purchase p: purchaseMocks) {
            when(p.toString()).thenReturn("boop");
            when(p.getSalesTax()).thenReturn(1.0);
            when(p.getTotal()).thenReturn(2.0);
        }

        receipt = new Receipt(text, purchaseParser);

        assertThat(receipt.toString(), is("boop\n" +
                                          "boop\n" +
                                          "boop\n" +
                                          "Sales Taxes: 3.00\n" +
                                          "Total: 6.00"));

    }


}
