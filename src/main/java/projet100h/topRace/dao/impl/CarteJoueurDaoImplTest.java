package projet100h.topRace.dao.impl;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import projet100h.topRace.entities.Carte;
import projet100h.topRace.entities.CarteJoueur;
import projet100h.topRace.managers.GameLibrary;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarteJoueurDaoImplTest {

    private CarteDaoImpl carteDao = new CarteDaoImpl();
    private CarteJoueurDaoImpl carteJoueur= new CarteJoueurDaoImpl();

    @Before
    public void initDb() throws Exception {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM joueur;");
            stmt.executeUpdate("DELETE FROM pari;");
            stmt.executeUpdate("DELETE FROM partie;");
            stmt.executeUpdate("DELETE FROM carte;");
            stmt.executeUpdate("DELETE FROM nbcase;");
            stmt.executeUpdate("DELETE FROM typeVoiture;");
            stmt.executeUpdate("DELETE FROM cartejoueur;");
            //creation de joueurs
            stmt.executeUpdate("INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ('Jaune','BobJaune', 1, 1, 'a','pari2Effectue',0);");
            stmt.executeUpdate("INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ('Vert', 'BobVert', 1, 1, 'b','pari2Effectue',0);");
            stmt.executeUpdate("INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ('Violet', 'BobViolet', 1, 1, 'c','pari2Effectue',0);");
            stmt.executeUpdate("INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ('Rouge', 'BobRouge', 1, 0, 'c','pari2Effectue',0);");
            stmt.executeUpdate("INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ('Blanc', 'BobBlanc', 1, 0, 'b','pari2Effectue',0);");

            //creation de cartes
            stmt.executeUpdate("INSERT INTO `partie` (`idPartie`, `nomDePartie`, `couleurDeProprio`, `etatActuel`, `etatAncien`) VALUES (1, 'partie1test', 'Bleu','attente','rien');");
            stmt.executeUpdate("INSERT INTO `partie` (`idPartie`, `nomDePartie`, `couleurDeProprio`, `etatActuel`, `etatAncien`) VALUES (2, 'partie2test', 'Bleu','attente','rien');");


            //initialisation des cartes
            stmt.executeUpdate("INSERT INTO `carte` (`idCarte`) VALUES (1), (2), (3);");
            stmt.executeUpdate("INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ('Jaune',1,10),('Rouge',1,10),('Violet',1,10),('Bleu',1,10),('Vert',1,10),('Blanc',1,10);");
            stmt.executeUpdate("INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ('Bleu',2,6),('Blanc',2,4),('Vert',2,2),('Rouge',2,1);");
            stmt.executeUpdate("INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ('Jaune',3,5),('Violet',3,2);");

            //initialisation des cartes des joueurs
            stmt.executeUpdate("INSERT INTO `cartejoueur` (`idPartie`,`couleurJ`,`idCarte`,`utilisee`) VALUES (1,'Jaune',1,0), (1,'Jaune',2,0);");


            //les voitures
            stmt.executeUpdate("INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ('Jaune',1,'a');");
            stmt.executeUpdate("INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ('Rouge',0,'c');");
            stmt.executeUpdate("INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ('Violet',1,'c');");
            stmt.executeUpdate("INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ('Bleu',0,'a');");
            stmt.executeUpdate("INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ('Vert',1,'b');");
            stmt.executeUpdate("INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ('Blanc',0,'b');");
        }
    }

    @Test
    public void testCreateCarteJoueur() {
        CarteJoueur carte=new CarteJoueur(3,1,"Violet",false);
        carteJoueur.createCarteJoueur(carte);
        List<CarteJoueur> carteList = GameLibrary.getInstance().getCarteJoueur(1,"Violet");

        assertThat(carteList).hasSize(1);
        assertThat(carteList).extracting("idCarte", "idPartie", "CouleurJ", "utilisee").containsOnly(
                tuple(3, 1, "Violet",false)

        );

    }

    @Test
    public void testUtilisation(){
        GameLibrary.getInstance().utilisation(2,1,"Jaune");
        List<CarteJoueur> carteList = GameLibrary.getInstance().getCarteJoueur(1,"Jaune");

        assertThat(carteList).hasSize(1);
        assertThat(carteList).extracting("idCarte", "idPartie", "CouleurJ", "utilisee").containsOnly(
                tuple(1, 1, "Jaune",false)

        );

    }
    @Test
    public void testGetCarteJoueur(){
        List<CarteJoueur> carteList = GameLibrary.getInstance().getCarteJoueur(1,"Jaune");

        assertThat(carteList).hasSize(2);
        assertThat(carteList).extracting("idCarte", "idPartie", "CouleurJ", "utilisee").containsOnly(
                tuple(1, 1, "Jaune",false),
                tuple(2, 1, "Jaune",false)
                );


    }

}