package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ApprentissageMethodQuestion extends ApprentissageMethod {
    public ApprentissageMethodQuestion(int quantityOfQuestions, int questionNumber, Card carte, String hintShowed) {
        super(quantityOfQuestions, questionNumber, carte, hintShowed);
    }

    @Override
    public void afficher(VBox vb) {
        Label asked = (Label) vb.lookup("#asked");
        Text hint = (Text) vb.lookup("#hint");
        Label questionNumber = (Label) vb.lookup("#question");

        questionNumber.setText(this.getQuestionNumber() + "/" + this.getQuantityOfQuestions());
        asked.setText(this.getCarte().getQuestion());
        hint.setText(this.getHintShowed());
    }
}
