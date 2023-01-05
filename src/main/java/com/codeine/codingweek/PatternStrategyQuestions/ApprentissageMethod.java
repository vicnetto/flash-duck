package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;
import javafx.scene.layout.VBox;

public abstract class ApprentissageMethod {

    int quantityOfQuestions;

    int questionNumber;

    private Card carte;

    private String hintShowed;

    ApprentissageMethod(int quantityOfQuestions, int questionNumber, Card carte, String hintShowed) {
        this.quantityOfQuestions = quantityOfQuestions;
        this.questionNumber = questionNumber;
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

    public int getQuantityOfQuestions() {
        return quantityOfQuestions;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public abstract void afficher(VBox vb);
}
