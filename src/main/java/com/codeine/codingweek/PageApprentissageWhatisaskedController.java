package com.codeine.codingweek;

import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageMethod;
import com.codeine.codingweek.model.FlashCardGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PageApprentissageWhatisaskedController implements Initializable {

    public Label label;
    public Text hint;
    public VBox laVb;
    public Label compteurLabel;
    private FlashCardGame fcg;
    private int temps;
    private Timeline tm;

    public PageApprentissageWhatisaskedController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    public void compteurTemps() {
        tm = new Timeline();
        tm.setCycleCount(Timeline.INDEFINITE);
        temps = 10;
        this.compteurLabel.setText(String.valueOf(temps));
        KeyFrame kf = new KeyFrame(Duration.seconds(1), event -> {
            temps--;
            compteurLabel.setText(String.valueOf(temps));
            if (temps<=0){
                tm.stop();
                try {
                    ViewSwitcher.switchTo(View.APPRENTISSAGE_CREATOR_REPONSE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tm.getKeyFrames().add(kf);
        tm.playFromStart();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ApprentissageMethod am = this.fcg.getCurrentApprentissageList().get(this.fcg.getCurrentIndexApprentissageList());
        am.afficher(this.laVb);
        this.compteurTemps();

    }

    public void goToReponse() throws IOException {
        tm.stop();
        ViewSwitcher.switchTo(View.APPRENTISSAGE_CREATOR_REPONSE);
    }
}
