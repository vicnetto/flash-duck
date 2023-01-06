package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.security.Identity;
import java.util.HashMap;
import java.util.function.IntConsumer;

public class AfficherPiles {

    public static final int MAX_BY_LINE = 4;

    public static void afficherToutesLesPiles(FlashCardGame fcg, GridPane gridPiles, IntConsumer goToPile) throws ClassNotFoundException {

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
            // RECUPERATION DU PATH DE L'IMAGE
            Class<?> currClass = Class.forName("com.codeine.codingweek.AffichagePilesController"); // BIZARRE
            String categorie = fcg.getLesPiles().get(i).getCategory();
            HashMap<String, String> hmap = fcg.getCategoriesImagePath();
            String imgPathCateg = hmap.get(categorie);
            String path;
            if (imgPathCateg == null) {
                path = currClass.getResource("images/categ_bg_default.jpg").toString();
            }
            else {
                path = currClass.getResource(imgPathCateg).toString();
            }
            // CREATION DE L'IMAGE
            Image bg = new Image(path);
            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
            BackgroundImage bimg = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            // BLUR
//            GaussianBlur blur = new GaussianBlur(10);
            vb.setBackground(new Background(bimg));

            Label nom = new Label(fcg.getLesPiles().get(i).getName());
            nom.setStyle("-fx-text-fill: white");
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
                Label innerLabel = (Label) vb.getChildren().get(0);
                innerLabel.setStyle("-fx-text-fill: #9f9f9f");
                vb.setOnMouseClicked(e -> {});
            }
        }
    }
}
