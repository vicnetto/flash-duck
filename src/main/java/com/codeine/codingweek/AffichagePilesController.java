package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;

public class AffichagePilesController implements Initializable {

    @FXML
    public GridPane gridPiles;

    private FlashCardGame fcg;

    public AffichagePilesController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IntConsumer goToPile = integer -> {
            try {
                goToPile(integer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        try {
            AfficherPiles.afficherToutesLesPiles(fcg, gridPiles, goToPile);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToPile(int i) throws IOException {
        this.fcg.setCurrentPile(i);
        ViewSwitcher.switchTo(View.CARTE_CREATION);
    }

    public void goToFormCreationPile() throws IOException {
        ViewSwitcher.switchTo(View.FORM_PILE);
    }

    public void retour() throws  IOException {
        ViewSwitcher.switchTo(View.ACCUEIL);
    }

    public void importPile() throws ClassNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(fcg.getLAST_FOLDER()));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile == null) {
            System.out.println("Fichier invalide.");
            return;
        }

        fcg.setLAST_FOLDER(selectedFile.getParent());
        JsonController jsonController = new JsonController(selectedFile.getAbsolutePath());
        Pile newPile = jsonController.getPile();

        if (newPile.getName() == null || newPile.getCards() == null || newPile.getCategory() == null) {
            System.out.println("Fichier invalide.");
            return;
        }

        fcg.addPile(newPile);

        IntConsumer goToPile = integer -> {
            try {
                goToPile(integer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        gridPiles.getChildren().clear();
        AfficherPiles.afficherToutesLesPiles(fcg, gridPiles, goToPile);
    }
}
