package com.codeine.codingweek;

import java.util.ArrayList;

public class Pile {

    private String category_name ; // Nom de la catégorie
    private int score = 0 ; // Score sur la pile actuelle
    private ArrayList<Card> cards = new ArrayList<>() ; 

    /* Calcul du score
     * 
     * Score de la dernière partie stockée en dur : nombre d'essais avant d'avoir bon (1, 2, 3+)
     * Score sur la pile stockée dans le dernier JSON : (1|2|3+) * nbr => somme pour score globale 
     * 
     */

    public Pile(String name, ArrayList<Card> cards) {

        this.category_name = name ;
        this.cards = cards ;

    }

    public ArrayList<Card> getCards() {
        return this.cards ;
    }

    public String getCategory() {
        return this.category_name ;
    }

    public void setCategory(String name) {
        this.category_name = name ;
    }

    
}
