package com.ffbit.calculator.expresion;

public class TokenizerException extends RuntimeException {
    private static final long serialVersionUID = 7500171759515966149L;

    public TokenizerException(char badSymbol, int position) {
        super("Bad symbol '" + badSymbol + "' occurred at position '" + position + "'");
    }
}
