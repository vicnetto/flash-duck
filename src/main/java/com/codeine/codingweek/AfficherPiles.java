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

    public static final String cellStyle = "-fx-border-color: black;-fx-border-radius: 5; -fx-margin-bottom: 20; -fx-background-color: #f3f6dd;";
    public static final String disableCellStyle = "-fx-border-color: black;-fx-border-radius: 5; -fx-margin-bottom: 20; -fx-background-color: #b4b4b4;";

    public static void afficherToutesLesPiles(FlashCardGame fcg, GridPane gridPiles, IntConsumer goToPile) {
        int line;
        int column = -1;

        for (int i = 0; i < fcg.getLesPiles().size(); i++) {
            VBox vb = new VBox();
            vb.setPrefSize(150, 80);
            vb.setAlignment(Pos.CENTER);
            vb.setPadding(new Insets(10));
            vb.setStyle(cellStyle);
            vb.setOnMouseEntered(action ->
                    vb.setStyle(cellStyle + "-fx-background-color: #ffd064"));
            vb.setOnMouseExited(action ->
                    vb.setStyle(cellStyle + "-fx-background-color: #f3f6dd"));

            Label nom = new Label(fcg.getLesPiles().get(i).getName());
            nom.setStyle("-fx-text-fill: #000000");
            vb.getChildren().add(nom);

            int ii = i;
            vb.setOnMouseClicked(e -> goToPile.accept(ii));

            line = i / maxByLine;
            column = column == maxByLine - 1 ? 0 : column + 1;

            gridPiles.add(vb, column, line);
        }
    }

    public static void griserPilesVides(FlashCardGame fcg, GridPane gridPiles) {
        for (int i = 0; i < fcg.getLesPiles().size(); i++) {
            VBox vb = (VBox) gridPiles.getChildren().get(i);
            if (fcg.getLesPiles().get(i).getCards().size() == 0) {
                vb.setStyle(disableCellStyle);
                vb.setOnMouseEntered(action ->
                        vb.setStyle(cellStyle + "-fx-background-color: #b4b4b4"));
                vb.setOnMouseExited(action ->
                        vb.setStyle(cellStyle + "-fx-background-color: #b4b4b4"));
                vb.setOnMouseClicked(e -> {});
            }
        }
    }
}
