package main.java.dev.joaov.pipeline;

import main.java.dev.joaov.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public final class AggregatePipeline {
    private AggregatePipeline(){}

    public static Map<String, Double> averagePriceByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(p -> p.getPrice().doubleValue())));
    }

    public static Map<String, Product> mostExpensiveProductByCategory(List<Product> products) {
         return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice)), Optional::get)));
    }

    public static Map<String, Integer> totalStockByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingInt(Product::getStock)));
    }

    public static Map<String, Long> totalActiveProductsByCategory(List<Product> products) {
        return products.stream()
                .filter(Product::isActive)
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.counting()));
    }
}
