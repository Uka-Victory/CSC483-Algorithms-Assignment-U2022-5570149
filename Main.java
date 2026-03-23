import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Main class for testing Question 1 search algorithms.
 * It generates product data, compares sequential and binary search,
 * and demonstrates the hybrid search approach.
 */
public class Main {

    /**
     * Runs the search performance tests and hybrid search demo.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Product[] products = generateProducts(100000);

        // Keep a copy of the unsorted array for sequential search
        Product[] sequentialProducts = Arrays.copyOf(products, products.length);

        int sequentialBestId = sequentialProducts[0].getProductId();
        int sequentialAverageId = sequentialProducts[sequentialProducts.length / 2].getProductId();
        int sequentialWorstId = -1;

        long sequentialBestTime = measureSequentialSearch(sequentialProducts, sequentialBestId);
        long sequentialAverageTime = measureSequentialSearch(sequentialProducts, sequentialAverageId);
        long sequentialWorstTime = measureSequentialSearch(sequentialProducts, sequentialWorstId);

        // Sort products before binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        int binaryBestId = products[products.length / 2].getProductId();
        int binaryAverageId = products[products.length / 3].getProductId();
        int binaryWorstId = -1;

        long binaryBestTime = measureBinarySearch(products, binaryBestId);
        long binaryAverageTime = measureBinarySearch(products, binaryAverageId);
        long binaryWorstTime = measureBinarySearch(products, binaryWorstId);

        System.out.println("================================================================");
        System.out.println("TECHMART SEARCH PERFORMANCE ANALYSIS (n = 100,000 products)");
        System.out.println("================================================================");
        System.out.println();

        System.out.println("SEQUENTIAL SEARCH:");
        System.out.println("Best Case (ID found at position 0): " + nanoToMilli(sequentialBestTime) + " ms");
        System.out.println("Average Case (random ID): " + nanoToMilli(sequentialAverageTime) + " ms");
        System.out.println("Worst Case (ID not found): " + nanoToMilli(sequentialWorstTime) + " ms");
        System.out.println();

        System.out.println("BINARY SEARCH:");
        System.out.println("Best Case (ID at middle): " + nanoToMilli(binaryBestTime) + " ms");
        System.out.println("Average Case (random ID): " + nanoToMilli(binaryAverageTime) + " ms");
        System.out.println("Worst Case (ID not found): " + nanoToMilli(binaryWorstTime) + " ms");
        System.out.println();

        double improvement = (double) sequentialAverageTime / binaryAverageTime;
        System.out.println("PERFORMANCE IMPROVEMENT: Binary search is ~" + String.format("%.2f", improvement) + "x faster on average");
        System.out.println("================================================================");
        System.out.println();

        // Demonstrate hybrid search
        HybridSearch hybrid = new HybridSearch(10);
        hybrid.addProduct(new Product(103, "Headset", "Accessories", 15000.0, 20));
        hybrid.addProduct(new Product(101, "Laptop", "Electronics", 250000.0, 5));
        hybrid.addProduct(new Product(102, "Phone", "Electronics", 120000.0, 10));

        Product byId = hybrid.searchById(102);
        Product byName = hybrid.searchByName("Laptop");

        System.out.println("HYBRID SEARCH TEST:");
        System.out.println("Search by ID: " + byId);
        System.out.println("Search by Name: " + byName);
    }

    /**
     * Generates an array of random Product objects.
     *
     * @param size number of products to generate
     * @return array of generated products
     */
    public static Product[] generateProducts(int size) {
        Product[] products = new Product[size];
        Random random = new Random();

        String[] names = {"Laptop", "Phone", "Headset", "Mouse", "Keyboard", "Tablet", "Monitor", "Speaker"};
        String[] categories = {"Electronics", "Accessories", "Computing", "Mobile"};

        for (int i = 0; i < size; i++) {
            int productId = random.nextInt(200000) + 1;
            String productName = names[random.nextInt(names.length)] + "_" + (i + 1);
            String category = categories[random.nextInt(categories.length)];
            double price = 5000 + random.nextInt(500000);
            int stockQuantity = random.nextInt(100) + 1;

            products[i] = new Product(productId, productName, category, price, stockQuantity);
        }

        return products;
    }

    /**
     * Measures the runtime of sequential search.
     *
     * @param products array of products
     * @param targetId target product ID
     * @return runtime in nanoseconds
     */
    public static long measureSequentialSearch(Product[] products, int targetId) {
        long startTime = System.nanoTime();
        SearchUtils.sequentialSearchById(products, targetId);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Measures the runtime of binary search.
     *
     * @param products sorted array of products
     * @param targetId target product ID
     * @return runtime in nanoseconds
     */
    public static long measureBinarySearch(Product[] products, int targetId) {
        long startTime = System.nanoTime();
        SearchUtils.binarySearchById(products, targetId);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Converts nanoseconds to milliseconds.
     *
     * @param nanoseconds time in nanoseconds
     * @return time in milliseconds
     */
    public static double nanoToMilli(long nanoseconds) {
        return nanoseconds / 1_000_000.0;
    }
}