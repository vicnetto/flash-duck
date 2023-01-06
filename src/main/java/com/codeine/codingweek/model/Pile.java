package com.codeine.codingweek.model;

import java.util.ArrayList;

public class Pile implements Comparable<Pile> {

    private String category_name ; // Nom de la catégorie
    private String name ;

    private ArrayList<Card> cards = new ArrayList<>() ; 

    private ArrayList<Float> scores = new ArrayList<>() ;
    /* Calcul du score
     * 
     * Score de la dernière partie stockée en dur : nombre d'essais avant d'avoir bon (1, 2, 3+)
     * Score sur la pile stockée dans le dernier JSON : (1|2|3+) * nbr => somme pour score globale 
     * 
     */

    public Pile(String category_name, String name, ArrayList<Card> cards) {

        this.category_name = category_name ;
        this.name = name ;
        this.cards = cards ;

    }

    public Pile(String category_name, String name) {

        this.category_name = category_name ;
        this.name = name ;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCarte(Card carte) {
        this.cards.add(carte);
    }

    public void deleteCarteByIndex(int i) {
        this.cards.remove(i);
    }
    public void deleteCarteByQuestion(String question) {
        for (Card carte : this.cards) {
            if (carte.getQuestion().equals(question)) {
                this.cards.remove(carte);
            }
        }
    }

    public ArrayList<Float> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Float> scores) {
        this.scores = scores;
    }

    public void addScore(float score) {
        this.scores.add(score);
    }

    @Override
    public int compareTo(Pile other) {
        return this.category_name.compareTo(other.getCategory()) ;
    }

}
