package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.util.function.IntConsumer;

public class AfficherPiles {

    public static final int MAX_BY_LINE = 4;

    public static void afficherToutesLesPiles(FlashCardGame fcg, GridPane gridPiles, IntConsumer goToPile) {

        // Trie des piles par thème

        fcg.sort() ;

        // Affichage

        int line;
        int column = -1;

        for (int i = 0; i < fcg.getLesPiles().size(); i++) {
            VBox vb = new VBox();
            vb.setPrefSize(150, 80);
            vb.setAlignment(Pos.CENTER);
            vb.setPadding(new Insets(10));
            vb.getStyleClass().add("pile_show");

            Label nom = new Label(fcg.getLesPiles().get(i).getName());
            nom.setStyle("-fx-text-fill: #000000");
            vb.getChildren().add(nom);

            int ii = i;
            vb.setOnMouseClicked(e -> goToPile.accept(ii));

            line = i / MAX_BY_LINE;
            column = column == MAX_BY_LINE - 1 ? 0 : column + 1;

            gridPiles.add(vb, column, line);
        }
    }

    public static void griserPilesVides(FlashCardGame fcg, GridPane gridPiles) {
        for (int i = 0; i < fcg.getLesPiles().size(); i++) {
            VBox vb = (VBox) gridPiles.getChildren().get(i);
            if (fcg.getLesPiles().get(i).getCards().isEmpty()) {
                vb.getStyleClass().add("pile_show_grey");
                vb.setOnMouseClicked(e -> {});
            }
        }
    }
}
