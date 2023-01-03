package com.codeine.codingweek;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new BorderPane()) ;

        FlashCardGame fcg = new FlashCardGame();

        // DONNEES DE TEST
        Pile maPile = new Pile("Aucune catégorie","Histoire");
        maPile.addCarte(new Card("Année de la révolution française", "1789"));
        maPile.addCarte(new Card("Dans quel pays est né Nikos Aliagas ?", "France (eh ça t'en bouche un coin)"));
        maPile.addCarte(new Card("Qui n'aime pas la tarte aux pommes ?", "Les racistes"));
        fcg.addPile(maPile);

        ViewSwitcher.setScene(scene) ;
        ViewSwitcher.setFlashCardGame(fcg);
        ViewSwitcher.swtichTo(View.ACCUEIL) ;

        scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm()) ;

        stage.setTitle("TN FlashCards") ;
        stage.getIcons().add(new Image(getClass().getResource("images/Mascotte_borderless.png").toExternalForm())) ;
        stage.setScene(scene) ;
        stage.show() ;
    }

    public static void main(String[] args) {
        launch() ;
    }

}
