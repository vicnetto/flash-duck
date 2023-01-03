package com.codeine.codingweek;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;

public class AffichagePilesController implements Initializable {

    @FXML
    public VBox gridPiles;

    private FlashCardGame fcg;

    public AffichagePilesController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < this.fcg.getLesPiles().size(); i++) {
            VBox vb = new VBox();
            Label nom = new Label(this.fcg.getLesPiles().get(i).getName());
            vb.getChildren().add(nom);
            vb.setPadding(new Insets(10));
            vb.setStyle("-fx-border-color: black; -fx-border-radius: 5; -fx-margin-bottom: 20;");
            this.gridPiles.getChildren().add(vb);
        }
    }


    public void goToFormCreationPile(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.swtichTo(View.FORM_PILE);
    }
}
