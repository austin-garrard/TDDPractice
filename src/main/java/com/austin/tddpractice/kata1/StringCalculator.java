package com.austin.tddpractice.kata1;


import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) {
        int sum = 0;
        Scanner scanner = new Scanner(numbers);
        scanner.useDelimiter(",");

        while(scanner.hasNextInt())
            sum += scanner.nextInt();

        return sum;
    }
}
