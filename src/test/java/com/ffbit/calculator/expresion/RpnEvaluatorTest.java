package com.ffbit.calculator.expresion;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RpnEvaluatorTest {

    @Test
    public void itShouldEvaluateEmptyListOfTokensToZero() throws Exception {
        RpnEvaluator evaluator = new RpnEvaluator();

        assertThat(evaluator.evaluate(Collections.<Token>emptyList()), is(0));
    }

    @Test
    public void itShouldEvaluateOneToOne() throws Exception {
        RpnEvaluator evaluator = new RpnEvaluator();
        List<Token> rpnTokens = Arrays.asList(new Token("1", TokenType.LITERAL));

        assertThat(evaluator.evaluate(rpnTokens), is(1));
    }

    @Test
    public void itShouldEvaluateOnePlusTwoToThree() throws Exception {
        RpnEvaluator evaluator = new RpnEvaluator();
        List<Token> rpnTokens = Arrays.asList(
                new Token("1", TokenType.LITERAL),
                new Token("2", TokenType.LITERAL),
                new Token("+", TokenType.ADDITION)
        );

        assertThat(evaluator.evaluate(rpnTokens), is(3));
    }

}
