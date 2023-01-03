package com.codeine.codingweek;

public enum View {
    ACCUEIL("fxml/page-accueil.fxml");
    private String fileName;
    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
