import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Même classe que dans le programme MVC1
 */
public class VueGUI extends Application implements Vue {

    // Éléments graphiques
    private TextField input;
    private Button btn;
    private Text output;

    // Contrôleur de l'application
    private Controleur controleur;

    public static void main(String[] args) {
        VueGUI.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        Scene scene = new Scene(root, 400, 300);

        // --- Définition des composantes graphiques ---
        Text titre = new Text("Mon Super Compteur\n\n");

        input = new TextField();
        btn = new Button("Ajouter");
        output = new Text();

        root.getChildren().addAll(titre, input, btn, output);

        // --- Éléments de style (pour rendre l'affichage plus joli) ---
        titre.setFont(Font.font(22));
        root.setPadding(new Insets(50));
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.setPrefHeight(300);

        // --- Création du contrôleur ---
        controleur = new Controleur(this);

        // --- Ajoute des handlers pour les événements à gérer ---
        btn.setOnAction((event) -> {
            /* Lorsqu'un événement se produit, la vue va simplement
             * avertir le contrôleur qu'il vient de se passer quelque chose.
             *
             * La vue ne doit *pas* gérer l'événement elle-même.
             * La vue ne connaît pas le modèle
             */
            controleur.ajouter(input.getText());
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Vue JavaFX");
        primaryStage.show();
    }

    @Override
    public void updateOutput(String text) {
        output.setText(text);
    }
}
