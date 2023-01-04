package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.function.IntConsumer;

public class AfficherPiles {

    public static final int maxByLine = 4;


    public static void afficherToutesLesPiles(FlashCardGame fcg, GridPane gridPiles, IntConsumer goToPile) {
        int line;
        int column = -1;

        for (int i = 0; i < fcg.getLesPiles().size(); i++) {
            VBox vb = new VBox();
            vb.setPrefSize(150, 80);
            vb.setAlignment(Pos.CENTER);

            Label nom = new Label(fcg.getLesPiles().get(i).getName());
            vb.getChildren().add(nom);
            vb.setPadding(new Insets(10));
            vb.setStyle("-fx-border-color: black; -fx-border-radius: 5; -fx-margin-bottom: 20;");

            int ii = i;
            vb.setOnMouseClicked(e -> goToPile.accept(ii));

            line = i / maxByLine;
            column = column == maxByLine - 1 ? 0 : column + 1;

            gridPiles.add(vb, column, line);
        }
    }
}
