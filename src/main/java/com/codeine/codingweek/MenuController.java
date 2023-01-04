package com.codeine.codingweek;

import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {

    @FXML
    private void menuPrincipal() throws IOException {
        ViewSwitcher.swtichTo(View.ACCUEIL);
    }

    @FXML
    private void menuApprentissage() throws IOException {
        ViewSwitcher.swtichTo(View.APPRENTISSAGE_ACCUEIL);
    }

    @FXML
    private void menuCreation() throws IOException {
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }
}
