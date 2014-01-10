package com.ffbit.calculator.expresion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Edsger Dijkstra's Shunting-yard algorithm implementation.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Shunting-yard_algorithm">Shunting-yard algorithm</a>
 */

public class ShuntingYard {

    /**
     * Shunts a tokens list in Infix Notation to a new one in Reverse Polish Notation.
     *
     * @param input Infix Notation tokens list
     * @return a new tokens list in Reverse Polish Notation
     * @see <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish notation</a>
     * @see <a href="http://en.wikipedia.org/wiki/Infix_notation">Infix notation</a>
     */
    public List<Token> toRpn(List<Token> input) {
        List<Token> output = new ArrayList<>();
        Deque<Token> operatorStack = new LinkedList<>();

        for (Token token : input) {
            if (token.isLiteral()) {
                output.add(token);
            } else if (token.getType() == TokenType.L_PAREN) {
                operatorStack.addFirst(token);
            } else if (token.getType() == TokenType.R_PAREN) {
                while (operatorStack.peekFirst().getType() != TokenType.L_PAREN) {
                    output.add(operatorStack.removeFirst());
                }

                operatorStack.removeFirst();
            } else {
                while (!operatorStack.isEmpty()
                        && token.getPrecedence() <= operatorStack.peekFirst().getPrecedence()) {
                    output.add(operatorStack.removeFirst());
                }

                operatorStack.addFirst(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.removeFirst());
        }

        return output;
    }

}
