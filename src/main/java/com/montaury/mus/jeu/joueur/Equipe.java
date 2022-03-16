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
    private int nbJoueur = 0;

    /*CONSTRUCTEUR*/

    //constructeur demandant une liste de joueur et le nom d'équipe
    public Equipe(List<Joueur> mesJoueurs, String nom)
    {
        this.joueursEquipe=mesJoueurs;
        this.nomEquipe=nom;
        for (Joueur joueur : mesJoueurs) {
            joueur.setEquipeJoueur(this);
            nbJoueur++;
        }
    }

    /*METHODES*/

    public void tourner()
    {
        if(nbJoueur>1) {
            var tmp = getJoueurEsku();
            setJoueurEsku(getJoueurZaku());
            setJoueurZaku(tmp);
        }
    }

    public Joueur getJoueurEsku()
    {
        return joueursEquipe.get(0);
    }

    public Joueur getJoueurZaku()
    {
        return joueursEquipe.get(nbJoueur-1);
    }

    public String nomEquipe()
    {
        return this.nomEquipe;
    }

    public void setJoueurEsku(Joueur joueur)
    {
         joueursEquipe.set(0,joueur);
    }

    public void setJoueurZaku(Joueur joueur)
    {
        joueursEquipe.set(nbJoueur-1, joueur);
    }

    public Joueur getJoueurIdentifiant(int i)
    {
        return(joueursEquipe.get(i));
    }

    public int getNbjoueur()
    {
        return nbJoueur;
    }
}