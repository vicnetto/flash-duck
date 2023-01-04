package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AffichageCarteReponseController {

    @FXML
    private Label reponse;

    @FXML
    private Label question;

    @FXML
    private ImageView image;

    private int currentPile;

    public int getCurrentPile() {
        return currentPile;
    }

    public void setCurrentPile(int currentPile) {
        this.currentPile = currentPile;
    }

    public void iKnew(ActionEvent actionEvent) {
    }

    public void iDidntKnow(ActionEvent actionEvent) {
    }

    public void nextQuestion(ActionEvent actionEvent) {
    }
}