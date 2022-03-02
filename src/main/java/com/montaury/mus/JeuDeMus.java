package com.montaury.mus;

import com.montaury.mus.jeu.Partie;
import com.montaury.mus.console.AffichageEvenements;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.Opposants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class du jeu Mus
public class JeuDeMus {
  public static void main(String[] args) {
    System.out.print("Entrez votre nom: ");
    var nomJoueur = new Scanner(System.in).next();
    var joueurHumain = Joueur.humain(nomJoueur);

    var listeEquipe1 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurHumain);
    listeEquipe1.add(Joueur.ordinateur());

    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe2.add(Joueur.ordinateur());
    listeEquipe2.add(Joueur.ordinateur());

    var Equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var Equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var partie = new Partie(new AffichageEvenements(joueurHumain));
    var resultat = partie.jouer(new Opposants(Equipe1,Equipe2));

    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}
//test
//test2
