package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PageApprentissageWhatisaskedController implements Initializable {
    public Text asked;
    public Text hint;
    public VBox laVb;
    private FlashCardGame fcg;

    public PageApprentissageWhatisaskedController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApprentissageMethod am = this.fcg.getCurrentApprentissageList().get(this.fcg.getCurrentIndexApprentissageList());
        am.afficher(this.laVb);
    }

    public void goToReponse(ActionEvent actionEvent) {
        // TODO
    }
}
