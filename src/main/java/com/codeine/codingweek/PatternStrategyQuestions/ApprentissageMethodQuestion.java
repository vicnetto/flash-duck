package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ApprentissageMethodQuestion extends ApprentissageMethod {
    public ApprentissageMethodQuestion(Card carte, String hintShowed) {
        super(carte, hintShowed);
    }

    @Override
    public void afficher(VBox vb) {
        Button asked = (Button) vb.lookup("#asked");
        Text hint = (Text) vb.lookup("#hint");

        asked.setText(this.getCarte().getQuestion());
        hint.setText(this.getHintShowed());
    }
}
