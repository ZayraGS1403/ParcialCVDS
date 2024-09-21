package parcial.cvdsParcialPrimerCorte.ServiceTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parcial.cvdsParcialPrimerCorte.Entity.Observer;
import parcial.cvdsParcialPrimerCorte.Entity.Product;
import parcial.cvdsParcialPrimerCorte.Service.StockService;

public class StockTest {

    private StockService stockService;
    private Observer advertencyAgent;
    private Observer logAgent;
    @BeforeEach
    public void setUp() {
        stockService = new StockService(advertencyAgent, logAgent);
    }

    @Test
    void addProductSuccessfully() {
        Product product = new Product("TestProduct", 10);
        stockService.addProduct(product);
        assertEquals(1, stockService.getProducts().size());
        assertTrue(stockService.getProducts().containsKey("TestProduct"));
    }

    @Test
    void addNullProduct() {
        stockService.addProduct(null);
        assertEquals(0, stockService.getProducts().size());
    }

    @Test
    void updateStockSuccessfully() {
        Product product = new Product("TestProduct", 10);
        stockService.addProduct(product);
        boolean result = stockService.updateStock("TestProduct", 20);
        assertTrue(result);
        assertEquals(20, stockService.getProducts().get("TestProduct").getQuantity());
    }


    @Test
    void deleteProductSuccessfully() {
        Product product = new Product("TestProduct", 10);
        stockService.addProduct(product);
        stockService.deleteProduct(product);
        assertFalse(stockService.getProducts().containsKey("TestProduct"));
    }

    @Test
    void deleteNullProduct() {
        stockService.deleteProduct(null);
        assertEquals(0, stockService.getProducts().size());
    }
}
