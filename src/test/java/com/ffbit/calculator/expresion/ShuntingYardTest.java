package com.ffbit.calculator.expresion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class ShuntingYardTest {
    private Token one = new Token("1", TokenType.LITERAL);
    private Token two = new Token("2", TokenType.LITERAL);

    private Token plus = new Token("+", TokenType.ADDITION);
    private Token minus = new Token("-", TokenType.SUBTRACTION);

    private ShuntingYard shuntingYard;
    private List<Token> inputTokens;

    @Before
    public void setUp() throws Exception {
        shuntingYard = new ShuntingYard();
    }

    @Test
    public void itShouldShuntSimplestAdditionTokensToReversePolishNotation()
            throws Exception {
        inputTokens = Arrays.asList(one, plus, two);

        assertThat(shuntingYard.toRpn(inputTokens), contains(one, two, plus));
    }

    @Test
    public void itShouldShuntSimplestSubtractionTokensToReversePolishNotation()
            throws Exception {
        inputTokens = Arrays.asList(one, minus, two);

        assertThat(shuntingYard.toRpn(inputTokens), contains(one, two, minus));
    }

}
