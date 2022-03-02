package com.montaury.mus.jeu.joueur;

import com.montaury.mus.console.InterfaceJoueurHumain;
import com.montaury.mus.jeu.carte.Carte;
import java.util.List;
import java.util.Collections;
import com.montaury.mus.jeu.joueur.Joueur;


public class Equipe {

    /*LES ATTRIBUTS*/
    private String nomEquipe;   //nom de l'equipe en string
    private List<Joueur> joueursEquipe;     // les joueurs qui composent une équipe

    /*CONSTRUCTEUR*/

    //constructeur demandant le joueur 1, le joueur 2 et son nom

    public Equipe(List<Joueur> mesJoueurs, String nom)
    {
        this.joueursEquipe=mesJoueurs;
        this.nomEquipe=nom;
    }

    /*METHODES*/

    public void tourner()
    {
        Collections.rotate( this.joueursEquipe, 1);
    }

    public Joueur getJoueurEsku()
    {
        return joueursEquipe.get(0);
    }

    public Joueur getJoueurZaku()
    {
        return joueursEquipe.get(1);
    }
}