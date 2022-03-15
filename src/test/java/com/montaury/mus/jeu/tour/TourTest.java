package com.montaury.mus.jeu.tour;

import com.montaury.mus.jeu.Manche;
import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.carte.Carte;
import com.montaury.mus.jeu.carte.Defausse;
import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Gehiago;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Hordago;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Idoki;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Imido;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Kanta;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Mintza;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Paso;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Tira;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.montaury.mus.jeu.carte.Fixtures.paquetAvec;
import static com.montaury.mus.jeu.carte.Fixtures.paquetEntierCroissant;
import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class TourTest {

  @BeforeEach
  void setUp() {
    evenementsDeJeu = mock(Evenements.class);
    tour = new Tour(evenementsDeJeu, paquetEntierCroissant(), new Defausse());
  }

  @Test
  void devrait_donner_tous_les_points_au_joueur_esku_si_le_joueur_zaku_fait_tira() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Imido(), new Imido(), new Imido());
    var joueurZaku = unJoueurFaisantChoix(new Tira());

    var listeEquipe1 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurEsku);
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).isEmpty();
    assertThat(score.scoreParEquipe()).containsEntry(equipe1, 8);
    assertThat(score.scoreParEquipe()).containsEntry(equipe2, 0);
  }

  /*@Test
  void devrait_repartir_les_points_si_tout_est_paso() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Paso(), new Paso(), new Paso(), new Paso());
    var listeEquipe = new ArrayList<Joueur>();
    listeEquipe.add(joueurEsku);
    var joueurZaku = unJoueurFaisantChoix(new Paso());
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).isEmpty();
    assertThat(score.scoreParEquipe()).containsEntry(equipe1, 1);
    assertThat(score.scoreParEquipe()).containsEntry(equipe2, 5);
  }*/

  @Test
  void devrait_faire_gagner_le_joueur_zaku_si_hordago_au_grand() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());

    var listeEquipe1 = new ArrayList<Joueur>();
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurEsku);
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).contains(joueurZaku.getEquipeJoueur());
    assertThat(score.scoreParEquipe()).containsEntry(joueurEsku.getEquipeJoueur(), 0);
    assertThat(score.scoreParEquipe()).containsEntry(joueurZaku.getEquipeJoueur(), 40);
  }

  @Test
  void devrait_partager_les_points_si_tout_est_idoki() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Imido(), new Imido(), new Imido());
    var joueurZaku = unJoueurFaisantChoix(new Idoki());
    var listeEquipe1 = new ArrayList<Joueur>();
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurEsku);
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).isEmpty();
    assertThat(score.scoreParEquipe()).containsEntry(joueurEsku.getEquipeJoueur(), 2);
    assertThat(score.scoreParEquipe()).containsEntry(joueurZaku.getEquipeJoueur(), 10);
  }

  @Test
  void devrait_partager_les_points_si_tout_est_gehiago_puis_idoki() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Idoki(), new Imido(), new Idoki(), new Imido(), new Idoki(), new Imido(), new Idoki());
    var joueurZaku = unJoueurFaisantChoix(new Gehiago(2));

    var listeEquipe1 = new ArrayList<Joueur>();
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurEsku);
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).isEmpty();
    assertThat(score.scoreParEquipe()).containsEntry(joueurEsku.getEquipeJoueur(), 4);
    assertThat(score.scoreParEquipe()).containsEntry(joueurZaku.getEquipeJoueur(), 16);
  }

  @Test
  void devrait_privilegier_le_joueur_esku_si_les_mains_sont_identiques() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Imido(), new Imido(), new Imido());
    var joueurZaku = unJoueurFaisantChoix(new Idoki());

    var listeEquipe1 = new ArrayList<Joueur>();
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurEsku);
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    Tour tour = new Tour(evenementsDeJeu, paquetAvec(Carte.AS_BATON, Carte.DEUX_BATON, Carte.TROIS_BATON, Carte.QUATRE_BATON, Carte.AS_COUPE, Carte.DEUX_COUPE, Carte.TROIS_COUPE, Carte.QUATRE_COUPE), new Defausse());

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).isEmpty();
    assertThat(score.scoreParEquipe()).containsEntry(joueurEsku.getEquipeJoueur(), 7);
    assertThat(score.scoreParEquipe()).containsEntry(joueurZaku.getEquipeJoueur(), 0);
  }

  @Test
  void devrait_attribuer_les_bonus_au_joueur_ayant_la_meilleure_main_pour_chaque_phase() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Paso(), new Paso());
    var joueurZaku = unJoueurFaisantChoix(new Paso(), new Paso());

    var listeEquipe1 = new ArrayList<Joueur>();
    var listeEquipe2 = new ArrayList<Joueur>();
    listeEquipe1.add(joueurEsku);
    listeEquipe2.add(joueurZaku);

    var equipe1 =  new Equipe(listeEquipe1,"Equipe joueur");
    var equipe2 =  new Equipe(listeEquipe2, "Equipe Ordinateur");

    var opposants = new Opposants(equipe1, equipe2);
    var score = new Manche.Score(opposants);

    Tour tour = new Tour(evenementsDeJeu, paquetAvec(Carte.ROI_BATON, Carte.ROI_COUPE, Carte.VALET_BATON, Carte.AS_EPEE, Carte.DEUX_COUPE, Carte.TROIS_COUPE, Carte.QUATRE_COUPE, Carte.CINQ_COUPE), new Defausse());

    tour.jouer(opposants, score);

    assertThat(score.vainqueur()).isEmpty();
    assertThat(score.scoreParEquipe()).containsEntry(joueurEsku.getEquipeJoueur(), 6);
    assertThat(score.scoreParEquipe()).containsEntry(joueurZaku.getEquipeJoueur(), 0);
  }

  private Evenements evenementsDeJeu;
  private Tour tour;
}
