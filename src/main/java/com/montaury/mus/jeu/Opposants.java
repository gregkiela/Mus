package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.Iterator;
import java.util.List;

public class Opposants {
  private Joueur joueurEsku;
  private Joueur joueurZaku;

/*
  private Equipe equipeEsku;
  private Equipe equipeZaku;
 */

  public Opposants(Joueur joueurEsku, Joueur joueurZaku) {
    this.joueurEsku = joueurEsku;
    this.joueurZaku = joueurZaku;
  }

  /*
  public Opposants(Equipe equipeEsku, Equipe equipeZaku)
  {
    this.equipeEsku=equipeEsku;
    this.equipeZaku=equipeZaku;
  }
   */
  public void tourner() {
    var tmp = joueurEsku;
    joueurEsku = joueurZaku;
    joueurZaku = tmp;
  }

  /*
  public void tournerEquipe()
  {
    var tmp = equipeEsku;
    equipeEsku=equipeZaku;
    equipeZaku= tmp;

    equipeZaku.tourner();
  }
   */

  public Joueur joueurEsku() {
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public List<Joueur> dansLOrdre() {
    return List.of(joueurEsku, joueurZaku);
  }

  /*
  public Joueur joueurEsku()
  {
    return equipeEsku.joueurEsku();
  }
   */

  /*
  public Joueur joueurZaku()
  {
    return equipeZaku.joueurZaku();
  }
   */


  /*
  public List<Joueur> dansLOrdreEquipe()
  {
    return Liste.of(equipeEsku.joueurEsku(),equipeZaku.joueurEsku(),equipeEsku.joueurZaku(),equipeZaku.joueurZaku());
  }
   */
}
