package parcial.cvdsParcialPrimerCorte.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parcial.cvdsParcialPrimerCorte.Service.StockService;
import parcial.cvdsParcialPrimerCorte.Entity.Product;


@RestController
@RequestMapping("/stock")
public class StockController {
    StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    /**
     * Method to return a hashmap with the products
     * @param product
     */
    @DeleteMapping("deleteProduct")
    public void deleteProduct(@RequestBody Product product){
        stockService.deleteProduct(product);
    }


    /**
     * Method to update the stock of a product
     * @param name
     * @param quantity
     */
    @PutMapping("updateStock")
    public void updateStock(@RequestParam String name, @RequestParam int quantity) {
        stockService.updateStock(name, quantity);
    }

    /**
     * Method to add a product to the stock
     * @param product
     */
    @PostMapping("addProduct")
    public void addProduct(@RequestBody Product product) {
        stockService.addProduct(product);
    }


}