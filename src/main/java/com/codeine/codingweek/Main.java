package com.codeine.codingweek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new Pane());
        FlashCardGame fcg = new FlashCardGame();
        ViewSwitcher.setScene(scene);
        ViewSwitcher.setCarnet(fcg);

        ViewSwitcher.swtichTo(View.ACCUEIL);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}