package main.java.dev.joaov.calculator;

import main.java.dev.joaov.model.HistoryEntry;

import java.util.ArrayList;
import java.util.List;

public class OperationHistory {
    private final List<HistoryEntry> history = new ArrayList<>();

    public OperationHistory() {
    }

    public List<HistoryEntry> getHistory() {
        return history;
    }

    public void showHistory() {
        history.forEach(System.out::println);
    }

    public void cleanHistory() {
        history.clear();
    }
}
