package com.codeine.codingweek;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {

    private static Scene scene ;
    private static FlashCardGame fcg ;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene ;
    }

    public static void setCarnet(FlashCardGame fcg) {
        ViewSwitcher.fcg = fcg ;
    }


    public static void swtichTo(View view) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewSwitcher.class.getResource(view.getFileName()));

        AccueilController accueilController = new AccueilController();

        CreationPileController creationPileController = new CreationPileController();
        CreationCarteController creationCarteController = new CreationCarteController();
        MenuController menuController = new MenuController();

        loader.setControllerFactory(ic -> {
            if (ic.equals(AccueilController.class)) return accueilController;
            else if (ic.equals(CreationPileController.class)) return creationPileController;
            else if (ic.equals(CreationCarteController.class)) return creationCarteController;
            else if (ic.equals(MenuController.class)) return menuController;

            else System.out.println("Pas de controller trouve");
            return null;
        });

        Parent root = loader.load();
        scene.setRoot(root);
    }
}
