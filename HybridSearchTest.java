import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HybridSearchTest {

    @Test
    public void testAddProductAndSearchById() {
        HybridSearch hybrid = new HybridSearch(10);

        hybrid.addProduct(new Product(103, "Headset", "Accessories", 15000.0, 20));
        hybrid.addProduct(new Product(101, "Laptop", "Electronics", 250000.0, 5));
        hybrid.addProduct(new Product(102, "Phone", "Electronics", 120000.0, 10));

        Product result = hybrid.searchById(102);

        assertNotNull(result);
        assertEquals(102, result.getProductId());
    }

    @Test
    public void testSearchByName() {
        HybridSearch hybrid = new HybridSearch(10);

        hybrid.addProduct(new Product(101, "Laptop", "Electronics", 250000.0, 5));

        Product result = hybrid.searchByName("Laptop");

        assertNotNull(result);
        assertEquals("Laptop", result.getProductName());
    }

    @Test
    public void testSearchByNameNotFound() {
        HybridSearch hybrid = new HybridSearch(10);

        hybrid.addProduct(new Product(101, "Laptop", "Electronics", 250000.0, 5));

        Product result = hybrid.searchByName("Phone");

        assertNull(result);
    }

    @Test
    public void testSearchByNameNull() {
        HybridSearch hybrid = new HybridSearch(10);
        assertNull(hybrid.searchByName(null));
    }
}