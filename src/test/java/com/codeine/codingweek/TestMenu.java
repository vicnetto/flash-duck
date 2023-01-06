package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class TestMenu {

    private Scene mainScene;

    private VBox mainRoot;

    @Start
    private void start(Stage stage) throws IOException {
        FlashCardGame fcg = new FlashCardGame();
        FlashCardGameDummyData.dummyData(fcg);

        FXMLLoader loader = new FXMLLoader();
        ViewSwitcher.controllerFactory(loader);
        mainRoot = FXMLLoader.load(Main.class.getResource("fxml/page-accueil.fxml"));
        mainScene = new Scene(mainRoot);
        mainScene.getStylesheets().add(Main.class.getResource("css/style.css").toExternalForm()) ;
        stage.setScene(mainScene);

        ViewSwitcher.setScene(mainScene) ;
        ViewSwitcher.setFlashCardGame(fcg);
        ViewSwitcher.switchTo(View.ACCUEIL);

        stage.show();
        stage.toFront();
    }

    @Test
    void shouldContainButtonPrincipal(FxRobot robot) {
        robot.clickOn("#menuPrincipal");
    }

    @Test
    void shouldContainButtonApprentissage(FxRobot robot) {
        robot.clickOn("#menuLearn");
    }

    @Test
    void shouldContainButtonCreation(FxRobot robot) {
        robot.clickOn("#menuCreate");
    }
}
