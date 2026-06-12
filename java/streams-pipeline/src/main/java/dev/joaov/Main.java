package main.java.dev.joaov;

import data.DataGenerator;
import main.java.dev.joaov.model.Product;
import main.java.dev.joaov.pipeline.AdvancedPipeline;
import main.java.dev.joaov.pipeline.AggregatePipeline;
import main.java.dev.joaov.pipeline.FilterPipeline;
import main.java.dev.joaov.pipeline.TransformPipeline;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Product> products = DataGenerator.generate();
//        filterPipeLineTest(products);
//        transformPipelineTest(products);
//        aggregatePipeline(products);

    }

    public static void filterPipeLineTest(List<Product> products) {
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

    public static void transformPipelineTest(List<Product> products) {
        List<String> extractedNames = TransformPipeline.extractNames(products);
        extractedNames.forEach(System.out::println);
        System.out.println();

        List<Product> convertedProductsPrice = TransformPipeline.convertPricesToDollar(products, new BigDecimal("5"), new BigDecimal("3"));
        convertedProductsPrice.forEach(System.out::println);
        System.out.println();

        List<String> formattedProducts = TransformPipeline.formattedProduct(products);
        formattedProducts.forEach(System.out::println);
        System.out.println();

        List<String> uniqueTags = TransformPipeline.extractUniqueTags(products);
        uniqueTags.forEach(System.out::println);
    }

    public static void aggregatePipeline(List<Product> products) {
        Map<String, Double> averagePrice = AggregatePipeline.averagePriceByCategory(products);
        System.out.println(averagePrice);

        Map<String, Product> expenseProductByCategory = AggregatePipeline.mostExpensiveProductByCategory(products);
        System.out.println(expenseProductByCategory);

        Map<String, Integer> totalStockByCategory = AggregatePipeline.totalStockByCategory(products);
        System.out.println(totalStockByCategory);

        Map<String, Long> activeProductsByCategory = AggregatePipeline.totalActiveProductsByCategory(products);
        System.out.println(activeProductsByCategory);
    }
}
