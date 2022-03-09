package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Main;
import com.montaury.mus.jeu.joueur.Equipe;

public class Paires extends Phase {
  public Paires() {
    super("Paires");
  }

  @Override
  protected boolean peutParticiper(Main main) {
    return main.aDesPaires();
  }

  @Override
  protected boolean mainEskuEstMeilleure(Main mainJoueurEsku, Main mainJoueurZaku) {
    var pairesJoueurEsku = mainJoueurEsku.getPaires();
    var pairesJoueurZaku = mainJoueurZaku.getPaires();
    return pairesJoueurEsku.estMeilleureOuEgaleA(pairesJoueurZaku);
  }

  @Override
  public int pointsBonus(Equipe vainqueur) {
    return vainqueur.getJoueurEsku().main().getPaires().pointsBonus();
  }
}
