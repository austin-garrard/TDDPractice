package com.austin.tddpractice.salestax;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class PurchaseTests {
    List<String> exemptItems;
    double domesticRate;
    double importedRate;

    @Before
    public void setup() {
        exemptItems = new ArrayList<String>();
        exemptItems.add("book");
        exemptItems.add("chocolate bar");
        exemptItems.add("headache pills");
        exemptItems.add("box of chocolates");

        domesticRate = .1;
        importedRate = .05;
    }

    @Test
    public void shouldCalculateNonExemptDomesticSalesTax() {
        Purchase purchase = new Purchase(1, "music CD", 14.99, true, domesticRate, importedRate, exemptItems);
        assertThat(purchase.getSalesTax(), is(1.5));
    }

    @Test
    public void shouldCalculateExemptDomesticSalesTax() {
        Purchase purchase = new Purchase(1, "book", 12.49, true, domesticRate, importedRate, exemptItems);
        assertThat(purchase.getSalesTax(), is(0.0));
    }

    @Test
    public void shouldCalculateNonExemptImportedSalesTax() {
        Purchase purchase = new Purchase(1, "bottle of perfume", 47.5, false, domesticRate, importedRate, exemptItems);
        assertThat(purchase.getSalesTax(), is(7.15));
    }

    @Test
    public void shouldCalculateExemptImportedSalesTax() {
        Purchase purchase = new Purchase(1, "box of chocolates", 10.0, false, domesticRate, importedRate, exemptItems);
        assertThat(purchase.getSalesTax(), is(.5));
    }

    @Test
    public void shouldRoundUpToTheNearestPoint05() {
        Purchase purchase = new Purchase(1, "music CD", 14.99, true, domesticRate, importedRate, exemptItems);
        assertThat(purchase.getSalesTax(), is(1.5));
    }

    @Test
    public void shouldFormatFieldsForReceipt() {
        Purchase purchase = new Purchase(1, "music CD", 14.99, true, domesticRate, importedRate, exemptItems);
        assertThat(purchase.toString(), is("1 music CD: 16.49"));
    }
}
