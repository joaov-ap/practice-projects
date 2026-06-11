package main.java.dev.joaov.pipeline;

import main.java.dev.joaov.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public final class TransformPipeline {
    private TransformPipeline(){}

    public static List<String> extractNames(List<Product> products) {
        return products.stream()
                .map(Product::getName)
                .toList();
    }

    public static List<Product> convertPricesToDollar(List<Product> products, BigDecimal exchange, BigDecimal tax) {
        return products.stream()
                .map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice().divide(exchange, RoundingMode.FLOOR).add(tax),
                        p.getStock(), p.isActive(), p.getTags()))
                .toList();
    }

    public static List<String> formattedProduct(List<Product> products) {
        return products.stream()
                .map(p -> "%d | %s | %s | $%s | %d | %s | %s".formatted(
                        p.getId(), p.getName(), p.getCategory(), p.getPrice(),
                        p.getStock(), p.isActive(), p.getTags()))
                .toList();
    }

    public static List<String> extractUniqueTags(List<Product> products) {
        return products.stream()
                .flatMap(p -> p.getTags().stream())
                .distinct()
                .toList();
    }
}
