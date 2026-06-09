package main.java.dev.joaov.pipeline;

import main.java.dev.joaov.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class FilterPipeline {
    public static List<Product> activeProducts(List<Product> products) {
        return products.stream().filter(Product::isActive).toList();
    }

    public static List<Product> priceHigherThan(List<Product> products, BigDecimal price) {
        return products.stream().filter(p -> p.getPrice().compareTo(price) > 0).toList();
    }

    public static List<Product> productsByCategory(List<Product> products, String category) {
        return products.stream().filter(p -> p.getCategory().equals(category)).toList();
    }

    public static List<Product> stockBetweenMinMax(List<Product> products, int minStock, int maxStock) {
        return products.stream().filter(p -> p.getStock() >= minStock && p.getStock() <= maxStock).toList();
    }

    public static List<Product> activePriceHigherCategory(List<Product> products, BigDecimal price, String category) {
        return products.stream()
                .filter(Product::isActive)
                .filter(p -> p.getPrice().compareTo(price) > 0)
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }
}
