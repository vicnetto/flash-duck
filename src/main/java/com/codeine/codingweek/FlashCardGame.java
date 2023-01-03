package com.codeine.codingweek;

import java.util.ArrayList;

public class FlashCardGame {

    private ArrayList<Pile> lesPiles;

    public FlashCardGame() {
    }

    public ArrayList<Pile> getLesPiles() {
        return lesPiles;
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
}
