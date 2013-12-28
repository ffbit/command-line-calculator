package com.ffbit.calculator.expresion;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TokenizerTest {

    @Test
    public void itShouldTokenizeSingleDigitExpression() throws Exception {
        String expression = "1";
        Tokenizer tokenizer = new Tokenizer();
        assertThat(tokenizer.tokenize(expression), allOf((Matcher) hasSize(1), hasItem("1")));
    }

    @Test
    public void itShouldParseSimplestAdditionExpression() throws Exception {
        String expression = "1+2";
        Tokenizer tokenizer = new Tokenizer();

        assertThat(tokenizer.tokenize(expression),
                allOf((Matcher) hasSize(3), hasItems("1", "+", "2")));
    }

}
