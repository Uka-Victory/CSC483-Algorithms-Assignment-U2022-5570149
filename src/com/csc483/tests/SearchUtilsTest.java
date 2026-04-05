package com.csc483.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.csc483.assignment1.search.Product;
import com.csc483.assignment1.search.SearchUtils;

public class SearchUtilsTest {

    @Test
    public void testSequentialSearchByIdFound() {
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 250000.0, 5),
            new Product(102, "Phone", "Electronics", 120000.0, 10)
        };

        Product result = SearchUtils.sequentialSearchById(products, 102);
        assertNotNull(result);
        assertEquals(102, result.getProductId());
    }

    @Test
    public void testSequentialSearchByIdNotFound() {
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 250000.0, 5)
        };

        Product result = SearchUtils.sequentialSearchById(products, 999);
        assertNull(result);
    }

    @Test
    public void testBinarySearchByIdFound() {
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 250000.0, 5),
            new Product(102, "Phone", "Electronics", 120000.0, 10),
            new Product(103, "Headset", "Accessories", 15000.0, 20)
        };

        Product result = SearchUtils.binarySearchById(products, 103);
        assertNotNull(result);
        assertEquals(103, result.getProductId());
    }

    @Test
    public void testBinarySearchByIdNotFound() {
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 250000.0, 5),
            new Product(102, "Phone", "Electronics", 120000.0, 10)
        };

        Product result = SearchUtils.binarySearchById(products, 500);
        assertNull(result);
    }

    @Test
    public void testSearchByNameFound() {
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 250000.0, 5),
            new Product(102, "Phone", "Electronics", 120000.0, 10)
        };

        Product result = SearchUtils.searchByName(products, "Laptop");
        assertNotNull(result);
        assertEquals("Laptop", result.getProductName());
    }

    @Test
    public void testSearchByNameCaseInsensitive() {
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 250000.0, 5)
        };

        Product result = SearchUtils.searchByName(products, "laptop");
        assertNotNull(result);
        assertEquals("Laptop", result.getProductName());
    }

    @Test
    public void testSearchWithNullArray() {
        assertNull(SearchUtils.sequentialSearchById(null, 101));
        assertNull(SearchUtils.binarySearchById(null, 101));
        assertNull(SearchUtils.searchByName(null, "Laptop"));
    }
}
