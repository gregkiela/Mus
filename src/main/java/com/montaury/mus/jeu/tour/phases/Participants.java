package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Participants {
  private final List<Equipe> dansLOrdreEquipe;
  private List<Joueur> dansLOrdreJoueur;

  public Participants(List<Equipe> dansLOrdreEquipe) {
    this.dansLOrdreEquipe = dansLOrdreEquipe;
    faireListeJoueur(dansLOrdreEquipe);
  }

  public void faireListeJoueur(List<Equipe> dansLOrdreEquipe)
  {
    Opposants truc = new Opposants(dansLOrdreEquipe.get(0),dansLOrdreEquipe.get(1));
    this.dansLOrdreJoueur = truc.dansLOrdreJoueur();
  }

  public boolean aucun() {
    return dansLOrdreEquipe.isEmpty();
  }

  public boolean estUnique() {
    return dansLOrdreEquipe.size() == 1;
  }

  public Joueur premier() {
    return dansLOrdreJoueur.get(0);
  }

  public Joueur adversaireDe(Joueur joueurParlant) {
    return joueurParlant == premier() ? dansLOrdreJoueur.get(1) : premier();
  }

  public Iterable<Equipe> dansLOrdreEquipe() {
    return dansLOrdreEquipe;
  }
  public Iterable<Joueur> dansLOrdreJoueur() {
    return dansLOrdreJoueur;
  }

  public Participants retirer(Joueur joueur) {
    var equipes = new ArrayList<>(dansLOrdreEquipe);
    joueur.getEquipeJoueur().retirer(joueur);
    return new Participants(equipes);
  }
}
