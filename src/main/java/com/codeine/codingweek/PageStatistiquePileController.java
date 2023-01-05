package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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

        // Affichage pile actuel

        Pile currentPile = this.fcg.getPileCurrentPile() ;
        this.nomPile.setText(currentPile.getName()) ;

        // Récupèration des scores pour chaque parties

        ArrayList<Float> scores = new ArrayList<>() ;

        for (float score : currentPile.getScores()) {
            scores.add(score) ;
        }

        // Création graphique avec scores

        NumberAxis x = new NumberAxis() ;
        NumberAxis y = new NumberAxis() ;

        x.setLowerBound(0) ;
        x.setLabel("N° de la partie") ;
        y.setLowerBound(0) ;
        y.setLabel("Score sur la pile") ;

        LineChart<Number, Number> lineChart = new LineChart<>(x, y) ;
        XYChart.Series<Number, Number> series = new XYChart.Series<>() ;

        for (int i = 0; i < scores.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, scores.get(i))) ;
        }

        lineChart.getData().add(series) ;
        lineChart.setTitle("Progression des scores") ;
        lineChart.setLegendVisible(false) ;
        lineChart.setAnimated(true) ;

        // Ajout au container

        containerGraph.getChildren().add(lineChart) ;

    }
}
