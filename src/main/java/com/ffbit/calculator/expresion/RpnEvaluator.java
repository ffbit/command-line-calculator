package com.ffbit.calculator.expresion;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RpnEvaluator {

    public int evaluate(List<Token> tokens) {
        if (tokens.isEmpty()) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();

        for (Token token : tokens) {
            if (token.isLiteral()) {
                Integer argument = Integer.valueOf(token.getLexeme());
                stack.addFirst(argument);
            } else {
                Integer left = stack.removeFirst();
                Integer right = stack.removeFirst();
                Integer result = 0;

                if (token.getType() == TokenType.ADDITION) {
                    result = left + right;
                } else if ((token.getType() == TokenType.MULTIPLICATION)) {
                    result = left * right;
                }

                stack.addFirst(result);
            }
        }

        return stack.getFirst();
    }

}
