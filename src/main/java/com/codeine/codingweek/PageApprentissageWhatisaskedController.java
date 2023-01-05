package com.codeine.codingweek;

import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageMethod;
import com.codeine.codingweek.model.FlashCardGame;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PageApprentissageWhatisaskedController implements Initializable {
    public Button asked;
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

    public void goToReponse(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.switchTo(View.APPRENTISSAGE_CREATOR_REPONSE);
    }
}
