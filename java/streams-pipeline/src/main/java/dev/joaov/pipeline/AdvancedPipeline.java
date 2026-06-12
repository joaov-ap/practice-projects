package main.java.dev.joaov.pipeline;

import main.java.dev.joaov.model.Product;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class AdvancedPipeline {
    private AdvancedPipeline() {}

    public static BigDecimal totalPriceInStock(List<Product> products) {
        return products.stream()
                .reduce(BigDecimal.ZERO, (acc, p) -> p.getPrice().multiply(new BigDecimal(p.getStock())).add(acc), BigDecimal::add);
    }

    public static Map<Boolean, List<Product>> expensiveCheapDivision(List<Product> products, BigDecimal divisionValue) {
        return products.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice().compareTo(divisionValue) > 0));
    }

    public static List<Product> orderByCategoryAndDescPrice(List<Product> products) {
        return  products.stream()
                .sorted(Comparator.comparing(Product::getCategory)
                        .thenComparing(Product::getPrice, Comparator.reverseOrder()))
                .toList();
    }

    public static List<Product> takeWhileStockLowerThan(List<Product> products, int maxStock) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getStock))
                .takeWhile(p -> p.getStock() < maxStock)
                .toList();
    }
}
