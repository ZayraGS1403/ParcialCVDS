package parcial.cvdsParcialPrimerCorte.Entity;
import org.springframework.stereotype.Component;


@Component
public interface Observer {
    /**
     *
     * @param product
     */
    public void update(Product product);
}
