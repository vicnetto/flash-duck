package com.codeine.codingweek;

import java.util.ArrayList;

public class ApprentissageCreatorQuestion extends ApprentissageCreator{

    public ApprentissageCreatorQuestion(FlashCardGame fcg) {
        super(fcg);
    }

    @Override
    public ArrayList<ApprentissageMethod> createApprentissage() {
        ArrayList<ApprentissageMethod> lesQuestionsPosees = new ArrayList<ApprentissageMethod>();
        for (Card carte : this.getFcg().getLesPiles().get(this.getFcg().getCurrentPile()).getCards()) {
            lesQuestionsPosees.add(new ApprentissageMethodQuestion(carte, ""));
        }
        return lesQuestionsPosees;
    }
}
