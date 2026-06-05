package main.java.dev.joaov;

import main.java.dev.joaov.model.ProductCategory;
import main.java.dev.joaov.model.Sale;
import main.java.dev.joaov.processor.SaleProcessor;
import main.java.dev.joaov.reader.CsvReader;
import main.java.dev.joaov.writer.CsvWriter;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String filePath = path +"/src/data/";
        var csvReader = new CsvReader(filePath + "input/retail_sales_dataset.csv");
        List<Sale> retailSales = csvReader.reader();

        String fileName = "electronics_sale.csv";
        var saleProcessor = new SaleProcessor();
        List<Sale> salesByCategory = saleProcessor.categoryFilter(retailSales, ProductCategory.ELECTRONICS);

        var csvWriter = new CsvWriter(filePath + "output/" + fileName);
        csvWriter.write(salesByCategory);

        var electronicCsvReader = new CsvReader(filePath + "output/" + fileName);
        List<Sale> electronicSales = electronicCsvReader.reader();
        electronicSales.forEach(System.out::println);

        Map<ProductCategory, Double> totalAmount = saleProcessor.sumTotalAmount(retailSales);
        System.out.println(totalAmount);

        List<Sale> bestSales = saleProcessor.top5Sales(electronicSales);
        System.out.println(bestSales);
    }
}
