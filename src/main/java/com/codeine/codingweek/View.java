package com.codeine.codingweek;

public enum View {

    ACCUEIL("fxml/page-accueil.fxml"), // ControllerAccueil
    PILE_CREATION("fxml/page-pile-creation.fxml"), // ControllerGlobal
    CARTE_CREATION("fxml/page-carte-creation.fxml"), // ControllerCarteCreation
    FORM_CARTE_CREATION("fxml/form-creation-carte.fxml") // Controller
    ;

    private String fileName ;

    View(String fileName) {
        this.fileName = fileName ;
    }

    public String getFileName() {
        return fileName ;
    }

}
