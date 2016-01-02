package com.austin.tddpractice.kata1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) throws NegativeArgumentException {
        Scanner scanner = getScanner(numbers);

        int sum = 0;
        List<Integer> negativeArguments = new ArrayList<Integer>();
        while(scanner.hasNextInt()) {
            int next = scanner.nextInt();
            if(next < 0)
                negativeArguments.add(next);
            else
                sum += next;
        }

        if(negativeArguments.size() > 0) {
            throw new NegativeArgumentException(negativeArguments);
        }

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
