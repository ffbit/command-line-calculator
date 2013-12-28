package com.ffbit.calculator.expresion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TokenizerTest {
    private Tokenizer tokenizer;

    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }

    @Test
    public void itShouldTokenizeSingleDigitExpression() throws Exception {
        String expression = "1";

        assertThat(tokenizer.tokenize(expression), hasItem("1"));
        assertThat(tokenizer.tokenize(expression), hasSize(1));
    }

    @Test
    public void itShouldParseSimplestAdditionExpression() throws Exception {
        String expression = "1+2";

        assertThat(tokenizer.tokenize(expression), hasItems("1", "+", "2"));
        assertThat(tokenizer.tokenize(expression), hasSize(3));
    }

    @Test
    public void itShouldIgnoreWightSpaces() throws Exception {
        String expression = " 1  +   2 ";

        assertThat(tokenizer.tokenize(expression), hasItems("1", "+", "2"));
        assertThat(tokenizer.tokenize(expression), hasSize(3));
    }

}
