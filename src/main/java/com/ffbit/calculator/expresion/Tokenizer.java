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

        for (char c : chars) {
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)
                    || isOperator(c)) {
                tokens.add(String.valueOf(c));
            } else {
                throw new TokenizerException();
            }
        }

        return tokens;
    }

    private boolean isOperator(char c) {
        final Set<Character> operations =
                new HashSet<Character>(Arrays.asList('+', '-', '*', '/'));

        return operations.contains(c);
    }

}
