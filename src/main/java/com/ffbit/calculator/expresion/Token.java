package com.ffbit.calculator.expresion;

public class Token {
    private final String lexeme;
    private final TokenType type;

    public Token(String lexeme, TokenType type) {
        this.lexeme = lexeme;
        this.type = type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public TokenType getType() {
        return type;
    }

}
