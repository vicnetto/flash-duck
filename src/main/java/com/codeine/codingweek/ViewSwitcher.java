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

    public static void setFlashCardGame(FlashCardGame fcg) {
        ViewSwitcher.fcg = fcg ;
    }


    public static void swtichTo(View view) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewSwitcher.class.getResource(view.getFileName()));

        AccueilController accueilController = new AccueilController();
        AffichagePilesController affichagePilesController = new AffichagePilesController(fcg);
        AffichageCartesController affichageCartesController = new AffichageCartesController(fcg);
        CreationCarteController carteCreationController = new CreationCarteController(fcg);
        CreationPileController creationPileController = new CreationPileController(fcg);
        MenuController menuController = new MenuController();
        PageApprentissageAccueil apprentissageaccueilController = new PageApprentissageAccueil(fcg) ;
        ModificationCarteController modificationCarteController = new ModificationCarteController(fcg);

        loader.setControllerFactory(ic -> {
            if (ic.equals(AccueilController.class)) return accueilController ;
            else if (ic.equals(AffichagePilesController.class)) return affichagePilesController ;
            else if (ic.equals(CreationCarteController.class)) return carteCreationController ;
            else if (ic.equals(AffichageCartesController.class)) return affichageCartesController ;
            else if (ic.equals(CreationPileController.class)) return creationPileController ;
            else if (ic.equals(MenuController.class)) return menuController ;
            else if (ic.equals(PageApprentissageAccueil.class)) return apprentissageaccueilController ;
            else if (ic.equals(ModificationCarteController.class)) return modificationCarteController ;
            else System.out.println("Pas de controller trouve") ;
            return null;
        });

        Parent root = loader.load();
        
        scene.setRoot(root);

    }
}
