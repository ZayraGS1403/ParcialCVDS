package parcial.cvdsParcialPrimerCorte.EntityTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parcial.cvdsParcialPrimerCorte.Entity.Observer;
import parcial.cvdsParcialPrimerCorte.Entity.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTester {
    private Product product;
    private Observer observer;

    @BeforeEach
    public void setUp() {
        product = new Product("TestProduct", 10);
        product.addObserver(observer);
    }
    @Test
    void setPriceSuccessfully() {
        product.setPrice(100.0);
        assertEquals(100.0, product.getPrice());
    }

    @Test
    void setCategorySuccessfully() {
        product.setCategory("Electronics");
        assertEquals("Electronics", product.getCategory());
    }
    @Test
    void setStockSuccessfully() {
        product.setStock(50);
        assertEquals(50, product.getStock());
    }
}
