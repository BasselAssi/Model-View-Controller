
/**
 * Modèle de l'application. Cette classe permet de calculer la moyenne
 * des nombres entrés.
 */
public class CompteurMoyenne {

    private double total = 0;
    private int nbElements = 0;

    public void ajouter(double nombre) {
        total += nombre;
        nbElements++;
    }

    public double getValeur() {
        if (nbElements == 0) {
            return 0;
        } else {
            return total / nbElements;
        }
    }
}
