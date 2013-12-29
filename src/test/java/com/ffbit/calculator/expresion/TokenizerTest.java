package com.ffbit.calculator.expresion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class TokenizerTest {
    private Tokenizer tokenizer;
    private String expression;

    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }

    @Test
    public void itShouldTokenizeSingleDigitExpression() throws Exception {
        expression = "1";

        assertThat(tokenizer.tokenize(expression), contains("1"));
    }

    @Test
    public void itShouldParseSimplestAdditionExpression() throws Exception {
        expression = "1+2";

        assertThat(tokenizer.tokenize(expression), contains("1", "+", "2"));
    }

    @Test
    public void itShouldTokenizeSimplestSubtractionExpression() throws Exception {
        expression = "1-2";

        assertThat(tokenizer.tokenize(expression), contains("1", "-", "2"));
    }

    @Test
    public void itShouldTokenizeSimplestMultiplicationExpression() throws Exception {
        expression = "1*2";

        assertThat(tokenizer.tokenize(expression), contains("1", "*", "2"));
    }

    @Test
    public void itShouldTokenizeSimplestDivisionExpression() throws Exception {
        expression = "1/2";

        assertThat(tokenizer.tokenize(expression), contains("1", "/", "2"));
    }

    @Test
    public void itShouldIgnoreWightSpaces() throws Exception {
        expression = " 1  +   2 ";

        assertThat(tokenizer.tokenize(expression), contains("1", "+", "2"));
    }

    @Test(expected = TokenizerException.class)
    public void itShouldNotAllowNonArithmeticalSymbols() throws Exception {
        expression = "a";

        tokenizer.tokenize(expression);
    }

}
