
import java.util.Scanner;

/**
 * Classe qui définit la Vue en ligne de commande. Les méthodes servent
 * simplement à afficher de façon jolie la valeur du compteur.
 */
public class VueConsole implements Vue {

    private Controleur controleur;

    public static void main(String[] args) {
        VueConsole vue = new VueConsole();
        vue.demarrer();
    }

    public void demarrer() {
        // --- Création du contrôleur ---
        controleur = new Controleur(this);

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            String line = s.nextLine();
            controleur.ajouter(line);
        }
    }

    @Override
    public void updateOutput(String text) {
        viderConsole();

        for (int i = 0; i < text.length() + 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println("| " + text + " |");

        for (int i = 0; i < text.length() + 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("Ajouter: ");
    }

    private void viderConsole() {
        for (int clear = 0; clear < 80; clear++) {
            System.out.println();
        }
    }
}
