package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.function.IntConsumer;

public class AfficherPiles {

    public static void afficherToutesLesPiles(FlashCardGame fcg, VBox gridPiles, IntConsumer goToPile) {

        for (int i = 0; i < fcg.getLesPiles().size(); i++) {
            VBox vb = new VBox();
            Label nom = new Label(fcg.getLesPiles().get(i).getName());
            vb.getChildren().add(nom);
            vb.setPadding(new Insets(10));
            vb.setStyle("-fx-border-color: black; -fx-border-radius: 5; -fx-margin-bottom: 20;");

            int ii = i;
            vb.setOnMouseClicked(e -> goToPile.accept(ii));

            gridPiles.getChildren().add(vb);
        }
    }
}
