package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PageStatistiquePileController implements Initializable {

    public Label nomPile;
    public HBox containerGraph;

    private FlashCardGame fcg;

    public PageStatistiquePileController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Pile currentPile = this.fcg.getPileCurrentPile() ;

        // Récupèration des scores pour chaque parties

        ArrayList<Float> scores = new ArrayList<>() ;

        for (float score : currentPile.getScores()) {
            scores.add(score) ;
        }

        // Affichage pile actuel
        this.nomPile.setText("Scores pour la pile " + currentPile.getName() + 
                                " (" + Integer.toString(scores.size()) + " parties)") ;

        // Création graphique avec scores

        NumberAxis x = new NumberAxis() ;
        NumberAxis y = new NumberAxis() ;

        x.setAutoRanging(false) ;
        x.setLowerBound(0) ;
        x.setUpperBound(scores.size()+1) ;
        x.setLabel("N° de la partie") ;
        x.setTickUnit(1) ;
        
        y.setLabel("Score sur la pile") ;
        y.setAutoRanging(false);
        y.setLowerBound(0) ;
        y.setUpperBound(110) ;
        y.setTickUnit(10) ;

        LineChart<Number, Number> lineChart = new LineChart<>(x, y) ;
        XYChart.Series<Number, Number> series = new XYChart.Series<>() ;

        for (int i = 0; i < scores.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, scores.get(i))) ;
        }

        lineChart.getData().add(series) ;
        lineChart.setTitle("Progression du score") ;
        lineChart.setLegendVisible(false) ;
        lineChart.setAnimated(true) ;

        // Ajout au container

        containerGraph.getChildren().add(lineChart) ;

    }

    public void retour() throws IOException{
        ViewSwitcher.switchTo(View.STATISTIQUES);
    }

    public void resetStats(ActionEvent actionEvent) throws IOException {
        Pile currentPile = this.fcg.getPileCurrentPile();
        currentPile.setScores(new ArrayList<Float>());
        ViewSwitcher.switchTo(View.STATISTIQUES_PAGE_PILE);
    }
}
