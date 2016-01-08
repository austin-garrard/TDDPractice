package com.austin.tddpractice.salestax;

import java.util.Scanner;

public class ReceiptGenerator {
    private Scanner scanner;
    private SalesTax salesTax;

    public ReceiptGenerator(Scanner scanner, SalesTax salesTax) {
        this.scanner = scanner;
        this.salesTax = salesTax;
    }

    public String getReceipt() {

        int count = scanner.nextInt();
        String item = parseItem();

        double price = scanner.nextDouble();
        double tax = salesTax.of(price);
        double total = price + tax;


        return String.format("%d %s: %.2f\n" +
                             "Sales Taxes: %.2f\n" +
                             "Total: %.2f",
                             count, item, total, tax, total);
    }

    private String parseItem() {
        String item = "";
        String token = scanner.next();
        while(!token.equals("at")) {
            item += token + " ";
            token = scanner.next();
        }
        item = item.substring(0, item.length()-1);
        return item;
    }
}
