package main.java.dev.joaov;

import main.java.dev.joaov.calculator.Calculator;
import main.java.dev.joaov.calculator.OperationHistory;

public class Main {
    public static void main(String[] args) {
        OperationHistory operationHistory = new OperationHistory();
        Calculator calculator = new Calculator(operationHistory);

        System.out.println(calculator.calculate(5, "-", 3));
        System.out.println(calculator.calculate(5, "*", 3));
        System.out.println(calculator.calculate(5, "+", 3));
        System.out.println(calculator.calculate(5, "/", 3));
        System.out.println(calculator.calculate(5, "%", 3));
        System.out.println(calculator.calculate(2, "+", 2));
        System.out.println(calculator.calculate(10, "/", 3));
        System.out.println(calculator.calculate(81, "sqrt", 0));
        System.out.println(calculator.calculate(5, "pow", 2));
        System.out.println(operationHistory.getHistory());
        System.out.println(calculator.calculateAndThen(-3, "+", -5, Math::abs));

    }
}
