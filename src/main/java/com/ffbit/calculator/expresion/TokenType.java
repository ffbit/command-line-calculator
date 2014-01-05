package com.ffbit.calculator.expresion;

public enum TokenType {
    LITERAL,
    ADDITION,
    SUBTRACTION,
    MULTIPLY;

    public int getPrecedence() {
        return 0;
    }

}
