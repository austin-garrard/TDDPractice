package com.austin.tddpractice.kata1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {

    public int Add(String numbers) throws NegativeArgumentException {
        Scanner scanner = getScanner(numbers);

        StringAdder stringAdder = new StringAdder(scanner).invoke();
        List<Integer> negativeArguments = stringAdder.getNegativeArguments();
        int sum = stringAdder.getSum();

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

    private class StringAdder {
        private Scanner scanner;
        private int sum;
        private List<Integer> negativeArguments;

        public StringAdder(Scanner scanner) {
            this.scanner = scanner;
        }

        public int getSum() {
            return sum;
        }

        public List<Integer> getNegativeArguments() {
            return negativeArguments;
        }

        public StringAdder invoke() {
            sum = 0;
            negativeArguments = new ArrayList<Integer>();
            while(scanner.hasNextInt()) {
                int next = scanner.nextInt();
                if(next < 0)
                    negativeArguments.add(next);
                else
                    sum += next;
            }
            return this;
        }
    }
}
