package com.codeine.codingweek;

import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageCreatorQuestion;
import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageCreatorReponse;
import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageMethod;
import com.codeine.codingweek.model.FlashCardGame;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;

public class FormSelectParameterGameController {
    private FlashCardGame fcg;

    public FormSelectParameterGameController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    public void goToGameWithQuestions(ActionEvent actionEvent) throws IOException {
        this.fcg.setCurrentIndexApprentissageList(0);
        ApprentissageCreatorQuestion acq = new ApprentissageCreatorQuestion(fcg);
        ArrayList<ApprentissageMethod> amq = acq.createApprentissage();
        this.fcg.setCurrentApprentissageList(amq);
        ViewSwitcher.switchTo(View.APPRENTISSAGE_WHAT_IS_ASKED);
    }

    public void goToGameWithReponses(ActionEvent actionEvent) throws IOException {
        this.fcg.setCurrentIndexApprentissageList(0);
        ApprentissageCreatorReponse acq = new ApprentissageCreatorReponse(fcg);
        ArrayList<ApprentissageMethod> amq = acq.createApprentissage();
        this.fcg.setCurrentApprentissageList(amq);
        ViewSwitcher.switchTo(View.APPRENTISSAGE_WHAT_IS_ASKED);
    }
}
