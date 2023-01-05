package com.codeine.codingweek;


import com.codeine.codingweek.model.FlashCardGame;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;

public class PageApprentissageAccueil implements Initializable {

    @FXML
    private GridPane gridPiles;

    private FlashCardGame fcg;

    public PageApprentissageAccueil(FlashCardGame fcg) {
        this.fcg = fcg ;
    }

    public void statistiques() throws IOException {
        ViewSwitcher.swtichTo(View.STATISTIQUES);
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
        ViewSwitcher.swtichTo(View.APPRENTISSAGE_FORM_SELECT_PARAMETERS);
    }

    public void retour() throws IOException {
        ViewSwitcher.swtichTo(View.ACCUEIL);
    }

}
