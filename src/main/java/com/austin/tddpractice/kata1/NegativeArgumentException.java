package com.austin.tddpractice.kata1;


import java.util.List;

public class NegativeArgumentException extends Exception {

    List<Integer> arguments;

    public NegativeArgumentException(List<Integer> numbers) {
        this.arguments = numbers;
    }

    @Override
    public String getMessage() {
        String message = "Negatives not allowed: ";
        for(Integer number : arguments)
            message += number.toString() + " ";
        return message;
    }
}
