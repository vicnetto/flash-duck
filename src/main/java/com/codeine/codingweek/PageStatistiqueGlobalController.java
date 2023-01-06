package com.codeine.codingweek;

import java.io.IOException;
import java.net.URL;
import java.util.OptionalDouble;
import java.util.ResourceBundle;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;

import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;

public class PageStatistiqueGlobalController implements Initializable {
    
    public HBox containerGraph;

    private FlashCardGame fcg;

    public PageStatistiqueGlobalController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CategoryAxis x = new CategoryAxis() ;
        NumberAxis y = new NumberAxis() ;
        BarChart<String, Number> barChart = new BarChart<>(x, y) ;

        x.setLabel("Nom de la pile") ;

        y.setLabel("Score moyen") ;
        y.setAutoRanging(false);
        y.setLowerBound(0) ;
        y.setUpperBound(110) ;
        y.setTickUnit(10) ;

        for (Pile pile : fcg.getLesPiles()) {

            if (pile.getScores().size() == 0) continue ;

            // Récupèration de la moyenne des pour chaque parties

            OptionalDouble mean = pile.getScores().stream().mapToDouble(a -> a).average() ;

            // Graphique (ajout données)

            XYChart.Series<String, Number> series = new XYChart.Series<>() ;

            series.getData().add(new XYChart.Data<>(pile.getName(), mean.getAsDouble())) ;

            barChart.getData().add(series) ;

        }

        // Style

        barChart.setTitle("Moyenne des scores sur chaque pile") ;
        barChart.setLegendVisible(false) ;
        barChart.setAnimated(true) ;

        // Ajout à la page

        containerGraph.getChildren().add(barChart) ;

    }

    public void retour() throws IOException {
        ViewSwitcher.switchTo(View.STATISTIQUES);
    }

}