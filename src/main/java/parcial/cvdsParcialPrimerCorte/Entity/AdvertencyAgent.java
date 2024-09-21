package parcial.cvdsParcialPrimerCorte.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertencyAgent implements Observer{

    /**
     * Method to notify that the stock of a product is low
     * @param product
     */
    public void update(Product product){
        if (product.getQuantity() <= 5){
            System.out.println("ADVERTENCY!! " + product.getName() + " is  low  " + product.getQuantity() + "units.");
        }
    }
}