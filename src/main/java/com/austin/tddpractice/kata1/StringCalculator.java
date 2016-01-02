package com.austin.tddpractice.kata1;


import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) {
        if(numbers.length() == 0)
            return 0;

        Scanner scanner = new Scanner(numbers);
        return scanner.nextInt();
    }
}
