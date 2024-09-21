package parcial.cvdsParcialPrimerCorte.Service;
import java.util.HashMap;
import java.util.Map;
import parcial.cvdsParcialPrimerCorte.Entity.Observer;
import parcial.cvdsParcialPrimerCorte.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private HashMap<String, Product> products;
    private Observer AlertAgent;
    private Observer LogAgent;

    /**
     * Constructor of the ProductService class
     * @param AlertAgent
     * @param LogAgent
     */
    @Autowired
    public ProductService(@Qualifier("alertAgent") Observer AlertAgent, @Qualifier("logAgent") Observer LogAgent){
        products = new HashMap<>();
        this.AlertAgent = AlertAgent;
        this.LogAgent = LogAgent;
    }

    /**
     * Method to save a product
     * @param product
     * @return
     */
    public boolean saveProduct(Product product){
        products.put(product.getName(),product);
        product.addObserver(AlertAgent);
        product.addObserver(LogAgent);
        return true;
    }


    /**
     * Method to delete a product
     * @param name
     * @return
     */
    public boolean deleteProduct(String name){
        products.remove(name);
        return true;
    }

    /**
     * Method to get the products
     * @return
     */
    public HashMap<String, Product> getProducts(){
        return products;
    }


    /**
     * Method to update a product
     * @param name
     * @param quantity
     * @return
     */
    public boolean updateProduct(String name, int quantity){
        products.get(name).setStock(quantity);
        products.get(name).notifyObservers();
        return true;
    }

}