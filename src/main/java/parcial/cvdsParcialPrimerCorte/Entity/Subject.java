package parcial.cvdsParcialPrimerCorte.Entity;

public interface Subject {
    /**
     * Add an observer
     * @param observer
     */
    public void addObserver(Observer observer);

    /**
     * Notify the observers
     */
    public void notifyObservers();

    /**
     * Remove an observer
     * @param observer
     */
    public void removeObserver(Observer observer);


}