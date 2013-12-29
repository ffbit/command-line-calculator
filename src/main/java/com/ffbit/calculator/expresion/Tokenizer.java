package com.ffbit.calculator.expresion;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public List<String> tokenize(String expression) {
        char[] chars = expression.toCharArray();
        List<String> tokens = new ArrayList<String>(chars.length);

        for (char c : chars) {
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)
                    || c == '+'
                    || c == '-') {
                tokens.add(String.valueOf(c));
            } else {
                throw new TokenizerException();
            }
        }

        return tokens;
    }

}
