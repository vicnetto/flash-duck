package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    public Button principal;

    @FXML
    public Button learn;

    @FXML
    private Button create;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create.setOnAction(actionEvent -> {
            try {
                menuCreation();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        principal.setOnAction(actionEvent -> {
            try {
                menuPrincipal();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        learn.setOnAction(actionEvent -> {
            try {
                menuApprentissage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void onAction(Menu menu) {
        final MenuItem menuItem = new MenuItem();

        menu.getItems().add(menuItem);
        menu.addEventHandler(Menu.ON_SHOWN, event -> menu.hide());
        menu.addEventHandler(Menu.ON_SHOWING, event -> menu.fire());
    }

    @FXML
    private void menuPrincipal() throws IOException {
        ViewSwitcher.switchTo(View.ACCUEIL);
    }

    @FXML
    private void menuApprentissage() throws IOException {
        ViewSwitcher.switchTo(View.APPRENTISSAGE_ACCUEIL);
    }

    @FXML
    private void menuCreation() throws IOException {
        ViewSwitcher.switchTo(View.PILE_CREATION);
    }

}
