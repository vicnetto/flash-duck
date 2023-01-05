package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PageStatistiquePileController implements Initializable {
    public Label nomPile;
    public HBox containerGraph;

    private FlashCardGame fcg;

    public PageStatistiquePileController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pile currentPile = this.fcg.getPileCurrentPile();
        this.nomPile.setText(currentPile.getName());
        for (float score : currentPile.getScores()) {
            this.containerGraph.getChildren().add(new Label(String.valueOf(score)));
        }
    }
}
