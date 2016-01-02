package com.austin.tddpractice.kata1;


import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) {
        Scanner scanner = getScanner(numbers);

        int sum = 0;
        while(scanner.hasNextInt())
            sum += scanner.nextInt();

        return sum;
    }

    private Scanner getScanner(String numbers) {
        String delimiterString = ",|\n";
        int newlinePos = 0;
        if(numbers.indexOf("//") == 0) {
            newlinePos = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(2, newlinePos);
            delimiterString += "|" + customDelimiter;
        }

        Scanner scanner = new Scanner(numbers.substring(newlinePos));
        scanner.useDelimiter(delimiterString);
        return scanner;
    }

}
