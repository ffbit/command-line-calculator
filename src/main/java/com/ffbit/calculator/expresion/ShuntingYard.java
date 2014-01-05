package com.ffbit.calculator.expresion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ShuntingYard {

    public List<Token> toRpn(List<Token> input) {
        List<Token> output = new ArrayList<>();
        Deque<Token> operatorStack = new LinkedList<>();

        for (Token token : input) {
            if (token.isLiteral()) {
                output.add(token);
            } else {
                while (!operatorStack.isEmpty()
                        && operatorStack.peekFirst().getType().getPrecedence() >= token.getType().getPrecedence()) {
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
