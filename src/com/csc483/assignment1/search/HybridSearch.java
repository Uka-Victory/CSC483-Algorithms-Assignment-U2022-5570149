package com.csc483.assignment1.search;

import java.util.HashMap;

/**
 * Hybrid search system that combines binary search by ID
 * and HashMap indexing for fast name search.
 */
public class HybridSearch {
    private Product[] products;
    private HashMap<String, Product> nameIndex;
    private int size;

    /**
     * Creates a HybridSearch object with a given capacity.
     * @param capacity maximum number of products
     */
    public HybridSearch(int capacity) {
        products = new Product[capacity];
        nameIndex = new HashMap<>();
        size = 0;
    }

    /**
     * Adds a product while keeping the array sorted by product ID.
     * @param newProduct product to add
     */
    public void addProduct(Product newProduct) {
        int i = size - 1;

        while (i >= 0 && products[i].getProductId() > newProduct.getProductId()) {
            products[i + 1] = products[i];
            i--;
        }

        products[i + 1] = newProduct;
        nameIndex.put(newProduct.getProductName().toLowerCase(), newProduct);
        size++;
    }

    /**
     * Searches for a product by ID using binary search.
     * @param targetId target product ID
     * @return matching product or null
     */
    public Product searchById(int targetId) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (products[middle].getProductId() == targetId) {
                return products[middle];
            } else if (products[middle].getProductId() < targetId) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }

    /**
     * Searches for a product by name using HashMap.
     * @param targetName target product name
     * @return matching product or null
     */
    public Product searchByName(String targetName) {
        if (targetName == null) {
            return null;
        }
        return nameIndex.get(targetName.toLowerCase());
    }
}
