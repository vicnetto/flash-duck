package com.codeine.codingweek;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AccueilController implements Initializable {

    @FXML
    private Button button_creation ;

    @FXML
    private Button button_apprentissage ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void creation() throws IOException {
        ViewSwitcher.swtichTo(View.PILE_CREATION) ;
    }

    @FXML
    public void apprentissage() throws IOException {
        ViewSwitcher.swtichTo(View.APPRENTISSAGE_ACCUEIL) ;
    }

}