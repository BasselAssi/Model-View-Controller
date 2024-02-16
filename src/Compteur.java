
/**
 * Modèle de l'application. Cette classe permet de calculer le total
 * des nombres entrés.
 */
public class Compteur {

    private double total = 0;

    public void ajouter(double nombre) {
        total += nombre;
    }

    public double getValeur() {
        return total;
    }
}
