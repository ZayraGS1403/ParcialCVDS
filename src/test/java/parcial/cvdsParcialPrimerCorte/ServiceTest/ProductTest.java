package parcial.cvdsParcialPrimerCorte.ServiceTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parcial.cvdsParcialPrimerCorte.Entity.Observer;
import parcial.cvdsParcialPrimerCorte.Entity.Product;
import parcial.cvdsParcialPrimerCorte.Service.ProductService;

public class ProductTest {

    private ProductService productService;
    private Observer alertAgent;
    private Observer logAgent;

    @BeforeEach
    public void setUp() {
        productService = new ProductService(alertAgent, logAgent);
    }

    @Test
    void saveProductSuccessfully() {
        Product product = new Product("TestProduct", 10);
        boolean result = productService.saveProduct(product);
        assertTrue(result);
        assertEquals(1, productService.getProducts().size());
        assertTrue(productService.getProducts().containsKey("TestProduct"));
    }

    @Test
    void deleteProductSuccessfully() {
        Product product = new Product("TestProduct", 10);
        productService.saveProduct(product);
        boolean result = productService.deleteProduct("TestProduct");
        assertTrue(result);
        assertFalse(productService.getProducts().containsKey("TestProduct"));
    }

    @Test
    void updateNonExistentProduct() {
        boolean result = productService.updateProduct("NonExistentProduct", 20);
        assertFalse(result);
    }

    @Test
    void deleteNonExistentProduct() {
        boolean result = productService.deleteProduct("NonExistentProduct");
        assertFalse(result);
    }
}
