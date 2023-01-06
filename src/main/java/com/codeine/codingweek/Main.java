package com.codeine.codingweek;

import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new BorderPane()) ;

        FlashCardGame fcg = new FlashCardGame();

        // DONNEES DE TEST
        Pile maPile = new Pile("Histoire","Première Guerre Mondiale");
        maPile.addCarte(new Card("Année de début de la Première Guerre Mondiale", "1914"));
        maPile.addCarte(new Card("Année de fin de la Première Guerre Mondiale", "1918"));
        maPile.addCarte(new Card("Quelles étaient les forces impliquées dans le camps de l'Entente ?", "France, Royaume-Uni, Russie, États-Unis"));
        maPile.addCarte(new Card("Quelles étaient les forces impliquées dans le camps de l'Axe ?", "Allemagne, Autriche-Hongrie, Italie"));
        maPile.addCarte(new Card("Quel camps a remporté ce conflit ?", "L'Entente"));
        ArrayList<Float> scores = new ArrayList<Float>();
        scores.add((float) 21.0);
        scores.add((float) 55.0);
        scores.add((float) 86.0);
        scores.add((float) 100);
        maPile.setScores(scores);
        fcg.addPile(maPile);

        maPile = new Pile("Gastronomie", "Gastronomie française");
        maPile.addCarte(new Card("Qu'elle est la spécialité de la Picardie ?", "La ficelle picarde")) ;
        maPile.addCarte(new Card("De quoi est composé le Potjevleesch ?", "De la viande froide en gelée")) ;
        maPile.addCarte(new Card("Quel est le plat préféré des français en 2022 ?", "Le magret de canard")) ;
        maPile.addCarte(new Card("Viande utilisée dans la blanquette de veau ?", "Le veau"));
        scores = new ArrayList<Float>();
        scores.add((float) 33.0);
        scores.add((float) 15.0);
        scores.add((float) 50.0);
        scores.add((float) 65.0);
        maPile.setScores(scores);
        fcg.addPile(maPile) ;

        maPile = new Pile("Sport", "Tournois de tennis");
        maPile.addCarte(new Card("Quel est le plus grand tournoi de tennis du monde ?", "L'Open de France (Rolland-Garros)")) ;
        maPile.addCarte(new Card("Qui est le joueur de tennis le plus titré de l'histoire ?", "Roger Federer")) ;
        maPile.addCarte(new Card("Quel est le tournoi de tennis le plus ancien du monde ?", "L'Open de Grande-Bretagne (Wimbledon)")) ;
        maPile.addCarte(new Card("Quel est le tournoi de tennis le plus prestigieux aux États-Unis ?", "L'US Open")) ;
        scores = new ArrayList<Float>();
        scores.add((float) 17.0);
        scores.add((float) 74.0);
        scores.add((float) 86.0);
        scores.add((float) 95.0);
        maPile.setScores(scores);
        fcg.addPile(maPile) ;

        // Scènes

        ViewSwitcher.setScene(scene) ;
        ViewSwitcher.setFlashCardGame(fcg);
        ViewSwitcher.switchTo(View.ACCUEIL);

        scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm()) ;

        stage.setTitle("FLASHDUCK") ;
        stage.getIcons().add(new Image(getClass().getResource("images/Mascotte_borderless.png").toExternalForm())) ;
        stage.setScene(scene) ;
        stage.show() ;
        
    }

    public static void main(String[] args) {
        launch() ;
    }

}
