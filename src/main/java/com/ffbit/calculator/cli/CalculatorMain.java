package com.ffbit.calculator.cli;

import com.ffbit.calculator.expresion.RpnEvaluator;
import com.ffbit.calculator.expresion.ShuntingYard;
import com.ffbit.calculator.expresion.Token;
import com.ffbit.calculator.expresion.Tokenizer;

import java.util.List;
import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            List<Token> rpnTokens = toReversePolishNotation(expression);

            RpnEvaluator evaluator = new RpnEvaluator();
            int result = evaluator.evaluate(rpnTokens);

            System.out.println(result);
        }
    }

    private static List<Token> toReversePolishNotation(String expression) {
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(expression);

        ShuntingYard shuntingYard = new ShuntingYard();
        return shuntingYard.toRpn(tokens);
    }

}
