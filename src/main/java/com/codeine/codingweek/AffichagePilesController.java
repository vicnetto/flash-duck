package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    public void importPile(ActionEvent actionEvent) {


        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        System.out.println(selectedFile.getAbsolutePath());

        JsonController jsonController = new JsonController(selectedFile.getAbsolutePath());

        Pile newPile = jsonController.getPile();

        // TODO ...
    }
}
