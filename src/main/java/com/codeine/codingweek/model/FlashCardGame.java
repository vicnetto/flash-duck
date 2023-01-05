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
    private HashMap<String, Color> categoriesColor = new HashMap<String, Color>();

    private ArrayList<ApprentissageMethod> currentApprentissageList;

    private int currentIndexApprentissageList;

    public FlashCardGame() {
        lesPiles = new ArrayList<Pile>();
        categoriesColor.put("Histoire", new Color(203, 25, 231));
        categoriesColor.put("Art", new Color(231, 221, 98));
        categoriesColor.put("Musique", new Color(255, 0, 0));
        categoriesColor.put("Cinéma", new Color(57, 76, 206));
        categoriesColor.put("Gastronomie", new Color(173, 112, 67));
        categoriesColor.put("Sport", new Color(128, 40, 40));
        categoriesColor.put("Science", new Color(0, 255, 185));
        categoriesColor.put("Littérature", new Color(22, 180, 24));
    }

    public void addCategorie(String nom, Color couleur) {
        this.categoriesColor.put(nom, couleur);
    }

    public void removeCategorie(String nom) {
        this.categoriesColor.remove(nom);
    }

    public List<String> getCategories() {
        return new ArrayList<String>(categoriesColor.keySet());
    }

    public ArrayList<Pile> getLesPiles() {
        return lesPiles;
    }

    public HashMap<String, Color> getCategoriesColor() {
        return categoriesColor;
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
    public Pile getPileCurrentPile() {
        return this.getLesPiles().get(this.getCurrentPile());
    }

}
