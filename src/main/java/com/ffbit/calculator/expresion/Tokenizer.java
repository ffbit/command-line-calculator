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
            } else if (Character.isDigit(c)) {
                String number = readNumber(expression, i);
                tokens.add(number);
                i = i + number.length() - 1;
            } else if (isOperator(c)) {
                tokens.add(String.valueOf(c));
            } else {
                throw new TokenizerException();
            }
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

    private boolean isOperator(char c) {
        final Set<Character> operations =
                new HashSet<Character>(Arrays.asList('+', '-', '*', '/'));

        return operations.contains(c);
    }

}
