package com.codeine.codingweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlashCardGame {

    private ArrayList<Pile> lesPiles;
    private int currentPile = 0;
    private int currentCarte = 0;
    private List<String> categories = Arrays.asList("Histoire", "Art", "Musique", "Cinéma", "Gastronomie", "Sport", "Science", "Littérature");

    private ArrayList<ApprentissageMethod> currentApprentissageList;

    private int currentIndexApprentissageList;

    public FlashCardGame() {
        lesPiles = new ArrayList<Pile>();
    }

    public ArrayList<Pile> getLesPiles() {
        return lesPiles;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setLesPiles(ArrayList<Pile> lesPiles) {
        this.lesPiles = lesPiles;
    }

    public void addPile(Pile laPile) {
        this.lesPiles.add(laPile);
    }

    public void removePileByNom(String nomPile) {
        int i = 0;
        while (i < lesPiles.size()) {
            if (lesPiles.get(i).getName().equals(nomPile)) {
                lesPiles.remove(i);
                return;
            }
            i++;
        }
    }

    public int getCurrentPile() {
        return currentPile;
    }

    public void setCurrentPile(int currentPile) {
        this.currentPile = currentPile;
    }

    public int getCurrentCarte() {
        return currentCarte;
    }

    public void setCurrentCarte(int currentCarte) {
        this.currentCarte = currentCarte;
    }

    public ArrayList<ApprentissageMethod> getCurrentApprentissageList() {
        return currentApprentissageList;
    }

    public void setCurrentApprentissageList(ArrayList<ApprentissageMethod> currentApprentissageList) {
        this.currentApprentissageList = currentApprentissageList;
    }

    public void addApprentissageMethodToList(ApprentissageMethod am) {
        this.currentApprentissageList.add(am);
    }

    public int getCurrentIndexApprentissageList() {
        return currentIndexApprentissageList;
    }

    public void setCurrentIndexApprentissageList(int currentIndexApprentissageList) {
        this.currentIndexApprentissageList = currentIndexApprentissageList;
    }
}
