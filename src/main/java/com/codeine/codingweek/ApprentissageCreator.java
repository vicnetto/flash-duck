package com.codeine.codingweek;

import java.util.ArrayList;

public abstract class ApprentissageCreator {

    private FlashCardGame fcg;

    public ApprentissageCreator(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    public abstract ArrayList<ApprentissageMethod> createApprentissage();
}
