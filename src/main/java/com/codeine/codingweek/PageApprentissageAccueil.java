package com.codeine.codingweek;


import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;

public class PageApprentissageAccueil implements Initializable {

    @FXML
    private GridPane gridPiles;

    private FlashCardGame fcg;

    public PageApprentissageAccueil(FlashCardGame fcg) {
        this.fcg = fcg ;
    }

    public void statistiques() throws IOException {
        ViewSwitcher.switchTo(View.STATISTIQUES);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IntConsumer goToPile = integer -> {
            try {
                goToPile(integer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        try {
            AfficherPiles.afficherToutesLesPiles(fcg, gridPiles, goToPile);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        AfficherPiles.griserPilesVides(fcg, gridPiles);
    }

    public void goToPile(int i) throws IOException {
        this.fcg.setCurrentPile(i);

        /* Répartition équiprobable une fois au début de la partie */
        for (Card card : fcg.getPileCurrentPile().getCards()) {
            card.setFreq_apparition(((double)1)/fcg.getPileCurrentPile().getCards().size()) ;
        }

        ViewSwitcher.switchTo(View.APPRENTISSAGE_FORM_SELECT_PARAMETERS);
    }

    public void retour() throws IOException {
        ViewSwitcher.switchTo(View.ACCUEIL);
    }

}
