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
                if (token.getType() == TokenType.ADDITION) {
                    Integer left = stack.removeFirst();
                    Integer right = stack.removeFirst();
                    Integer result = left + right;
                    stack.addFirst(result);
                } else if ((token.getType() == TokenType.MULTIPLICATION)) {
                    Integer left = stack.removeFirst();
                    Integer right = stack.removeFirst();
                    Integer result = left * right;
                    stack.addFirst(result);
                }
            }
        }

        return stack.getFirst();
    }

}
