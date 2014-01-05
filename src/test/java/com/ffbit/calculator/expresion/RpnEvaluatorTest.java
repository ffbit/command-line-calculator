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

    private Token plus = new Token("+", TokenType.ADDITION);
    private Token multiply = new Token("*", TokenType.MULTIPLICATION);

    private RpnEvaluator evaluator;

    @Before
    public void setUp() throws Exception {
        evaluator = new RpnEvaluator();
    }

    @Test
    public void itShouldEvaluateEmptyListOfTokensToZero() throws Exception {
        List<Token> rpnTokens = Collections.emptyList();

        assertThat(evaluator.evaluate(rpnTokens), is(0));
    }

    @Test
    public void itShouldEvaluateOneToOne() throws Exception {
        List<Token> rpnTokens = Arrays.asList(one);

        assertThat(evaluator.evaluate(rpnTokens), is(1));
    }

    @Test
    public void itShouldEvaluateOnePlusTwoToThree() throws Exception {
        List<Token> rpnTokens = Arrays.asList(one, two, plus);

        assertThat(evaluator.evaluate(rpnTokens), is(3));
    }

    @Test
    public void itShouldEvaluateTwoMultiplyByThreeToSix() throws Exception {
        List<Token> rpnTokens = Arrays.asList(two, three, multiply);

        assertThat(evaluator.evaluate(rpnTokens), is(6));
    }

}
