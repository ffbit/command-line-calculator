package com.ffbit.calculator.expresion;

public enum TokenType {
    LITERAL,
    ADDITION(1),
    SUBTRACTION,
    MULTIPLY(2);

    private int precedence;

    TokenType() {
    }

    TokenType(int precedence) {
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

}
