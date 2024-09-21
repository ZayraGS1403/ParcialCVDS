package parcial.cvdsParcialPrimerCorte.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Product implements Subject {
    private String name;
    private int quantity;
    private List<Observer> observers;
    private double price;
    private int stock;
    private String category;

    /**
     * Contructor of the class
     * @param name
     * @param quantity
     *
     */
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.observers = new ArrayList<>();
    }

    /**
     * Notify the observers
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Add an observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove an observer
     * @param
     */
    public void removeObserver(Observer o) {
        observers.remove(o);
    }


    /**
     * Get the price of the product
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the product
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the quantity of the product
     * @return
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Get the category of the product
     * @return
     */
    public String getCategory() {
        return category;
    }


    /**
     * Set the quantity of the product
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyObservers();
    }


    /**
     * Get the name of the product
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product
     * @return
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Get the stock of the product
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     * Set the category of the product
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

}