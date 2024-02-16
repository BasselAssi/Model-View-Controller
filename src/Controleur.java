
/**
 * Le contrôleur est en charge de demander au modèle de faire les
 * modifications appropriées lorsque nécessaire et peut demander à la
 * vue de se mettre à jour lorsque le modèle est modifié.
 */
public class Controleur {

    // Classe qui sert uniquement à l'affichage
    private Vue vue;

    // Le modèle de l'application est simplement une instance de Compteur
    private CompteurMoyenne modele;

    Controleur(Vue vue) {
        this.vue = vue;
        this.modele = new CompteurMoyenne();

        vue.updateOutput("" + modele.getValeur());
    }

    public void ajouter(String text) {
        try {
            double nombre = Double.parseDouble(text);

            modele.ajouter(nombre);

            vue.updateOutput("" + modele.getValeur());

        } catch (NumberFormatException exception) {
            vue.updateOutput("Erreur");
            modele = new CompteurMoyenne();
        }
    }
}
