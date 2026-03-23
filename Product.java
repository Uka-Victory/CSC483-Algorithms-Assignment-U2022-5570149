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

    /**
     * Returns the product ID.
     * @return product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     * @return product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Returns the product category.
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the product price.
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the stock quantity.
     * @return stock quantity
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Returns product details as a string.
     * @return formatted product details
     */
    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Category: " + category +
               ", Price: " + price +
               ", Stock: " + stockQuantity;
    }
}