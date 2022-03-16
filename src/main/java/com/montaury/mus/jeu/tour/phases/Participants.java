package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Participants {
  private List<Joueur> dansLOrdreJoueur;

  public Participants(List<Joueur> dansLOrdreJoueur)
  {
    this.dansLOrdreJoueur = dansLOrdreJoueur;
  }

  public boolean aucun()
  {
    return dansLOrdreJoueur.isEmpty();
  }

  public boolean estUnique()
  {
    return dansLOrdreJoueur.size() == 1;
  }

  public Joueur premier()
  {
    return dansLOrdreJoueur.get(0);
  }

  public Joueur adversaireDe(Joueur joueurParlant)
  {
    var indiceJoueurParlant = 0;
    var nombreIndicesPossibles = dansLOrdreJoueur.size()-1;

    for(var i=0 ; i<=nombreIndicesPossibles ; i++)
    {
      if(dansLOrdreJoueur.get(i)==joueurParlant)
      {
        indiceJoueurParlant=i;
      }
    }

    var indiceFuturAdversaireJoueurParlant=indiceJoueurParlant;

    if(joueurParlant.getEquipeJoueur().getNbjoueur()>1)
    {
      var equipeJoueurParlant = dansLOrdreJoueur.get(indiceJoueurParlant).getEquipeJoueur();
      while (dansLOrdreJoueur.get(indiceFuturAdversaireJoueurParlant).getEquipeJoueur() == equipeJoueurParlant)
      {
        indiceFuturAdversaireJoueurParlant++;

        if (indiceFuturAdversaireJoueurParlant > nombreIndicesPossibles)
        {
          indiceFuturAdversaireJoueurParlant = 0;
        }
      }
      return dansLOrdreJoueur.get(indiceFuturAdversaireJoueurParlant);
    }
    else
    {
      return indiceJoueurParlant==0 ? (dansLOrdreJoueur.get(1)) : (dansLOrdreJoueur.get(0));
    }
  }

  public Iterable<Joueur> dansLOrdreJoueur()
  {
    return dansLOrdreJoueur;
  }

  public Participants retirer(Joueur joueur)
  {
    var joueurs = new ArrayList<>(dansLOrdreJoueur);
    joueurs.remove(joueur);
    return new Participants(joueurs);
  }
}
