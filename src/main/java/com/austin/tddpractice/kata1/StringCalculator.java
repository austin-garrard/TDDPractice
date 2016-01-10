package com.austin.tddpractice.kata1;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {
        if(text.length() > 0) {
            String[] numbers = tokenize(text);
            ArrayList<Integer> intValues = mapToIntegers(numbers);
            checkForNegatives(intValues);
            return sumNumbers(intValues);
        }
        return 0;
    }

    private String[] tokenize(String text) {
        if(text.startsWith("//[")) {
            return tokenizeWithVariableLengthCustomDelimiter(text);
        }
        else if(text.startsWith("//")) {
            return tokenizeWithCustomDelimiter(text);
        }
        else {
            return text.split("\n|,");
        }
    }

    private String[] tokenizeWithCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        matcher.matches();
        return matcher.group(2).split("\n|,|" + matcher.group(1));
    }

    private String[] tokenizeWithVariableLengthCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile("//\\[(.*)]\n(.*)").matcher(text);
        matcher.matches();
        return matcher.group(2).split("\n|,|" + Pattern.quote(matcher.group(1)));
    }

    private int sumNumbers(ArrayList<Integer> numbers) {
        int sum = 0;
        for(Integer number : numbers) {
            sum += number > 1000 ? 0 : number;
        }
        return sum;
    }

    private ArrayList<Integer> mapToIntegers(String[] numbers) {
        ArrayList<Integer> intValues = new ArrayList<Integer>();
        for(String number : numbers) {
            intValues.add(Integer.parseInt(number));
        }
        return intValues;
    }

    private void checkForNegatives(ArrayList<Integer> numbers) {
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        findNegatives(numbers, negatives);

        if(negatives.size() > 0) {
            throwNegativeNumberError(negatives);
        }
    }

    private void throwNegativeNumberError(ArrayList<Integer> negatives) {
        String message = "Negatives not allowed: ";
        for(Integer negative : negatives) {
            message += negative + " ";
        }
        throw new RuntimeException(message);
    }

    private void findNegatives(ArrayList<Integer> numbers, ArrayList<Integer> negatives) {
        for(Integer number : numbers) {
            if(number < 0) {
                negatives.add(number);
            }
        }
    }
}
