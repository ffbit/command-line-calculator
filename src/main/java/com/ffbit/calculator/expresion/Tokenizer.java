package com.ffbit.calculator.expresion;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public List<Token> tokenize(String expression) {
        char[] chars = expression.toCharArray();
        List<Token> tokens = new ArrayList<>(chars.length);

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c)) {
                continue;
            }

            String lexeme = String.valueOf(c);
            TokenType type = TokenType.LITERAL;

            if (Character.isDigit(c)) {
                lexeme = readNumber(expression, i);
                i = i + lexeme.length() - 1;
            } else if (c == '+') {
                type = TokenType.ADDITION;
            } else if (c == '-') {
                type = TokenType.SUBTRACTION;
            } else if (c == '*') {
                type = TokenType.MULTIPLICATION;
            } else if (c == '/') {
                type = TokenType.DIVISION;
            } else {
                throw new TokenizerException(c, i);
            }

            tokens.add(new Token(lexeme, type));
        }

        return tokens;
    }

    private String readNumber(String expression, int startIndex) {
        int endIndex = startIndex;

        while (endIndex < expression.length()
                && Character.isDigit(expression.charAt(endIndex))) {
            endIndex++;
        }

        return expression.substring(startIndex, endIndex);
    }

}
