package com.austin.tddpractice.kata1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldSumZeroArguments() {
        String arguments = "";

        int sum = stringCalculator.Add(arguments);

        assertThat(sum, is(0));
    }

}