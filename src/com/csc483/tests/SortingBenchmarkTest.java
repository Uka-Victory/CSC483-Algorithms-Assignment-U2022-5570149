package com.csc483.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.csc483.assignment2.sorting.SortStats;
import com.csc483.assignment2.sorting.SortingBenchmark;

public class SortingBenchmarkTest {

    @Test
    public void testInsertionSort() {
        int[] arr = {5, 3, 8, 1, 2};
        SortStats stats = new SortStats();

        SortingBenchmark.insertionSort(arr, stats);

        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {5, 3, 8, 1, 2};
        SortStats stats = new SortStats();

        SortingBenchmark.mergeSort(arr, 0, arr.length - 1, stats);

        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {5, 3, 8, 1, 2};
        SortStats stats = new SortStats();

        SortingBenchmark.quickSort(arr, 0, arr.length - 1, stats);

        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        SortStats stats = new SortStats();

        SortingBenchmark.insertionSort(arr, stats);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testDuplicateValues() {
        int[] arr = {4, 2, 2, 4, 1, 1};
        SortStats stats = new SortStats();

        SortingBenchmark.mergeSort(arr, 0, arr.length - 1, stats);

        assertArrayEquals(new int[]{1, 1, 2, 2, 4, 4}, arr);
    }
                                    }
