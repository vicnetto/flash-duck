package com.codeine.codingweek;

import java.net.URL;
import java.util.ResourceBundle;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;

import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

public class PageStatistiqueGlobalController implements Initializable {
    
    public HBox containerGraph;

    private FlashCardGame fcg;

    public PageStatistiqueGlobalController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Pile pile : fcg.getLesPiles()) {

            // Récupèration des scores pour chaque parties

            

        }

    }

}