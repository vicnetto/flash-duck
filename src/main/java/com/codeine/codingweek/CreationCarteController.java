package com.codeine.codingweek;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class CreationCarteController implements Initializable {

    @FXML
    private TextArea textarea_q ;

    @FXML
    private TextArea textarea_r ;

    @FXML
    private Button button_annuler ;

    @FXML
    private Button button_valider ;

    private FlashCardGame fcg;

    public CreationCarteController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

}
