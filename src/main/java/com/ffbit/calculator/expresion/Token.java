package com.ffbit.calculator.expresion;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token that = (Token) o;

        return Objects.equals(lexeme, that.lexeme)
                && Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return "Token{" +
                "lexeme='" + lexeme + '\'' +
                ", type=" + type +
                '}';
    }

    public boolean isLiteral() {
        return type == TokenType.LITERAL;
    }

    public int getPrecedence() {
        return type.getPrecedence();
    }

}
