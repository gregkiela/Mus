package com.montaury.mus.jeu.joueur;

import com.montaury.mus.console.InterfaceJoueurHumain;
import com.montaury.mus.jeu.carte.Carte;
import java.util.List;
import com.montaury.mus.jeu.joueur.Joueur;


public class Equipe {

    /*LES ATTRIBUTS*/
    private String nomEquipe;//nom de l'equipe en string
    private Joueur joueurEsku;//joueur numero 1 de l'equipe
    private Joueur joueurZaku;//joueur numero 2 de l'equipe

    /*CONSTRUCTEUR*/

    //constructeur demandant le joueur 1, le joueur 2 et son nom
    public Equipe(Joueur j1, Joueur j2, String nom)
    {
        joueurEsku=j1;
        joueurZaku=j2;
        nomEquipe=nom;
    }

    /*METHODES*/

    public void tourner()
    {
        var tmp= joueurEsku;
        joueurEsku=joueurZaku;
        joueurZaku=tmp;
    }
}