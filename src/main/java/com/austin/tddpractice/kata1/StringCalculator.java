package com.austin.tddpractice.kata1;


import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) {
        if(numbers.length() == 0)
            return 0;

        Scanner scanner = new Scanner(numbers);
        scanner.useDelimiter(",");

        int firstNumber = scanner.nextInt();
        int secondNumber = 0;
        if(scanner.hasNextInt()) {
            secondNumber = scanner.nextInt();
        }

        return firstNumber + secondNumber;
    }
}
