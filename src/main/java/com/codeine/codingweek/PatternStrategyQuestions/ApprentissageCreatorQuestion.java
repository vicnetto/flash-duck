package com.codeine.codingweek.PatternStrategyQuestions;

import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;

import java.util.ArrayList;
import java.util.List;

public class ApprentissageCreatorQuestion extends ApprentissageCreator{

    public ApprentissageCreatorQuestion(FlashCardGame fcg) {
        super(fcg);
    }

    @Override
    public ArrayList<ApprentissageMethod> createApprentissage() {
        ArrayList<ApprentissageMethod> lesQuestionsPosees = new ArrayList<>();
        List<Card> cartes = this.getFcg().getLesPiles().get(this.getFcg().getCurrentPile()).getCards();

        int i = 0;
        for (Card carte : cartes) {
            i++;
            lesQuestionsPosees.add(new ApprentissageMethodQuestion(cartes.size(), i, carte, ""));
        }
        return lesQuestionsPosees;
    }
}
