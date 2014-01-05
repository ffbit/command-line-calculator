package com.ffbit.calculator.expresion;

import org.junit.Test;

import static com.ffbit.calculator.expresion.TokenType.ADDITION;
import static com.ffbit.calculator.expresion.TokenType.DIVISION;
import static com.ffbit.calculator.expresion.TokenType.MULTIPLY;
import static com.ffbit.calculator.expresion.TokenType.SUBTRACTION;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class TokenTypeTest {

    @Test
    public void AdditionShouldHaveSamePrecedenceAsAddition() throws Exception {
        assertThat(ADDITION.getPrecedence(), is(comparesEqualTo(ADDITION.getPrecedence())));
    }

    @Test
    public void MultiplicationShouldHaveGreaterPrecedenceThanAddition() throws Exception {
        assertThat(MULTIPLY.getPrecedence(), is(greaterThan(ADDITION.getPrecedence())));
    }

    @Test
    public void AdditionShouldHaveSamePrecedenceAsSubtraction() throws Exception {
        assertThat(ADDITION.getPrecedence(), is(comparesEqualTo(SUBTRACTION.getPrecedence())));
    }

    @Test
    public void MultiplicationShouldHaveSamePrecedenceAsDivision() throws Exception {
        assertThat(MULTIPLY.getPrecedence(), is(comparesEqualTo(DIVISION.getPrecedence())));
    }

}
