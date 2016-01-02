package com.austin.tddpractice.kata1;


import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) {
        int firstNumber = 0;
        int secondNumber = 0;

        Scanner scanner = new Scanner(numbers);
        scanner.useDelimiter(",");

        if(scanner.hasNextInt())
            firstNumber = scanner.nextInt();
        if(scanner.hasNextInt())
            secondNumber = scanner.nextInt();

        return firstNumber + secondNumber;
    }
}
