package main.java.dev.joaov.calculator;

import main.java.dev.joaov.model.HistoryEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculator {
    private final Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();
    private OperationHistory operationHistory;

    public Calculator() {
        operations.put("+", Double::sum);
        operations.put("-", (n1, n2) -> n1 - n2);
        operations.put("*", (n1, n2) -> n1 * n2);
        operations.put("/", (n1, n2) -> n1 / n2);
        operations.put("%", (n1, n2) -> n1 % n2);
        operations.put("sqrt", (n1, n2) -> Math.sqrt(n1));
        operations.put("pow", Math::pow);
    }

    public Calculator(OperationHistory operationHistory) {
        this();
        this.operationHistory = operationHistory;
    }

    public double calculate(double a, String operator, double b) {
        if (operator == null) {
            throw new IllegalArgumentException("This operator does not exist");
        }

        if (operator.equals("/") && (b == 0)) {
            throw new ArithmeticException("Division by zero");
        }

        Double result = operations.getOrDefault(operator, (n1, n2) -> {
            throw new IllegalArgumentException("Invalid operation");
        }).apply(a, b);
        operationHistory.getHistory().add(new HistoryEntry(a, b, operator, result));

        return result;
    }

    public Double calculateAndThen(double a, String operator, double b, Function<Double, Double> transform) {
        double calculated = calculate(a, operator, b);

        return transform.apply(calculated);
    }
}
