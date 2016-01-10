package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ReceiptTests {

    PurchaseParser purchaseParser;
    String purchases1, purchases2, purchases3;
    Receipt receipt;


    @Before
    public void setup() {
        purchaseParser = mock(PurchaseParser.class);

        purchases1 = "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";

        purchases2 = "1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50";

        purchases3 = "1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 imported box of chocolates at 11.25";
    }

    @Test
    public void shouldProcessAllPurchases() {
        receipt = new Receipt(purchases1, purchaseParser);

        verify(purchaseParser, times(3)).parse(anyString());
    }





}
