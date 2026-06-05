package main.java.dev.joaov.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sale {
    private Long id;
    private LocalDate date;
    private String customerId;
    private String gender;
    private int age;
    private ProductCategory productCategory;
    private int quantity;
    private BigDecimal pricePerUnit;
    private BigDecimal totalAmount;

    public Sale() {
    }

    public Sale(Long id, LocalDate date, String customerId, String gender, int age, ProductCategory productCategory, int quantity, BigDecimal pricePerUnit, BigDecimal totalAmount) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.gender = gender;
        this.age = age;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "%d,%s,%s,%s,%d,%s,%d,%s,%s"
                .formatted(
                        id, date, customerId, gender, age, productCategory.name(), quantity, pricePerUnit, totalAmount
                );
    }
}
