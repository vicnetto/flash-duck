package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ApprentissageMethodReponse extends ApprentissageMethod{
    public ApprentissageMethodReponse(Card carte, String hintShowed) {
        super(carte, hintShowed);
    }

    @Override
    public void afficher(VBox vb) {
        Button asked = (Button) vb.lookup("#asked");
        Text hint = (Text) vb.lookup("#hint");

        asked.setText(this.getCarte().getReponse());
        hint.setText(this.getHintShowed());
    }
}
