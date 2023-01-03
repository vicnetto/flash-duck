package com.codeine.codingweek;

public class Card {

    private String question ;
    private String reponse ;
    private float freq_apparition ; // Fréquence d'apparition de base
    private int nbrErreur = 0 ; // Incrémente dès que le joueur se trompe

    /*
     * 
     * Fréquence d'apparition à stocker dans le JSON
     * Modifiable par l'utilisateur
     * n au début
     * fixe 0% si réponse trouvé
     * + x% si pas trouvé
     * 
     */

    public Card(String question, String reponse) {

        this.question = question ;
        this.reponse = reponse ;
        this.freq_apparition = 10 ; // A voir

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public float getFreq_apparition() {
        return freq_apparition;
    }

    public void setFreq_apparition(float freq_apparition) {
        this.freq_apparition = freq_apparition;
    }

    public int getNbrErreur() {
        return nbrErreur;
    }

    public void setNbrErreur(int nbrErreur) {
        this.nbrErreur = nbrErreur;
    }
}
