package com.ffbit.calculator.expresion;

public enum TokenType {
    LITERAL,
    ADDITION(1),
    SUBTRACTION(1),
    MULTIPLICATION(2),
    DIVISION(2),
    L_PAREN,
    R_PAREN;

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
