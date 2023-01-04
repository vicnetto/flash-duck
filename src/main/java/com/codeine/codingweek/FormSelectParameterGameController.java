package com.codeine.codingweek;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;

public class FormSelectParameterGameController {
    private FlashCardGame fcg;

    public FormSelectParameterGameController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    public void goToGameWithQuestions(ActionEvent actionEvent) throws IOException {
        this.fcg.setCurrentCarte(0);
        ApprentissageCreatorQuestion acq = new ApprentissageCreatorQuestion(fcg);
        ArrayList<ApprentissageMethod> amq = acq.createApprentissage();
        this.fcg.setCurrentApprentissageList(amq);
        ViewSwitcher.swtichTo(View.APPRENTISSAGE_WHAT_IS_ASKED);
    }

    public void goToGameWithReponses(ActionEvent actionEvent) throws IOException {
        this.fcg.setCurrentCarte(0);
        ApprentissageCreatorReponse acq = new ApprentissageCreatorReponse(fcg);
        ArrayList<ApprentissageMethod> amq = acq.createApprentissage();
        this.fcg.setCurrentApprentissageList(amq);
        ViewSwitcher.swtichTo(View.APPRENTISSAGE_WHAT_IS_ASKED);
    }
}
