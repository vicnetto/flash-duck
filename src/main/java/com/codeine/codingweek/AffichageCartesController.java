package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
        int i = 0;
        for (Card carte : this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).getCards()) {
            VBox vb = new VBox();
            Label question = new Label(carte.getQuestion());
            Label reponse = new Label(carte.getReponse());
            vb.getChildren().add(question);
            vb.getChildren().add(reponse);
            vb.setPadding(new Insets(10));
            vb.setStyle("-fx-border-color: black; -fx-border-radius: 5; -fx-margin-bottom: 20");
            Button bt = new Button("supprimer");
            int copieI = i;
            bt.setOnMouseClicked((e) -> {supprimerCarte(copieI);});
            vb.getChildren().add(bt);
            this.gridCartes.getChildren().add(vb);
            i++;
        }
    }

    public void goToFormCarte(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.swtichTo(View.FORM_CARTE);
    }

    public void supprimerCarte(int i) {
        this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).deleteCarteByIndex(i);
        this.gridCartes.getChildren().remove(this.gridCartes.getChildren().get(i));
        for (int j = 0; j < this.gridCartes.getChildren().size(); j++) {
            VBox vb = (VBox) this.gridCartes.getChildren().get(j);
            Button bt = (Button) vb.getChildren().get(2);
            int copieJ = j;
            bt.setOnMouseClicked((e) -> {supprimerCarte(copieJ);});
        }
    }
}
