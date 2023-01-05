package com.codeine.codingweek;

import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {

    @FXML
    private void menuPrincipal() throws IOException {
        ViewSwitcher.switchTo(View.ACCUEIL);
    }

    @FXML
    private void menuApprentissage() throws IOException {
        ViewSwitcher.switchTo(View.APPRENTISSAGE_ACCUEIL);
    }

    @FXML
    private void menuCreation() throws IOException {
        ViewSwitcher.switchTo(View.PILE_CREATION);
    }
}
