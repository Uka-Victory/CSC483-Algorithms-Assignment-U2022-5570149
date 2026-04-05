package com.csc483.assignment1.search;

/**
 * Represents a product in the TechMart system.
 */
public class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int stockQuantity;

    /**
     * Creates a Product object.
     * @param productId unique product ID
     * @param productName name of the product
     * @param category product category
     * @param price product price
     * @param stockQuantity available stock quantity
     */
    public Product(int productId, String productName, String category, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Category: " + category +
               ", Price: " + price +
               ", Stock: " + stockQuantity;
    }
}
