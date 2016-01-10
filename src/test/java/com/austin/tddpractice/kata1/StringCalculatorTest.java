package com.austin.tddpractice.kata1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertThat(stringCalculator.add(""), is(0));
    }

    @Test
    public void shouldReturnNumberForSingleNumber() {
        assertThat(stringCalculator.add("1"), is(1));
    }

    @Test
    public void shouldReturnSumForTwoNumbersSeparatedByCommas() {
        assertThat(stringCalculator.add("1,2"), is(3));
    }

    @Test
    public void shouldReturnSumForAnyNumberOfNumbersSeparatedByCommas() {
        assertThat(stringCalculator.add("1,2,3,4"), is(10));
    }

    @Test
    public void shouldReturnSumForThreeNumbersSeparatedByCommasAndNewlines() {
        assertThat(stringCalculator.add("1\n2,3"), is(6));
    }

    @Test
    public void shouldReturnSumForTwoNumbersSeparatedByCustomDelimiter() {
        assertThat(stringCalculator.add("//;\n1;2"), is(3));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        try {
            stringCalculator.add("-1");
            fail("RuntimeException expected.");
        }
        catch(RuntimeException exc) {
            //test passes
        }
    }

    @Test
    public void shouldShowNegativeNumbersInExceptionMessage() {
        try {
            stringCalculator.add("-1,2,-3");
        }
        catch(RuntimeException exc) {
            assertThat(exc.getMessage(), is("Negatives not allowed: -1 -3 "));
        }
    }

    @Test
    public void shouldIgnoreNumbersLargerThan1000() {
        assertThat(stringCalculator.add("2,1001"), is(2));
    }

    @Test
    public void shouldHandleDelimitersOfAnyLength() {
        assertThat(stringCalculator.add("//[***]\n1***2***3"), is(6));
    }

}