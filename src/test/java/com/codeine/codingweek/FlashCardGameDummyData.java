package com.codeine.codingweek;

import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;

import java.util.ArrayList;

public class FlashCardGameDummyData {

    public static void dummyData(FlashCardGame flashCardGame) {

        Pile maPile = new Pile("Histoire","Histoire");
        maPile.addCarte(new Card("Année de la révolution française", "1789"));
        maPile.addCarte(new Card("Dans quel pays est né Nikos Aliagas ?", "France (eh ça t'en bouche un coin)"));
        maPile.addCarte(new Card("Qui n'aime pas la tarte aux pommes ?", "Les racistes"));
        ArrayList<Float> scores = new ArrayList<Float>();
        scores.add((float) 21.0);
        scores.add((float) 55.0);
        scores.add((float) 86.0);
        scores.add((float) 100);
        maPile.setScores(scores);
        flashCardGame.addPile(maPile);

        maPile = new Pile("Gastronomie", "France");
        maPile.addCarte(new Card("Qu'elle est la spécialité de la Picardie ?", "La ficelle picarde")) ;
        scores = new ArrayList<Float>() ;
        scores.add((float) 98.0) ;
        maPile.setScores(scores) ;
        flashCardGame.addPile(maPile) ;
    }

}
