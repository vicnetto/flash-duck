package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ApprentissageMethodReponse extends ApprentissageMethod{
    public ApprentissageMethodReponse(int quantityOfQuestions, int questionNumber, Card carte, String hintShowed) {
        super(quantityOfQuestions, questionNumber, carte, hintShowed);
    }

    @Override
    public void afficher(VBox vb) {
        Label answer = (Label) vb.lookup("#reponse");
        Text hint = (Text) vb.lookup("#hint");
        Label questionNumber = (Label) vb.lookup("#question");
        Button seeAnswer = (Button) vb.lookup("#see");

        seeAnswer.setText("Voir la Question");
        questionNumber.setText(this.getQuestionNumber() + "/" + this.getQuantityOfQuestions());
        answer.setText(this.getCarte().getReponse());
        hint.setText(this.getHintShowed());
    }
}
