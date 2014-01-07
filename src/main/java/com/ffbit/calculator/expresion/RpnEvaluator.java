package com.ffbit.calculator.expresion;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Reverse Polish Notation Evaluator.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish notation</a>
 * @see <a href="http://en.wikipedia.org/wiki/Infix_notation">Infix notation</a>
 */
public class RpnEvaluator {

    /**
     * Evaluates a Reverse Polish Notation token sequence to int.
     *
     * @param tokens a RPN token sequence.
     * @return a integer evaluation result.
     */
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
                Integer right = stack.removeFirst();
                Integer left = stack.removeFirst();
                Integer result = 0;

                // TODO: There is should be inheritance instead of switch
                switch (token.getType()) {
                    case ADDITION:
                        result = left + right;
                        break;
                    case MULTIPLICATION:
                        result = left * right;
                        break;
                    case SUBTRACTION:
                        result = left - right;
                        break;
                    case DIVISION:
                        result = left / right;
                        break;
                }

                stack.addFirst(result);
            }
        }

        return stack.getFirst();
    }

}
