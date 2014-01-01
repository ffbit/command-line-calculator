package com.ffbit.calculator.expresion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

    @Test
    public void itShouldNotAllowNonArithmeticalSymbolsWithMeaningfulMessage() throws Exception {
        expression = "a";

        catchException(tokenizer).tokenize(expression);

        assertThat(caughtException(), is(instanceOf(TokenizerException.class)));
        assertThat(caughtException().getMessage(), is("Bad symbol 'a' occurred at position '0'"));
    }

    @Test
    public void itShouldTokenizeMultiDigitExpression() throws Exception {
        expression = "12";
        String[] expected = {"12"};

        List<String> actual = tokenizer.tokenize(expression);
        String reason = format("actual is %s but expected %s", actual, Arrays.toString(expected));
        assertThat(reason, actual, contains(expected));
    }

}
