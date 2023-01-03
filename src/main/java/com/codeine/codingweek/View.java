package com.codeine.codingweek;

public enum View {

    ACCUEIL("fxml/page-accueil.fxml"),
    PILE_CREATION("fxml/page-pile-creation.fxml"),
    CARTE_CREATION("fxml/page-carte-creation.fxml");

    private String fileName ;

    View(String fileName) {
        this.fileName = fileName ;
    }

    public String getFileName() {
        return fileName ;
    }
}
