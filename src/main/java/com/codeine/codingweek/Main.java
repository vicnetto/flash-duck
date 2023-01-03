package com.codeine.codingweek;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new BorderPane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.swtichTo(View.ACCUEIL);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch() ;
    }

}