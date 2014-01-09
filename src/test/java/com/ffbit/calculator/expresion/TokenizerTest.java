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

public class TokenizerTest {
    private Token one = new Token("1", TokenType.LITERAL);
    private Token two = new Token("2", TokenType.LITERAL);
    private Token twelve = new Token("12", TokenType.LITERAL);

    private Token plus = new Token("+", TokenType.ADDITION);
    private Token minus = new Token("-", TokenType.SUBTRACTION);
    private Token multiply = new Token("*", TokenType.MULTIPLICATION);
    private Token divide = new Token("/", TokenType.DIVISION);

    private Tokenizer tokenizer;
    private String expression;

    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }

    @Test
    public void itShouldTokenizeSingleDigitExpression() throws Exception {
        expression = "1";

        assertThat(tokenizer.tokenize(expression), contains(one));
    }

    @Test
    public void itShouldParseSimplestAdditionExpression() throws Exception {
        expression = "1+2";

        assertThat(tokenizer.tokenize(expression), contains(one, plus, two));
    }

    @Test
    public void itShouldTokenizeSimplestSubtractionExpression() throws Exception {
        expression = "1-2";

        assertThat(tokenizer.tokenize(expression), contains(one, minus, two));
    }

    @Test
    public void itShouldTokenizeSimplestMultiplicationExpression() throws Exception {
        expression = "1*2";

        assertThat(tokenizer.tokenize(expression), contains(one, multiply, two));
    }

    @Test
    public void itShouldTokenizeSimplestDivisionExpression() throws Exception {
        expression = "1/2";

        assertThat(tokenizer.tokenize(expression), contains(one, divide, two));
    }

    @Test
    public void itShouldIgnoreWightSpaces() throws Exception {
        expression = " 1  +   2 ";

        assertThat(tokenizer.tokenize(expression), contains(one, plus, two));
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
        Token[] expected = {twelve};

        List<Token> actual = tokenizer.tokenize(expression);
        String reason = format("actual is %s but expected %s", actual, Arrays.toString(expected));
        assertThat(reason, actual, contains(expected));
    }

    @Test
    public void itShouldTokenizeParenthesis() throws Exception {
        expression = "(1 + 2)";

        assertThat(tokenizer.tokenize(expression),
                contains(new Token("(", TokenType.L_PAREN),
                        one, plus, two,
                        new Token(")", TokenType.R_PAREN)));
    }

}
