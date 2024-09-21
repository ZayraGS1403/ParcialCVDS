package parcial.cvdsParcialPrimerCorte.Entity;
import org.springframework.stereotype.Component;


@Component
public class LogAgent implements Observer{

    //metodo para notificar que un producto ha sido actualizado

    /**
     * Method to notify that a product has been updated
     * @param product
     */
    public void update(Product product){
        System.out.println(product.getName() + " -> " + product.getQuantity() + " stock units");
    }
}

