package com.codeine.codingweek;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PageApprentissageAccueil implements Initializable {

    private FlashCardGame fcg;

    public PageApprentissageAccueil(FlashCardGame fcg) {
        this.fcg = fcg ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}