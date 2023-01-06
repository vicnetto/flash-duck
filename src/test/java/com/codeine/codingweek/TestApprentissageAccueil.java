package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
public class TestApprentissageAccueil {

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
        stage.setScene(mainScene);

        ViewSwitcher.setScene(mainScene) ;
        ViewSwitcher.setFlashCardGame(fcg);
        ViewSwitcher.switchTo(View.ACCUEIL);

        stage.show();
        stage.toFront();
    }

    @Test
    void shouldContainTwoStacks(FxRobot robot) {
        robot.clickOn("#apprentissage");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox firstElement = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(0);
        VBox secondElement = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(firstElement);
        org.junit.jupiter.api.Assertions.assertNotNull(secondElement);
        robot.clickOn(secondElement);
    }

    @Test
    void shouldContainReturnButton(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#apprentissage").queryAs(Button.class)).hasText("Apprentissage");
        robot.clickOn("#apprentissage");

        Assertions.assertThat(robot.lookup("#return").queryAs(Button.class)).hasText("Retour");
        robot.clickOn("#return");
    }

    @Test
    void shouldContainStatisticsButton(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#apprentissage").queryAs(Button.class)).hasText("Apprentissage");
        robot.clickOn("#apprentissage");

        Assertions.assertThat(robot.lookup("#statistics").queryAs(Button.class)).hasText("Statistiques");
        robot.clickOn("#statistics");
    }
}
