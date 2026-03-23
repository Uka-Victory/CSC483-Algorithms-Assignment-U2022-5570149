private static final int RUNS = 5;
private static final int MAX_RANDOM_VALUE = 100000;
private static final int DUPLICATE_RANGE = 10;

import java.util.Random;

/**
 * Benchmarks sorting algorithms using different dataset types.
 * This class compares Insertion Sort, Merge Sort, and Quick Sort
 * using execution time, comparisons, and swaps/assignments.
 */
public class SortingBenchmark {

    static Random random = new Random();

    /**
     * Runs the sorting benchmark for the selected input sizes and dataset types.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[] sizes = {100000};

        for (int size : sizes) {
            System.out.println("==================================================");
            System.out.println("INPUT SIZE: " + size);
            System.out.println("==================================================");

            System.out.println("RANDOM DATA:");
            testAllAlgorithms(generateRandom(size));

            System.out.println("\nSORTED DATA:");
            testAllAlgorithms(generateSorted(size));

            System.out.println("\nREVERSE SORTED DATA:");
            testAllAlgorithms(generateReverseSorted(size));

            System.out.println("\nNEARLY SORTED DATA:");
            testAllAlgorithms(generateNearlySorted(size));

            System.out.println("\nMANY DUPLICATES DATA:");
            testAllAlgorithms(generateManyDuplicates(size));

            System.out.println();
        }
    }

    /**
     * Tests all sorting algorithms on the given dataset.
     *
     * @param data input array
     */
    public static void testAllAlgorithms(int[] data) {
        testInsertionSort(data.clone());
        testMergeSort(data.clone());
        testQuickSort(data.clone());
    }

    /**
     * Tests Insertion Sort and prints average execution time,
     * comparisons, and swaps/assignments.
     *
     * @param data input array
     */
    public static void testInsertionSort(int[] data) {
        long totalTime = 0;
        long totalComparisons = 0;
        long totalSwaps = 0;

        for (int i = 0; i < 5; i++) {
            int[] copy = data.clone();
            SortStats stats = new SortStats();

            long start = System.nanoTime();
            insertionSort(copy, stats);
            long end = System.nanoTime();

            totalTime += (end - start);
            totalComparisons += stats.comparisons;
            totalSwaps += stats.swaps;
        }

        double avgTime = totalTime / 5.0 / 1_000_000.0;
        long avgComparisons = totalComparisons / 5;
        long avgSwaps = totalSwaps / 5;

        System.out.println("Insertion Sort:");
        System.out.println("Average Time: " + avgTime + " ms");
        System.out.println("Average Comparisons: " + avgComparisons);
        System.out.println("Average Swaps/Assignments: " + avgSwaps);
    }

    /**
     * Tests Merge Sort and prints average execution time,
     * comparisons, and swaps/assignments.
     *
     * @param data input array
     */
    public static void testMergeSort(int[] data) {
        long totalTime = 0;
        long totalComparisons = 0;
        long totalSwaps = 0;

        for (int i = 0; i < 5; i++) {
            int[] copy = data.clone();
            SortStats stats = new SortStats();

            long start = System.nanoTime();
            mergeSort(copy, 0, copy.length - 1, stats);
            long end = System.nanoTime();

            totalTime += (end - start);
            totalComparisons += stats.comparisons;
            totalSwaps += stats.swaps;
        }

        double avgTime = totalTime / 5.0 / 1_000_000.0;
        long avgComparisons = totalComparisons / 5;
        long avgSwaps = totalSwaps / 5;

        System.out.println("Merge Sort:");
        System.out.println("Average Time: " + avgTime + " ms");
        System.out.println("Average Comparisons: " + avgComparisons);
        System.out.println("Average Swaps/Assignments: " + avgSwaps);
    }

    /**
     * Tests Quick Sort and prints average execution time,
     * comparisons, and swaps/assignments.
     *
     * @param data input array
     */
    public static void testQuickSort(int[] data) {
        long totalTime = 0;
        long totalComparisons = 0;
        long totalSwaps = 0;

        for (int i = 0; i < 5; i++) {
            int[] copy = data.clone();
            SortStats stats = new SortStats();

            long start = System.nanoTime();
            quickSort(copy, 0, copy.length - 1, stats);
            long end = System.nanoTime();

            totalTime += (end - start);
            totalComparisons += stats.comparisons;
            totalSwaps += stats.swaps;
        }

        double avgTime = totalTime / 5.0 / 1_000_000.0;
        long avgComparisons = totalComparisons / 5;
        long avgSwaps = totalSwaps / 5;

        System.out.println("Quick Sort:");
        System.out.println("Average Time: " + avgTime + " ms");
        System.out.println("Average Comparisons: " + avgComparisons);
        System.out.println("Average Swaps/Assignments: " + avgSwaps);
    }

    /**
     * Generates a random dataset.
     *
     * @param size array size
     * @return random array
     */
    public static int[] generateRandom(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    /**
     * Generates a sorted dataset in ascending order.
     *
     * @param size array size
     * @return sorted array
     */
    public static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * Generates a reverse sorted dataset in descending order.
     *
     * @param size array size
     * @return reverse sorted array
     */
    public static int[] generateReverseSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    /**
     * Generates a nearly sorted dataset.
     * About 90% remains sorted and 10% is randomized.
     *
     * @param size array size
     * @return nearly sorted array
     */
    public static int[] generateNearlySorted(int size) {
        int[] arr = generateSorted(size);

        // Use 10% swaps to make the data nearly sorted
        int swaps = size / 10;
        for (int i = 0; i < swaps; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);

            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }

        return arr;
    }

    /**
     * Generates a dataset with many duplicate values.
     * Only 10 distinct values are used.
     *
     * @param size array size
     * @return duplicate-heavy array
     */
    public static int[] generateManyDuplicates(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }

    /**
     * Performs Insertion Sort while counting comparisons and swaps/assignments.
     *
     * @param arr array to sort
     * @param stats statistics object
     */
    public static void insertionSort(int[] arr, SortStats stats) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            stats.swaps++;

            int j = i - 1;

            while (j >= 0) {
                stats.comparisons++;

                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    stats.swaps++;
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;
            stats.swaps++;
        }
    }

    /**
     * Performs Merge Sort while counting comparisons and swaps/assignments.
     *
     * @param arr array to sort
     * @param left left index
     * @param right right index
     * @param stats statistics object
     */
    public static void mergeSort(int[] arr, int left, int right, SortStats stats) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid, stats);
            mergeSort(arr, mid + 1, right, stats);

            merge(arr, left, mid, right, stats);
        }
    }

    /**
     * Merges two sorted halves of an array.
     *
     * @param arr array
     * @param left left index
     * @param mid middle index
     * @param right right index
     * @param stats statistics object
     */
    public static void merge(int[] arr, int left, int mid, int right, SortStats stats) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
            stats.swaps++;
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
            stats.swaps++;
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            stats.comparisons++;

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                stats.swaps++;
                i++;
            } else {
                arr[k] = rightArray[j];
                stats.swaps++;
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            stats.swaps++;
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            stats.swaps++;
            j++;
            k++;
        }
    }

    /**
     * Performs Quick Sort using median-of-three pivot selection.
     *
     * @param arr array to sort
     * @param low lower index
     * @param high upper index
     * @param stats statistics object
     */
    public static void quickSort(int[] arr, int low, int high, SortStats stats) {
        if (arr == null || arr.length == 0) {
            return;
        }

        while (low < high) {
            int pivotIndex = partitionMedianOfThree(arr, low, high, stats);

            // Recur on the smaller side first to reduce recursion depth
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1, stats);
                low = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, high, stats);
                high = pivotIndex - 1;
            }
        }
    }

    /**
     * Partitions the array using median-of-three pivot selection.
     *
     * @param arr array
     * @param low lower index
     * @param high upper index
     * @param stats statistics object
     * @return pivot index
     */
    public static int partitionMedianOfThree(int[] arr, int low, int high, SortStats stats) {
        int mid = low + (high - low) / 2;

        stats.comparisons++;
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid, stats);
        }

        stats.comparisons++;
        if (arr[low] > arr[high]) {
            swap(arr, low, high, stats);
        }

        stats.comparisons++;
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high, stats);
        }

        // Move median element to the end and use it as pivot
        swap(arr, mid, high, stats);
        int pivot = arr[high];
        stats.swaps++;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            stats.comparisons++;

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j, stats);
            }
        }

        swap(arr, i + 1, high, stats);
        return i + 1;
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr array
     * @param i first index
     * @param j second index
     * @param stats statistics object
     */
    public static void swap(int[] arr, int i, int j, SortStats stats) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            stats.swaps += 3;
        }
    }
}