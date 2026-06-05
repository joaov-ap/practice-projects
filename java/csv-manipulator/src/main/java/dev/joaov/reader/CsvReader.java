package main.java.dev.joaov.reader;

import main.java.dev.joaov.model.ProductCategory;
import main.java.dev.joaov.model.Sale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private File file;

    public CsvReader(String filePath) {
        this.file = new File(filePath);
    }

    public List<Sale> reader() {
        List<Sale> salesList = new ArrayList<>();

        try (var fileReader = new FileReader(file);
             var bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] saleSplitted = line.split(",");

                var sale = new Sale(
                        Long.valueOf(saleSplitted[0]),
                        LocalDate.parse(saleSplitted[1]),
                        saleSplitted[2],
                        saleSplitted[3],
                        Integer.parseInt(saleSplitted[4]),
                        ProductCategory.valueOf(saleSplitted[5].toUpperCase()),
                        Integer.parseInt(saleSplitted[6]),
                        BigDecimal.valueOf(Double.parseDouble(saleSplitted[7])),
                        BigDecimal.valueOf(Double.parseDouble(saleSplitted[8])));

                salesList.add(sale);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return salesList;
    }

    public void setFile(String filePath) {
        this.file = new File(filePath);
    }
}
