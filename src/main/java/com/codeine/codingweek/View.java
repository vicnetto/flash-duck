package com.codeine.codingweek;

public enum View {

    ACCUEIL("fxml/page-accueil.fxml"), // ControllerAccueil

    PILE_CREATION("fxml/page-pile-creation.fxml"), // AffichagePilesController
    CARTE_CREATION("fxml/page-carte-creation.fxml"), // AffichageCartesController
    FORM_CARTE("fxml/form-creation-carte.fxml"), // CreationCarteController
    FORM_PILE("fxml/form-creation-pile.fxml"), // CreationPileController
    FORM_MODIFICATION_CARTE("fxml/form-modification-carte.fxml"), // ModificationCarteController
    FORM_MODIFICATION_PILE("fxml/form-modification-pile.fxml"), // ModificationPileController
    APPRENTISSAGE_ACCUEIL("fxml/page-apprentissage-accueil.fxml"), // PageApprentissageAccueil
    STATISTIQUES("fxml/page-statistiques.fxml"), //PageStatistiquesController
    APPRENTISSAGE_WHAT_IS_ASKED("fxml/page-apprentissage-whatisasked.fxml"), //PageApprentissageWhatIsAskedController
    APPRENTISSAGE_FORM_SELECT_PARAMETERS("fxml/form-select-parameter-game.fxml"), //FormSelectParameterGameController
    APPRENTISSAGE_CREATOR_REPONSE("fxml/page-carte-reponse.fxml"), //AffichageCarteReponseController
    STATISTIQUES_PAGE_PILE("fxml/page-statistique-pile.fxml"), //PageStatistiquePileController
    STATISTIQUES_PAGE_GLOBAL("fxml/page-statistique-global.fxml");  //PageStatistiqueGlobalController

    private String fileName ;

    View(String fileName) {
        this.fileName = fileName ;
    }

    public String getFileName() {
        return fileName ;
    }

}
