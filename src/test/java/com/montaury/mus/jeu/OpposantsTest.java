package com.montaury.mus.jeu;


import com.montaury.mus.console.InterfaceJoueurHumain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.montaury.mus.jeu.evenements.Evenements;

import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.montaury.mus.jeu.Partie;
import com.montaury.mus.console.AffichageEvenements;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.Opposants;

import java.util.ArrayList;

class OpposantsTest {
    @BeforeEach

    @Test
    void equipe_devraient_tourner_correctement()
    {
        Joueur joueur1= Joueur.humain("J1");
        Joueur joueur2= Joueur.humain("J2");
        Joueur joueur3= Joueur.humain("J3");
        Joueur joueur4= Joueur.humain("J4");

        var listeEquipe1 = new ArrayList<Joueur>();
        listeEquipe1.add(joueur1);
        listeEquipe1.add(joueur2);

        var listeEquipe2 = new ArrayList<Joueur>();
        listeEquipe1.add(joueur3);
        listeEquipe1.add(joueur4);

        var Equipe1 =  new Equipe(listeEquipe1,"Equipe numero 1");
        var Equipe2 =  new Equipe(listeEquipe2,"Equipe numero 2");

        Opposants opposants = new Opposants(Equipe1,Equipe2);

        assertThat(opposants.getEquipeEsku()).isEqualTo(Equipe1);
        assertThat(opposants.getEquipeZaku()).isEqualTo(Equipe2);

        opposants.tourner();

        assertThat(opposants.getEquipeEsku()).isEqualTo(Equipe2);
        assertThat(opposants.getEquipeZaku()).isEqualTo(Equipe1);

        opposants.tourner();

        assertThat(opposants.getEquipeEsku()).isEqualTo(Equipe1);
        assertThat(opposants.getEquipeZaku()).isEqualTo(Equipe2);

        opposants.tourner();

        assertThat(opposants.getEquipeEsku()).isEqualTo(Equipe2);
        assertThat(opposants.getEquipeZaku()).isEqualTo(Equipe1);

        opposants.tourner();

        assertThat(opposants.getEquipeEsku()).isEqualTo(Equipe1);
        assertThat(opposants.getEquipeZaku()).isEqualTo(Equipe2);
    }

    @Test
    void joueurs_devraient_tourner_correctement()
    {
        Joueur joueur1 = Joueur.humain("J1");
        Joueur joueur2 = Joueur.humain("J2");
        Joueur joueur3 = Joueur.humain("J3");
        Joueur joueur4 = Joueur.humain("J4");

        var listeEquipe1 = new ArrayList<Joueur>();
        listeEquipe1.add(joueur1);
        listeEquipe1.add(joueur2);

        var listeEquipe2 = new ArrayList<Joueur>();
        listeEquipe1.add(joueur3);
        listeEquipe1.add(joueur4);

        var Equipe1 = new Equipe(listeEquipe1, "Equipe numero 1");
        var Equipe2 = new Equipe(listeEquipe2, "Equipe numero 2");

        Opposants opposants = new Opposants(Equipe1, Equipe2);

        assertThat(opposants.joueurEskuEquipeEsku()).isEqualTo(joueur1);
        assertThat(opposants.joueurEskuEquipeZaku()).isEqualTo(joueur3);
        assertThat(opposants.joueurZakuEquipeEsku()).isEqualTo(joueur2);
        assertThat(opposants.joueurZakuEquipeZaku()).isEqualTo(joueur4);

        opposants.tourner();

        assertThat(opposants.joueurEskuEquipeEsku()).isEqualTo(joueur3);
        assertThat(opposants.joueurEskuEquipeZaku()).isEqualTo(joueur2);
        assertThat(opposants.joueurZakuEquipeEsku()).isEqualTo(joueur4);
        assertThat(opposants.joueurZakuEquipeZaku()).isEqualTo(joueur1);

        opposants.tourner();

        assertThat(opposants.joueurEskuEquipeEsku()).isEqualTo(joueur2);
        assertThat(opposants.joueurEskuEquipeZaku()).isEqualTo(joueur4);
        assertThat(opposants.joueurZakuEquipeEsku()).isEqualTo(joueur1);
        assertThat(opposants.joueurZakuEquipeZaku()).isEqualTo(joueur3);

        opposants.tourner();

        assertThat(opposants.joueurEskuEquipeEsku()).isEqualTo(joueur3);
        assertThat(opposants.joueurEskuEquipeZaku()).isEqualTo(joueur2);
        assertThat(opposants.joueurZakuEquipeEsku()).isEqualTo(joueur4);
        assertThat(opposants.joueurZakuEquipeZaku()).isEqualTo(joueur1);
        //CODE DE TRES BONNE QUALITE

        opposants.tourner();

        assertThat(opposants.joueurEskuEquipeEsku()).isEqualTo(joueur3);
        assertThat(opposants.joueurEskuEquipeZaku()).isEqualTo(joueur2);
        assertThat(opposants.joueurZakuEquipeEsku()).isEqualTo(joueur4);
        assertThat(opposants.joueurZakuEquipeZaku()).isEqualTo(joueur1);

    }

}
