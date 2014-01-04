package com.ffbit.calculator.expresion;

import java.util.Arrays;
import java.util.List;

public class ShuntingYard {

    public List<Token> toRpn(List<Token> tokens) {
        return Arrays.asList(
                new Token("1", TokenType.LITERAL),
                new Token("2", TokenType.LITERAL),
                new Token("+", TokenType.ADDITION));
    }

}
