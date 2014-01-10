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
    private Token three = new Token("3", TokenType.LITERAL);
    private Token four = new Token("4", TokenType.LITERAL);

    private Token plus = new Token("+", TokenType.ADDITION);
    private Token minus = new Token("-", TokenType.SUBTRACTION);
    private Token multiply = new Token("*", TokenType.MULTIPLICATION);
    private Token divide = new Token("/", TokenType.DIVISION);

    private Token lparen = new Token("(", TokenType.L_PAREN);
    private Token rparen = new Token(")", TokenType.R_PAREN);

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

    @Test
    public void itShouldShuntSimplestMultiplicationTokensToReversePolishNotation()
            throws Exception {
        inputTokens = Arrays.asList(one, multiply, two);

        assertThat(shuntingYard.toRpn(inputTokens), contains(one, two, multiply));
    }

    @Test
    public void itShouldShuntSimplestDivisionTokensToReversePolishNotation()
            throws Exception {
        inputTokens = Arrays.asList(one, divide, two);

        assertThat(shuntingYard.toRpn(inputTokens), contains(one, two, divide));
    }

    @Test
    public void itShouldShuntInRespectToOperatorsPrecedence() throws Exception {
        inputTokens = Arrays.asList(one, plus, two, multiply, three, plus, four);

        List<Token> expected = Arrays.asList(one, two, three, multiply, plus, four, plus);
        List<Token> actual = shuntingYard.toRpn(inputTokens);
        String reason = String.format("%nexpected <%s>%n but was <%s>", expected, actual);

        assertThat(reason, actual, contains(expected.toArray()));
    }

    @Test
    public void itShouldShuntInRespectToParenthesis() throws Exception {
        inputTokens = Arrays.asList(lparen, one, plus, two, rparen, multiply, three);

        assertThat(shuntingYard.toRpn(inputTokens), contains(one, two, plus, three, multiply));
    }

}
