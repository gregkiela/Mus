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
        for (Joueur joueur : mesJoueurs)
        {
            joueur.setEquipeJoueur(this);
        }
    }

    /*METHODES*/

    public void tourner()
    {
        var tmp = getJoueurEsku();
        setJoueurEsku(getJoueurZaku());
        setJoueurZaku(tmp);
    }

    public Joueur getJoueurEsku()
    {
        return joueursEquipe.get(0);
    }

    public Joueur getJoueurZaku(){return joueursEquipe.get(joueursEquipe.size()-1);}

    public String nomEquipe()
    {
        return this.nomEquipe;
    }

    public void retirer(Joueur joueur)
    {
        joueursEquipe.remove(joueur);
    }

    public void setJoueurEsku(Joueur joueur)
    {
         joueursEquipe.set(0,joueur);
    }

    public void setJoueurZaku(Joueur joueur)
    {
        joueursEquipe.set(joueursEquipe.size()-1, joueur);
    }

}