package main.java.dev.joaov;

import data.DataGenerator;
import main.java.dev.joaov.model.Product;
import main.java.dev.joaov.pipeline.FilterPipeline;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = DataGenerator.generate();
        List<Product> activeProducts = FilterPipeline.activeProducts(products);
        activeProducts.forEach(System.out::println);
        System.out.println();

        BigDecimal price = new BigDecimal("300.00");
        List<Product> priceHigherThan = FilterPipeline.priceHigherThan(products, price);
        priceHigherThan.forEach(System.out::println);
        System.out.println();

        String category = "Food";
        List<Product> foodProducts = FilterPipeline.productsByCategory(products, category);
        foodProducts.forEach(System.out::println);
        System.out.println();

        int minStock = 25;
        int maxStock = 100;
        List<Product> stockBetweenMinMax = FilterPipeline.stockBetweenMinMax(products, minStock, maxStock);
        stockBetweenMinMax.forEach(System.out::println);
        System.out.println();

        List<Product> activePriceHigherCategory = FilterPipeline.activePriceHigherCategory(products, price, "Electronics");
        activePriceHigherCategory.forEach(System.out::println);
        System.out.println();
    }
}
