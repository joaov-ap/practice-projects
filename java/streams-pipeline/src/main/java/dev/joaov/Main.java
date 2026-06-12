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
        filterPipeLineTest(products);
        transformPipelineTest(products);
        aggregatePipeline(products);
        advancedPipelineTest(products);
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
        averagePrice.forEach((cat, avg) -> System.out.printf("%-12s R$ %.2f%n", cat, avg));

        Map<String, Product> expenseProductByCategory = AggregatePipeline.mostExpensiveProductByCategory(products);
        expenseProductByCategory.forEach((cat, p) ->
                System.out.printf("%-12s %-20s R$ %8.2f%n", cat, p.getName(), p.getPrice()));

        Map<String, Integer> totalStockByCategory = AggregatePipeline.totalStockByCategory(products);
        totalStockByCategory.forEach((cat, stock) ->
                System.out.printf("%-12s %d unidades%n", cat, stock));

        Map<String, Long> activeProductsByCategory = AggregatePipeline.totalActiveProductsByCategory(products);
        activeProductsByCategory.forEach((cat, count) ->
                System.out.printf("%-12s %d ativos%n", cat, count));
    }

    public static void advancedPipelineTest(List<Product> products) {
        BigDecimal totalPriceInStock = AdvancedPipeline.totalPriceInStock(products);
        System.out.printf("Valor total do inventário: R$ %.2f%n%n", totalPriceInStock);

        System.out.println();
        Map<Boolean, List<Product>> expensiveCheapDivision = AdvancedPipeline.expensiveCheapDivision(products, new BigDecimal("150.00"));
        List<Product> expensiveProducts = expensiveCheapDivision.get(true);
        List<Product> cheapProducts = expensiveCheapDivision.get(false);

        expensiveProducts.forEach(System.out::println);
        System.out.println();
        cheapProducts.forEach(System.out::println);
        System.out.println();

        List<Product> orderByCategoryAndDescPrice = AdvancedPipeline.orderByCategoryAndDescPrice(products);
        System.out.println(orderByCategoryAndDescPrice);

        System.out.println();
        List<Product> takeWhileStockLowerThan = AdvancedPipeline.takeWhileStockLowerThan(products, 100);
        takeWhileStockLowerThan.forEach(System.out::println);
    }
}
