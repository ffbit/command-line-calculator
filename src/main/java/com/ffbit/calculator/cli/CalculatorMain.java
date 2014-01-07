package com.ffbit.calculator.cli;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean wasInput = false;

        while (scanner.hasNext()) {
            wasInput = true;
            System.out.println(scanner.next());
        }

        if (!wasInput) {
            System.out.println();
        }
    }

}
