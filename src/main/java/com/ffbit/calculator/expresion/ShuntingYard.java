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
            if (token.getType() == TokenType.LITERAL) {
                output.add(token);
            } else {
                operatorStack.add(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        return output;
    }

}
