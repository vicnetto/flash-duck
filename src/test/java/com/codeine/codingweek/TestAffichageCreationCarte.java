package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
public class TestAffichageCreationCarte {

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
        mainScene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm()) ;
        stage.setScene(mainScene);

        ViewSwitcher.setScene(mainScene) ;
        ViewSwitcher.setFlashCardGame(fcg);
        ViewSwitcher.switchTo(View.ACCUEIL);

        stage.show();
        stage.toFront();
    }

    @Test
    void shouldHaveThreeCards(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        for (int i = 0; i < 3; i++) {
            HBox card = (HBox) ((VBox) ((BorderPane) ((ScrollPane)
                    vBox.getChildren().get(2)).getContent()).getCenter()).getChildren().get(i);

            org.junit.jupiter.api.Assertions.assertNotNull(card);
        }
    }

    @Test
    void cardShouldHaveADeleteButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        HBox thirdCard = (HBox) ((VBox) ((BorderPane) ((ScrollPane)
                vBox.getChildren().get(2)).getContent()).getCenter()).getChildren().get(2);
        org.junit.jupiter.api.Assertions.assertNotNull(thirdCard);

        VBox rightBox = (VBox) thirdCard.getChildren().get(1);
        Button delete = (Button) rightBox.getChildren().get(1);
        robot.clickOn(delete);
    }

    @Test
    void cardShouldHaveAnEditButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        HBox thirdCard = (HBox) ((VBox) ((BorderPane) ((ScrollPane)
                vBox.getChildren().get(2)).getContent()).getCenter()).getChildren().get(2);
        org.junit.jupiter.api.Assertions.assertNotNull(thirdCard);

        VBox rightBox = (VBox) thirdCard.getChildren().get(1);
        Button edit = (Button) rightBox.getChildren().get(0);
        robot.clickOn(edit);
    }

    @Test
    void stackShouldHaveADeleteButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        Button deleteStack =  ((Button) ((HBox) ((StackPane)
                vBox.getChildren().get(1)).getChildren().get(1)).getChildren().get(1));
        org.junit.jupiter.api.Assertions.assertNotNull(deleteStack);
        robot.clickOn(deleteStack);
    }

    @Test
    void stackShouldHaveAEditButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        Button deleteStack =  ((Button) ((HBox) ((StackPane)
                vBox.getChildren().get(1)).getChildren().get(1)).getChildren().get(0));
        org.junit.jupiter.api.Assertions.assertNotNull(deleteStack);
        robot.clickOn(deleteStack);
    }

    @Test
    void stackShouldHaveAReturnButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        Button returnButton = (Button) ((HBox) vBox.getChildren().get(3)).getChildren().get(0);
        org.junit.jupiter.api.Assertions.assertNotNull(returnButton);
        robot.clickOn(returnButton);
    }

    @Test
    void stackShouldHaveAAddACardButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        Button ajouterCarte = (Button) ((HBox) vBox.getChildren().get(3)).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(ajouterCarte);
        robot.clickOn(ajouterCarte);
    }

    @Test
    void stackShouldHaveAExporterStackButton(FxRobot robot) {
        robot.clickOn("#creation");
        VBox vBox = (VBox) mainScene.getRoot();
        VBox secondStack = (VBox) ((GridPane) ((ScrollPane) vBox.getChildren().get(2)).getContent()).getChildren().get(1);
        org.junit.jupiter.api.Assertions.assertNotNull(secondStack);
        robot.clickOn(secondStack);

        vBox = (VBox) mainScene.getRoot();
        Button ajouterCarte = (Button) ((HBox) vBox.getChildren().get(3)).getChildren().get(2);
        org.junit.jupiter.api.Assertions.assertNotNull(ajouterCarte);
    }
}
