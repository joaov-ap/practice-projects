package data;

import main.java.dev.joaov.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class DataGenerator {
    public static List<Product> generate() {
        return List.of(
                new Product(1L, "Notebook Pro", "Electronics", new BigDecimal("4500.00"), 10, true, List.of("performance", "trabalho", "premium")),
                new Product(2L, "Mouse Wireless", "Electronics", new BigDecimal("120.00"), 50, true, List.of("periférico", "sem fio")),
                new Product(3L, "Teclado Mecânico", "Electronics", new BigDecimal("350.00"), 30, true, List.of("periférico", "gamer", "premium")),
                new Product(4L, "Monitor 24\"", "Electronics", new BigDecimal("1200.00"), 15, true, List.of("display", "trabalho", "premium")),
                new Product(5L, "Headset Gamer", "Electronics", new BigDecimal("280.00"), 0, false, List.of("gamer", "áudio", "periférico")),
                new Product(6L, "Webcam HD", "Electronics", new BigDecimal("190.00"), 8, true, List.of("trabalho", "streaming")),
                new Product(7L, "SSD 1TB", "Electronics", new BigDecimal("400.00"), 25, false, List.of("armazenamento", "performance")),
                new Product(8L, "Camiseta Básica", "Clothing", new BigDecimal("49.90"), 100, true, List.of("casual", "básico")),
                new Product(9L, "Calça Jeans", "Clothing", new BigDecimal("189.90"), 60, true, List.of("casual", "básico")),
                new Product(10L, "Jaqueta de Couro", "Clothing", new BigDecimal("599.00"), 12, true, List.of("premium", "inverno")),
                new Product(11L, "Tênis Esportivo", "Clothing", new BigDecimal("320.00"), 40, true, List.of("esporte", "casual")),
                new Product(12L, "Boné Aba Reta", "Clothing", new BigDecimal("59.90"), 80, false, List.of("casual", "acessório")),
                new Product(13L, "Meia Kit 3 pares", "Clothing", new BigDecimal("29.90"), 200, true, List.of("básico", "acessório")),
                new Product(14L, "Arroz 5kg", "Food", new BigDecimal("28.50"), 500, true, List.of("grão", "básico")),
                new Product(15L, "Feijão 1kg", "Food", new BigDecimal("9.90"), 300, true, List.of("grão", "básico")),
                new Product(16L, "Azeite Extra Virgem", "Food", new BigDecimal("45.00"), 150, true, List.of("premium", "importado")),
                new Product(17L, "Café 500g", "Food", new BigDecimal("22.00"), 400, true, List.of("bebida", "básico")),
                new Product(18L, "Chocolate 70%", "Food", new BigDecimal("12.50"), 0, false, List.of("doce", "premium")),
                new Product(19L, "Granola 500g", "Food", new BigDecimal("18.90"), 90, true, List.of("saudável", "café da manhã")),
                new Product(20L, "Whey Protein 1kg", "Food", new BigDecimal("189.00"), 35, true, List.of("saudável", "esporte"))
        );
    }
}
