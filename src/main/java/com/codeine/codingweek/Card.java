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
    
}
