package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ReceiptGeneratorTests {

    String example1;
    Scanner scanner;
    ReceiptGenerator receiptGenerator;

    @Before
    public void setup() {
        example1 = "1 book at 12.49\n" +
                   "1 music CD at 14.99\n" +
                   "1 chocolate bar at 0.85";
    }

    @Test
    public void shouldApplySalesTaxToNormalGoods() {
        SalesTax salesTax = mock(SalesTax.class);
        when(salesTax.of(anyFloat(), anyBoolean())).thenReturn(1.50);
        receiptGenerator = new ReceiptGenerator(new Scanner("1 music CD at 14.99\n"), salesTax);

        String receipt = receiptGenerator.getReceipt();

        assertThat(receipt, is("1 music CD: 16.49\n" +
                               "Sales Taxes: 1.50\n" +
                               "Total: 16.49"));
    }
}
