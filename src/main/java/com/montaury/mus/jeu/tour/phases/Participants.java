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

    var i = 0;
    var indiceJoueur = 0;
    for(i=0;i< dansLOrdreJoueur.size();i++)
    {
      if(dansLOrdreJoueur.get(i)==joueurParlant)
      {
        indiceJoueur=i;
      }
    }
    var indiceFuturJoueur=indiceJoueur;

    while(dansLOrdreJoueur.get(indiceFuturJoueur).getEquipeJoueur()==dansLOrdreJoueur.get(indiceJoueur).getEquipeJoueur())
    {
      if(indiceFuturJoueur+1>=dansLOrdreJoueur.size())
      {
        indiceFuturJoueur=0;
      }
      else
      {
        indiceFuturJoueur++;
      }
    }
    return dansLOrdreJoueur.get(indiceFuturJoueur);
    /*
    if(joueurParlant == premier())
    {
      return dansLOrdreJoueur.get(1);
    }
    else if(joueurParlant == dansLOrdreJoueur.get(1))
    {
      return dansLOrdreJoueur.get(2);
    }
    else if(joueurParlant == dansLOrdreJoueur.get(2))
    {
      return dansLOrdreJoueur.get(3);
    }
    else
    {
      return dansLOrdreJoueur.get(0);
    }*/
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
