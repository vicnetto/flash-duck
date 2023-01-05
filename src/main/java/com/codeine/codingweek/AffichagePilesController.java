package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

        AfficherPiles.afficherToutesLesPiles(fcg, gridPiles, goToPile);
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

    public void importPile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile == null) {
            System.out.println("Fichier invalide.");
            return;
        }

        JsonController jsonController = new JsonController(selectedFile.getAbsolutePath());
        Pile newPile = jsonController.getPile();
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
