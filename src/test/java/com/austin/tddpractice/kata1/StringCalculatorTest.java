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

        int sum = 0;
        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(0));
    }

    @Test
    public void shouldSumOneArgument() {
        String arguments = "1";

        int sum = 0;
        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(1));
    }

    @Test
    public void shouldSumTwoArguments() {
        String arguments = "1,2";

        int sum = 0;
        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(3));
    }

    @Test
    public void shouldSumNArguments() {
        String arguments = "1,2,3";

        int sum = 0;
        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(6));

        arguments = "1,2,3,4,5,6,7";

        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(28));
    }

    @Test
    public void shouldHandleNewlinesAsDelimiters() {
        String arguments = "1\n2,3";

        int sum = 0;
        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(6));
    }

    @Test
    public void shouldSupportCustomDelimiters() {
        String arguments = "//;\n1;2";
        int sum = 0;
        try {
            sum = stringCalculator.Add(arguments);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        assertThat(sum, is(3));
    }

    @Test
    public void shouldReportNegativeArguments() {
        String arguments = "1,-2,3,4,5,-6,-7";

        int sum = 0;
        String message = "";
        try {
            sum = stringCalculator.Add(arguments);
        }
        catch(NegativeArgumentException exception) {
            message = exception.getMessage();
        }

        assertThat(sum, is(0));
        assertThat(message, is("Negatives not allowed: -2 -6 -7 "));
    }

}