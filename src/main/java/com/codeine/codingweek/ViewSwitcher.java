package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
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

    public static Scene getScene() {
        return scene ;
    }

    public static void setFlashCardGame(FlashCardGame fcg) {
        ViewSwitcher.fcg = fcg ;
    }


    public static void switchTo(View view) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewSwitcher.class.getResource(view.getFileName()));

        loader.setControllerFactory(ic -> {
            if (ic.equals(AccueilController.class)) return new AccueilController();
            else if (ic.equals(AffichagePilesController.class)) return new AffichagePilesController(fcg) ;
            else if (ic.equals(CreationCarteController.class)) return new CreationCarteController(fcg) ;
            else if (ic.equals(AffichageCartesController.class)) return new AffichageCartesController(fcg) ;
            else if (ic.equals(CreationPileController.class)) return new CreationPileController(fcg) ;
            else if (ic.equals(MenuController.class)) return new MenuController() ;
            else if (ic.equals(PageApprentissageAccueil.class)) return new PageApprentissageAccueil(fcg) ;
            else if (ic.equals(ModificationCarteController.class)) return new ModificationCarteController(fcg) ;
            else if (ic.equals(ModificationPileController.class)) return new ModificationPileController(fcg) ;
            else if (ic.equals(FormSelectParameterGameController.class)) return new FormSelectParameterGameController(fcg) ;
            else if (ic.equals(PageApprentissageWhatisaskedController.class)) return new PageApprentissageWhatisaskedController(fcg) ;
            else if (ic.equals(AffichageCarteReponseController.class)) return new AffichageCarteReponseController(fcg);
            else if (ic.equals(PageStatistiquePileController.class)) return new PageStatistiquePileController(fcg);
            else if (ic.equals(PageStatistiquesController.class)) return new PageStatistiquesController(fcg);
            else if (ic.equals(PageStatistiqueGlobalController.class)) return new PageStatistiqueGlobalController(fcg);
            else System.out.println("Pas de controller trouve") ;
            return null;
        });

        Parent root = loader.load();

        scene.setRoot(root);

        root.requestFocus();
    }
}
