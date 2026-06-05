package main.java.dev.joaov.writer;

import main.java.dev.joaov.model.Sale;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    private File file;

    public CsvWriter(String filePath) {
        this.file = new File(filePath);
    }

    public void write(List<Sale> sales) {
        try(var fileWriter = new FileWriter(file);
            var bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("Transaction ID,Date,Customer ID,Gender,Age,Product Category,Quantity,Price per Unit,Total Amount");
            bufferedWriter.newLine();
            for (Sale sale : sales) {
                bufferedWriter.write(sale.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
