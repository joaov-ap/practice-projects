package main.java.dev.joaov.processor;

import main.java.dev.joaov.model.ProductCategory;
import main.java.dev.joaov.model.Sale;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SaleProcessor {
    public List<Sale> categoryFilter(List<Sale> saleList, ProductCategory category) {
        List<Sale> sales = saleList.stream()
                .filter(s -> s.getProductCategory().equals(category))
                .toList();

        return sales;
    }

    public Map<ProductCategory, Double> sumTotalAmount(List<Sale> saleList) {
        Map<ProductCategory, Double> totalAmount = saleList.stream()
                .collect(Collectors.groupingBy(Sale::getProductCategory,
                        Collectors.summingDouble(s -> s.getTotalAmount().doubleValue())));

        return totalAmount;
    }

    public List<Sale> top5Sales(List<Sale> saleList) {
        List<Sale> bestSales = saleList.stream()
                .sorted(Comparator.comparing(Sale::getTotalAmount, Collections.reverseOrder()))
                .limit(5)
                .toList();

        return bestSales;
    }
}
