package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.Iterator;
import java.util.List;

public class Opposants {
  /*private Joueur joueurEsku;
  private Joueur joueurZaku;*/

  private Equipe equipeEsku;
  private Equipe equipeZaku;

  public Opposants(Joueur joueurEsku, Joueur joueurZaku) {
    Equipe equipe1 =new Equipe(List.of(joueurEsku),"Equipe1");
    Equipe equipe2 =new Equipe(List.of(joueurZaku),"Equipe2");
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
    equipeEsku.tourner();
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


  public Joueur joueurEskuEquipeEzku()
  {
    return equipeEsku.getJoueurEsku();
  }
  public Joueur joueurZakuEquipeEzku()
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

  public Joueur joueurZaku()
  {
    return equipeZaku.getJoueurZaku();
  }

  public Equipe getEquipeEsku() {
    return equipeEsku;
  }

  public Equipe getEquipeZaku() {
    return equipeZaku;
  }

  public List<Joueur> dansLOrdre()
  {
    return List.of(equipeEsku.getJoueurEsku(),equipeZaku.getJoueurEsku(),equipeEsku.getJoueurZaku(),equipeZaku.getJoueurZaku());
  }

}
