package com.codeine.codingweek;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AffichageCartesController implements Initializable {
    @FXML
    public VBox gridCartes;

    private FlashCardGame fcg;

    public AffichageCartesController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
