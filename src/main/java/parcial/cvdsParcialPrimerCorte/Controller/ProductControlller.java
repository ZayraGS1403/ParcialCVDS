package parcial.cvdsParcialPrimerCorte.Controller;
import org.springframework.web.bind.annotation.*;
import parcial.cvdsParcialPrimerCorte.Service.ProductService;
import parcial.cvdsParcialPrimerCorte.Entity.Product;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping( "/parcial/product")
public class ProductControlller {

    @Autowired
    private ProductService ProductService;

    /**
     * Method to save a product
     * @param product
     * @return
     */
    @PostMapping("/save")
    public Object saveProduct(@RequestBody Product product){
        try {
            return ProductService.saveProduct(product);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Method that returns a boolean if the product has been deleted
     * @param name
     * @return
     */
    @DeleteMapping("/delete/{name}")
    public boolean deleteProduct(@PathVariable String name){
        try {
            return ProductService.deleteProduct(name);
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Method to update a product
     * @param name
     * @param stock
     * @return
     */
    @PutMapping("/update/{name}/{stock}")
    public boolean updateProduct(@PathVariable String name,@PathVariable int stock){
        try {
            return ProductService.updateProduct(name, stock);
        }catch (Exception e){
            return false;
        }
    }

}