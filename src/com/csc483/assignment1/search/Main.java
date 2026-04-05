package com.csc483.assignment1.search;

import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Main class for testing Question 1 search algorithms.
 * It generates product data, compares sequential and binary search,
 * and demonstrates the hybrid search approach.
 */
public class Main {

    private static final int DATA_SIZE = 100000;
    private static final int MAX_PRODUCT_ID = 200000;
    private static final int MAX_PRICE_RANGE = 500000;
    private static final int MIN_PRICE = 5000;
    private static final int MAX_STOCK = 100;

    /**
     * Runs the search performance tests and hybrid search demo.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Product[] products = generateProducts(DATA_SIZE);

        Product[] sequentialProducts = Arrays.copyOf(products, products.length);

        int sequentialBestId = sequentialProducts[0].getProductId();
        int sequentialAverageId = sequentialProducts[sequentialProducts.length / 2].getProductId();
        int sequentialWorstId = -1;

        long sequentialBestTime = measureSequentialSearch(sequentialProducts, sequentialBestId);
        long sequentialAverageTime = measureSequentialSearch(sequentialProducts, sequentialAverageId);
        long sequentialWorstTime = measureSequentialSearch(sequentialProducts, sequentialWorstId
