package com.ffbit.calculator.expresion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
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

        assertThat(tokenizer.tokenize(expression), hasItem("1"));
        assertThat(tokenizer.tokenize(expression), hasSize(1));
    }

    @Test
    public void itShouldParseSimplestAdditionExpression() throws Exception {
        expression = "1+2";

        assertThat(tokenizer.tokenize(expression), hasItems("1", "+", "2"));
        assertThat(tokenizer.tokenize(expression), hasSize(3));
    }

    @Test
    public void itShouldTokenizeSimplestSubtractionExpression() throws Exception {
        expression = "1-2";

        assertThat(tokenizer.tokenize(expression), hasItems("1", "-", "2"));
        assertThat(tokenizer.tokenize(expression), hasSize(3));
    }

    @Test
    public void itShouldIgnoreWightSpaces() throws Exception {
        expression = " 1  +   2 ";

        assertThat(tokenizer.tokenize(expression), hasItems("1", "+", "2"));
        assertThat(tokenizer.tokenize(expression), hasSize(3));
    }

    @Test(expected = TokenizerException.class)
    public void itShouldNotAllowNonArithmeticalSymbols() throws Exception {
        expression = "a";

        tokenizer.tokenize(expression);
    }

}
