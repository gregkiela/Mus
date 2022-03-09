package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Participants {
  private List<Joueur> dansLOrdreJoueur;

  public Participants(List<Joueur> dansLOrdreJoueur) {
    this.dansLOrdreJoueur = dansLOrdreJoueur;
  }

  public boolean aucun() {
    return dansLOrdreJoueur.isEmpty();
  }

  public boolean estUnique() {
    return dansLOrdreJoueur.size() == 1;
  }

  public Joueur premier() {
    return dansLOrdreJoueur.get(0);
  }

  public Joueur adversaireDe(Joueur joueurParlant) {
    return joueurParlant == premier() ? dansLOrdreJoueur.get(1) : premier();
  }

  public Iterable<Joueur> dansLOrdreJoueur() {
    return dansLOrdreJoueur;
  }

  public Participants retirer(Joueur joueur) {
    var joueurs = new ArrayList<>(dansLOrdreJoueur);
    joueurs.remove(joueur);
    return new Participants(joueurs);
  }
}
