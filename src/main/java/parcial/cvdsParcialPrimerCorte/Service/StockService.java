package parcial.cvdsParcialPrimerCorte.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.cvdsParcialPrimerCorte.Entity.Observer;
import parcial.cvdsParcialPrimerCorte.Entity.Product;

import java.util.HashMap;

@Service
public class StockService {
    HashMap<String, Product> products;
    Observer advertencyAgent;
    Observer logAgent;

    /** Constructor of the StockService class
     * @param advertencyAgent
     * @param logAgent
     */
    @Autowired
    public StockService(Observer advertencyAgent, Observer logAgent) {
        this.advertencyAgent = advertencyAgent;
        this.logAgent = logAgent;
        products = new HashMap<>();
    }

    /**
     * Method to add a product to the stock
     * @param product
     */
    public void addProduct(Product product) {
        if (product != null) {
            products.put(product.getName(), product);
            product.addObserver(advertencyAgent);
            product.addObserver(logAgent);
        }
    }

    /**
     * Method to delete a product
     * @param product
     */
    public void deleteProduct(Product product) {
        if (product != null) {
            products.remove(product.getName());
        }
    }

    /**
     * Method to update the stock of a product
     * @param nameProduct
     * @param quantity
     * @return
     */
    public boolean updateStock(String nameProduct, int quantity) {
        if (nameProduct != null && quantity > 0) {
            Product product = products.get(nameProduct);
            if (product != null) {
                product.setQuantity(quantity);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Method to return a hashmap with the products
     * @return
     */
    public HashMap<String, Product> getProducts() {
        return products;
    }


}