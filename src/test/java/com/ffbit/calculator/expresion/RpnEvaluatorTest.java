package com.ffbit.calculator.expresion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RpnEvaluatorTest {
    private Token one = new Token("1", TokenType.LITERAL);
    private Token two = new Token("2", TokenType.LITERAL);
    private Token three = new Token("3", TokenType.LITERAL);
    private Token four = new Token("4", TokenType.LITERAL);

    private Token plus = new Token("+", TokenType.ADDITION);
    private Token minus = new Token("-", TokenType.SUBTRACTION);
    private Token multiply = new Token("*", TokenType.MULTIPLICATION);
    private Token divide = new Token("/", TokenType.DIVISION);

    private RpnEvaluator evaluator;
    private List<Token> rpnTokens;

    @Before
    public void setUp() throws Exception {
        evaluator = new RpnEvaluator();
    }

    @Test
    public void itShouldEvaluateEmptyListOfTokensToZero() throws Exception {
        rpnTokens = Collections.emptyList();

        assertThat(evaluator.evaluate(rpnTokens), is(0));
    }

    @Test
    public void itShouldEvaluateOneToOne() throws Exception {
        rpnTokens = Arrays.asList(one);

        assertThat(evaluator.evaluate(rpnTokens), is(1));
    }

    @Test
    public void itShouldEvaluateOnePlusTwoToThree() throws Exception {
        rpnTokens = Arrays.asList(one, two, plus);

        assertThat(evaluator.evaluate(rpnTokens), is(3));
    }

    @Test
    public void itShouldEvaluateTwoMultiplyByThreeToSix() throws Exception {
        rpnTokens = Arrays.asList(two, three, multiply);

        assertThat(evaluator.evaluate(rpnTokens), is(6));
    }

    @Test
    public void itShouldEvaluateOneMinusTwoToMinusOne() throws Exception {
        rpnTokens = Arrays.asList(one, two, minus);

        assertThat(evaluator.evaluate(rpnTokens), is(-1));
    }

    @Test
    public void itShouldEvaluateFourDivideByTwoToTwo() throws Exception {
        rpnTokens = Arrays.asList(four, two, divide);

        assertThat(evaluator.evaluate(rpnTokens), is(2));
    }

}
