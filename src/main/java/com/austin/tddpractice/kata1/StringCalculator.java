package com.austin.tddpractice.kata1;


import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) {
        String delimiterString = ",|\n";
        int newlinePos = 0;
        if(numbers.indexOf("//") == 0) {
            newlinePos = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(2, newlinePos);
            delimiterString += "|" + customDelimiter;
        }

        int sum = 0;
        Scanner scanner = new Scanner(numbers.substring(newlinePos));
        scanner.useDelimiter(delimiterString);

        while(scanner.hasNextInt())
            sum += scanner.nextInt();

        return sum;
    }
}
