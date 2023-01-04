package com.codeine.codingweek;

import java.util.ArrayList;

public class ApprentissageCreatorReponse extends ApprentissageCreator{

    public ApprentissageCreatorReponse(FlashCardGame fcg) {
        super(fcg);
    }

    @Override
    public ArrayList<ApprentissageMethod> createApprentissage() {
        ArrayList<ApprentissageMethod> lesQuestionsPosees = new ArrayList<ApprentissageMethod>();
        for (Card carte : this.getFcg().getLesPiles().get(this.getFcg().getCurrentPile()).getCards()) {
            lesQuestionsPosees.add(new ApprentissageMethodReponse(carte, ""));
        }
        return lesQuestionsPosees;
    }

}
