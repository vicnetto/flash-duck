package com.codeine.codingweek;

import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageMethod;
import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class AffichageCarteReponseController implements Initializable {

    @FXML
    private Label number;

    @FXML
    private Label reponse;

    @FXML
    private Label question;

//    @FXML
//    private ImageView image;

    private FlashCardGame fcg;

    public AffichageCarteReponseController(FlashCardGame flashCardGame) {
        this.fcg = flashCardGame;
    }

    public FlashCardGame getFlashCardGame() {
        return fcg;
    }

    public void setFlashCardGame(FlashCardGame flashCardGame) {
        this.fcg = flashCardGame;
    }

    public void iKnew(ActionEvent actionEvent) throws IOException {
        this.fcg.setCurrentIndexApprentissageList(this.fcg.getCurrentIndexApprentissageList()+1);
        handleNextApprentissage();
    }

    public void copyCurrentApprentissageToEndList() {
        ArrayList<ApprentissageMethod> lesQuestionsPosees = this.fcg.getCurrentApprentissageList();
        ApprentissageMethod currentQuestion = lesQuestionsPosees.get(this.fcg.getCurrentIndexApprentissageList());
        lesQuestionsPosees.add(currentQuestion);
    }

    public void iDidntKnow(ActionEvent actionEvent) throws IOException {
        
        copyCurrentApprentissageToEndList();

        ArrayList<ApprentissageMethod> lesQuestionsPosees = this.fcg.getCurrentApprentissageList() ;
        Collections.shuffle(lesQuestionsPosees) ;

        this.fcg.setCurrentIndexApprentissageList(this.fcg.getCurrentIndexApprentissageList()+1);
        handleNextApprentissage();

    }

    public void nextQuestion(ActionEvent actionEvent) throws IOException {
        this.fcg.setCurrentIndexApprentissageList(this.fcg.getCurrentIndexApprentissageList()+1);
        handleNextApprentissage();
    }

    public void handleNextApprentissage() throws IOException {
        if (this.fcg.getCurrentIndexApprentissageList() < this.fcg.getCurrentApprentissageList().size()) {
            ViewSwitcher.switchTo(View.APPRENTISSAGE_WHAT_IS_ASKED);
        }
        else {
            Pile pile = this.fcg.getLesPiles().get(this.fcg.getCurrentPile());
            Float div = (float) pile.getCards().size()/this.fcg.getCurrentIndexApprentissageList();
            pile.addScore((float) 100.0*(div));
            ViewSwitcher.switchTo(View.FIN_PARTIE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApprentissageMethod am = this.fcg.getCurrentApprentissageList().get(this.fcg.getCurrentIndexApprentissageList());
        Card carte = am.getCarte();
        this.number.setText(am.getQuestionNumber() + "/" + am.getQuantityOfQuestions());
        this.reponse.setText(carte.getReponse());
        this.question.setText(carte.getQuestion());
    }
}