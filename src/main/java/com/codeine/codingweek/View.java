package com.codeine.codingweek;

public enum View {

    ACCUEIL("fxml/page-accueil.fxml"), // Page d'accueil = ControllerAccueil
    CREATION("fxml/page-creation.fxml"), // Page d'ajout de pile de cartes = GlobalController
    APPRENTISSAGE("fxml/page-apprentissage.fxml") ; //  

    private String fileName ;

    View(String fileName) {
        this.fileName = fileName ;
    }

    public String getFileName() {
        return fileName ;
    }

}
