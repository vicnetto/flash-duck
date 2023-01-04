package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;
import javafx.scene.layout.VBox;

public abstract class ApprentissageMethod {

    private Card carte;

    private String hintShowed;

    public ApprentissageMethod(Card carte, String hintShowed) {
        this.carte = carte;
        this.hintShowed = hintShowed;
    }

    public String getHintShowed() {
        return hintShowed;
    }
    public void setHintShowed(String hintShowed) {
        this.hintShowed = hintShowed;
    }

    public Card getCarte() {
        return carte;
    }

    public void setCarte(Card carte) {
        this.carte = carte;
    }

    public abstract void afficher(VBox vb);
}
