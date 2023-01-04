package com.codeine.codingweek;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;

public class PageApprentissageAccueil implements Initializable {

    @FXML
    private VBox gridPiles;

    private FlashCardGame fcg;

    public PageApprentissageAccueil(FlashCardGame fcg) {
        this.fcg = fcg ;
    }

    public void statistiques(ActionEvent actionEvent) throws IOException {
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
        ViewSwitcher.swtichTo(View.ACCUEIL);
    }

}
