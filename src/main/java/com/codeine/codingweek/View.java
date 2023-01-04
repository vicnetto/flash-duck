package com.codeine.codingweek;

public enum View {

    ACCUEIL("fxml/page-accueil.fxml"), // ControllerAccueil
    PILE_CREATION("fxml/page-pile-creation.fxml"), // AffichagePilesController
    CARTE_CREATION("fxml/page-carte-creation.fxml"), // AffichageCartesController
    FORM_CARTE("fxml/form-creation-carte.fxml"), // CreationCarteController
    FORM_PILE("fxml/form-creation-pile.fxml"), // CreationPileController
    FORM_MODIFICATION_CARTE("fxml/form-modification-carte.fxml"), // ModificationCarteController
    APPRENTISSAGE_ACCUEIL("fxml/page-apprentissage-accueil.fxml"), // PageApprentissageAccueil

    STATISTIQUES("fxml/page-statistiques.fxml"), //PageStatistiquesController
    APPRENTISSAGE_WHAT_IS_ASKED("fxml/page-apprentissage-whatisasked.fxml"), //PageApprentissageWhatIsAskedController
    APPRENTISSAGE_CREATOR_REPONSE("fxml/page-carte-reponse.fxml"); //AffichageCarteReponseController

    private String fileName ;

    View(String fileName) {
        this.fileName = fileName ;
    }

    public String getFileName() {
        return fileName ;
    }

}
