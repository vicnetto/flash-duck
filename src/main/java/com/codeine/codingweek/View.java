package com.codeine.codingweek;

public enum View {

    ACCUEIL("fxml/page-accueil.fxml"), // ControllerAccueil
    PILE_CREATION("fxml/page-pile-creation.fxml"), // ControlleurGlobal
    CARTE_CREATION("fxml/page-carte-creation.fxml") // ControlleurCarteCreation
    ;

    private String fileName ;

    View(String fileName) {
        this.fileName = fileName ;
    }

    public String getFileName() {
        return fileName ;
    }

}
