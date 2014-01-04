package com.ffbit.calculator.expresion;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class ShuntingYardTest {

    @Test
    public void itShouldShuntSimplestAdditionTokensToReversePolishNotation()
            throws Exception {
        ShuntingYard shuntingYard = new ShuntingYard();
        Token one = new Token("1", TokenType.LITERAL);
        Token plus = new Token("+", TokenType.ADDITION);
        Token two = new Token("2", TokenType.LITERAL);
        List<Token> tokens = Arrays.asList(one, plus, two);

        assertThat(shuntingYard.toRpn(tokens), contains(one, two, plus));
    }

}
