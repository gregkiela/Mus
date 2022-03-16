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
    var choixDuModeDeJeu ="";
    //On récupère le choix du joueur pour le mode de jeu
    while(!choixDuModeDeJeu.equals("1v1") && !choixDuModeDeJeu.equals("2v2"))
    {
      System.out.print("Choisissez votre mode de jeu entre: 1v1 | 2v2 ");
      choixDuModeDeJeu = new Scanner(System.in).next();
    }
    
    System.out.print("Entrez votre nom: ");

    //Création du joueur
    var nomJoueur = new Scanner(System.in).next();
    var joueurHumain = Joueur.humain(nomJoueur);

    //Ajout des joueurs dans leur liste
    var listeEquipe1 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurHumain);
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe2.add(Joueur.ordinateur("AdversaireNuméroUn"));

    //Ajustement en fonction du mode de jeu choisi
    if(choixDuModeDeJeu.equals("2v2")) {
      listeEquipe1.add(Joueur.ordinateur("Coéquipier"));
      listeEquipe2.add(Joueur.ordinateur("AdversaireNuméroDeux"));
    }

    //Création des équipes à partir des listes précedemment créées
    var Equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var Equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    //lancement de la partie
    var partie = new Partie(new AffichageEvenements(joueurHumain));
    var resultat = partie.jouer(new Opposants(Equipe1,Equipe2));

    //Affichage du résultat
    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().getJoueurEsku().nom());
  }
}
