package com.ffbit.calculator.expresion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tokenizer {

    public List<String> tokenize(String expression) {
        char[] chars = expression.toCharArray();
        List<String> tokens = new ArrayList<String>(chars.length);

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                int nextIndex = i;

                while (isNextDigit(expression, nextIndex)) {
                    nextIndex++;
                }

                tokens.add(expression.substring(i, nextIndex + 1));
                i = nextIndex;
            } else if (isOperator(c)) {
                tokens.add(String.valueOf(c));
            } else {
                throw new TokenizerException();
            }
        }

        return tokens;
    }

    private boolean isNextDigit(String expression, int currentIndex) {
        int nextIndex = currentIndex + 1;

        if (nextIndex == expression.length()) {
            return false;
        }

        return Character.isDigit(expression.charAt(nextIndex));
    }

    private boolean isOperator(char c) {
        final Set<Character> operations =
                new HashSet<Character>(Arrays.asList('+', '-', '*', '/'));

        return operations.contains(c);
    }

}
