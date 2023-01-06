package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class TestAccueil {

    private VBox mainRoot;

    @Start
    private void start(Stage stage) throws IOException {
        FlashCardGame fcg = new FlashCardGame();
        FlashCardGameDummyData.dummyData(fcg);

        FXMLLoader loader = new FXMLLoader();
        ViewSwitcher.controllerFactory(loader);
        mainRoot = FXMLLoader.load(Main.class.getResource("fxml/page-accueil.fxml"));
        Scene scene = new Scene(mainRoot);
        scene.getStylesheets().add(Main.class.getResource("css/style.css").toExternalForm()) ;
        stage.setScene(scene);

        ViewSwitcher.setScene(scene) ;
        ViewSwitcher.setFlashCardGame(fcg);
        ViewSwitcher.switchTo(View.ACCUEIL);

        stage.show();
        stage.toFront();
    }

    @Test
    void shouldContainButtonCreation(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#creation").queryAs(Button.class)).hasText("Création");
        robot.clickOn("#creation");
    }

    @Test
    void shouldContainButtonApprentissage(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#apprentissage").queryAs(Button.class)).hasText("Apprentissage");
        robot.clickOn("#apprentissage");
    }
}
