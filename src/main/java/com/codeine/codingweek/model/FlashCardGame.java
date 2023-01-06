package com.codeine.codingweek.model;

import com.codeine.codingweek.PatternStrategyQuestions.ApprentissageMethod;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlashCardGame {

    private ArrayList<Pile> lesPiles;
    private int currentPile = 0;
    private int currentCarte = 0;
    private HashMap<String, String> categoriesImagePath = new HashMap<String, String>();

    // APPRENTISSAGE
    private ArrayList<ApprentissageMethod> currentApprentissageList;
    private int currentIndexApprentissageList;
    private boolean shuffle;

    public FlashCardGame() {
        lesPiles = new ArrayList<Pile>();
        categoriesImagePath.put("Histoire", "images/categ_bg_default.jpg");
        categoriesImagePath.put("Art", "images/categ_bg_art.jpg");
        categoriesImagePath.put("Musique", "images/categ_bg_default.jpg");
        categoriesImagePath.put("Cinéma", "images/categ_bg_default.jpg");
        categoriesImagePath.put("Gastronomie", "images/categ_bg_default.jpg");
        categoriesImagePath.put("Sport", "images/categ_bg_default.jpg");
        categoriesImagePath.put("Science", "images/categ_bg_default.jpg");
        categoriesImagePath.put("Littérature", "images/categ_bg_default.jpg");
    }

    public void addCategorie(String nom, String imagePath) {
        this.categoriesImagePath.put(nom, imagePath);
    }

    public void removeCategorie(String nom) {
        this.categoriesImagePath.remove(nom);
    }

    public List<String> getCategories() {
        return new ArrayList<String>(categoriesImagePath.keySet());
    }

    public ArrayList<Pile> getLesPiles() {
        return lesPiles;
    }

    public HashMap<String, String> getCategoriesImagePath() {
        return categoriesImagePath;
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

    public void removePileByIndex(int index) {
        this.lesPiles.remove(index);
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
    public Pile getPileCurrentPile() {
        return this.getLesPiles().get(this.getCurrentPile());
    }

}

