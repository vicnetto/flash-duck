package com.codeine.codingweek;

import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageMethod;
import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class AffichageCarteReponseController implements Initializable {

    @FXML
    private Label number;

    @FXML
    private Label reponse;

    @FXML
    private Label question;

    private double increment = 0 ;
    private double frequenciesSum = 0 ;

    private FlashCardGame fcg;

    public AffichageCarteReponseController(FlashCardGame flashCardGame) {

        this.fcg = flashCardGame;

        increment = ((double) 1)/(2*this.fcg.getPileCurrentPile().getCards().size()) ;

        for (Card card : this.fcg.getPileCurrentPile().getCards()) {
            frequenciesSum += card.getFreq_apparition() ;
        }

    }

    public FlashCardGame getFlashCardGame() {
        return fcg;
    }

    public void setFlashCardGame(FlashCardGame flashCardGame) {
        this.fcg = flashCardGame;
    }

    public void iKnew(ActionEvent actionEvent) throws IOException {
        
        /* JE SAVAIS => la fréquence d'apparition diminue */

        Card currentCard = this.fcg.getPileCurrentPile().getCards().get(this.fcg.getCurrentIndexApprentissageList()) ;
        if (currentCard.getFreq_apparition()-increment <= 0) currentCard.setFreq_apparition(1) ; // Normalement impossible mais bon
        else currentCard.setFreq_apparition(currentCard.getFreq_apparition()-increment) ;
        double randomNumber = new Random().nextDouble() * frequenciesSum ;

        /* Recherche d'une carte avec une fréquence d'apparition OK avec les fréquences pondérées */
        int i = 0 ;
        while (randomNumber >= this.fcg.getPileCurrentPile().getCards().get(i).getFreq_apparition()) {
            randomNumber -= this.fcg.getPileCurrentPile().getCards().get(i).getFreq_apparition() ;
            i++ ;
        }

        /* Prochaine carte */
        this.fcg.setCurrentIndexApprentissageList(i) ;
        handleNextApprentissage();

    }

    public void copyCurrentApprentissageToEndList() {
        /* Recopie à la fin de la liste si JE NE SAVAIS PAS de la carte pour reposer la question */
        ArrayList<ApprentissageMethod> lesQuestionsPosees = this.fcg.getCurrentApprentissageList();
        ApprentissageMethod currentQuestion = lesQuestionsPosees.get(this.fcg.getCurrentIndexApprentissageList());
        lesQuestionsPosees.add(currentQuestion);
    }

    public void iDidntKnow(ActionEvent actionEvent) throws IOException {


        /* JE NE SAVAIS PAS => la fréquence d'apparition augmente */

        Card currentCard = this.fcg.getPileCurrentPile().getCards().get(this.fcg.getCurrentIndexApprentissageList()) ;
       
        if (currentCard.getFreq_apparition()+increment >= 1) currentCard.setFreq_apparition(1) ;
        else currentCard.setFreq_apparition(currentCard.getFreq_apparition()+increment) ;
        double randomNumber = new Random().nextDouble() * frequenciesSum ;

        /* Recherche d'une carte avec une fréquence d'apparition OK avec les fréquences pondérées */
        int i = 0 ;
        while (randomNumber >= this.fcg.getPileCurrentPile().getCards().get(i).getFreq_apparition()) {
            randomNumber -= this.fcg.getPileCurrentPile().getCards().get(i).getFreq_apparition() ;
            i++ ;
        }

        /* Prochaine carte */
        this.fcg.setCurrentIndexApprentissageList(i) ;
        handleNextApprentissage();

    }

    public void handleNextApprentissage() throws IOException {
        if (this.fcg.getCurrentIndexApprentissageList() < this.fcg.getCurrentApprentissageList().size()) {
            ViewSwitcher.switchTo(View.APPRENTISSAGE_WHAT_IS_ASKED);
        }
        else {
            Pile pile = this.fcg.getLesPiles().get(this.fcg.getCurrentPile());
            Float div = (float) pile.getCards().size()/this.fcg.getCurrentIndexApprentissageList();
            pile.addScore((float) 100.0*(div));
            ViewSwitcher.switchTo(View.FIN_PARTIE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApprentissageMethod am = this.fcg.getCurrentApprentissageList().get(this.fcg.getCurrentIndexApprentissageList());
        Card carte = am.getCarte();
        this.number.setText(am.getQuestionNumber() + "/" + am.getQuantityOfQuestions());
        this.reponse.setText(carte.getReponse());
        this.question.setText(carte.getQuestion());
    }
}