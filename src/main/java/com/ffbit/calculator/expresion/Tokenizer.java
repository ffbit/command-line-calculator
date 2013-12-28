package com.ffbit.calculator.expresion;

import java.util.ArrayList;
import java.util.Collection;

public class Tokenizer {

    public Collection<String> tokenize(String expression) {
        char[] chars = expression.toCharArray();
        Collection<String> tokens = new ArrayList<String>(chars.length);

        for (char c : chars) {
            tokens.add(String.valueOf(c));
        }

        return tokens;
    }

}
