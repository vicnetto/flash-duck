package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;

public class PageStatistiquesController implements Initializable {

    public GridPane gridPiles;

    private FlashCardGame fcg;

    public PageStatistiquesController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO remplir la grid avec les piles stockées dans l'application
        IntConsumer goToPileStatistique = integer -> {
            try {
                goToPileStatistique(integer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        try {
            AfficherPiles.afficherToutesLesPiles(fcg, gridPiles, goToPileStatistique);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToPileStatistique(int numPile) throws IOException {
        // TODO setCurrentPile au numéro de bonne pile et déplacement vers la page
        this.fcg.setCurrentPile(numPile);
        ViewSwitcher.switchTo(View.STATISTIQUES_PAGE_PILE);
    }

    @FXML
    public void goToStatistiquesGlobales() throws IOException  {
        ViewSwitcher.switchTo(View.STATISTIQUES_PAGE_GLOBAL) ;
    }

}
