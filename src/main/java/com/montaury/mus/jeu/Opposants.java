package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Opposants {
  /*private Joueur joueurEsku;
  private Joueur joueurZaku;*/

  private Equipe equipeEsku;
  private Equipe equipeZaku;

  public Opposants(Joueur joueurEsku, Joueur joueurZaku) {
    this.equipeEsku =new Equipe(List.of(joueurEsku),"Equipe1");
    this.equipeZaku =new Equipe(List.of(joueurZaku),"Equipe2");
  }

  public Opposants(Equipe equipeEsku, Equipe equipeZaku)
  {
    this.equipeEsku=equipeEsku;
    this.equipeZaku=equipeZaku;
  }

  /*public void tourner() {
    var tmp = joueurEsku;
    joueurEsku = joueurZaku;
    joueurZaku = tmp;
  }*/


  public void tourner()
  {
    var tmp = equipeEsku;
    equipeEsku=equipeZaku;
    equipeZaku= tmp;
    equipeZaku.tourner();
  }


  /*public Joueur joueurEsku() {
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public List<Joueur> dansLOrdre() {
    return List.of(joueurEsku, joueurZaku);
  }*/


  public Joueur joueurEskuEquipeEsku()
  {
    return equipeEsku.getJoueurEsku();
  }
  public Joueur joueurZakuEquipeEsku()
  {
    return equipeEsku.getJoueurZaku();
  }

  public Joueur joueurEskuEquipeZaku()
  {
    return equipeZaku.getJoueurEsku();
  }
  public Joueur joueurZakuEquipeZaku()
  {
    return equipeZaku.getJoueurZaku();
  }

  public Joueur joueurEsku()
  {
    return joueurEskuEquipeEsku();
  }

  public Joueur joueurZaku()
  {
    return joueurZakuEquipeZaku();
  }

  public Equipe getEquipeEsku() {
    return equipeEsku;
  }

  public Equipe getEquipeZaku() {
    return equipeZaku;
  }

  public List<Joueur> dansLOrdreJoueur()
  {
     List<Joueur> ListeJoueur= new ArrayList<>();
    for(var i=0;i< equipeEsku.getNbjoueur();i++)
    {
      ListeJoueur.add(equipeEsku.getJoueurIdentifiant(i));
      ListeJoueur.add(equipeZaku.getJoueurIdentifiant(i));
    }

    return ListeJoueur;
  }

  public List<Equipe> dansLOrdreEquipe()
  {
    return List.of(getEquipeEsku(),getEquipeZaku());
  }

}
