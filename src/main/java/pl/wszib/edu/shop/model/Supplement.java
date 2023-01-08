package pl.wszib.edu.shop.model;

import java.time.LocalDate;

public sealed class Supplement permits Creatine, Preworkout, Protein{
    private String brand;
    private LocalDate expireDate;
    private double price;
    private int weight;
    private String productCode;
    private int inStock;

    public Supplement() {
    }

    public Supplement(String brand, LocalDate expireDate, double price, int weight, String productCode, int inStock) {
        this.brand = brand;
        this.expireDate = expireDate;
        this.price = price;
        this.weight = weight;
        this.productCode = productCode;
        this.inStock = inStock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("brand: ")
                .append(this.brand)
                .append(", weight: ")
                .append(this.weight)
                .append("g, price: ")
                .append(this.price)
                .append(", expire date: ")
                .append(this.expireDate)
                .append(", available in stock: ")
                .append(this.inStock)
                .append(", product code: ")
                .append(this.productCode)
                .toString();
    }
}
