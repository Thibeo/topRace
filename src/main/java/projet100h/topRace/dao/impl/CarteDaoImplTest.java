package projet100h.topRace.dao.impl;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.Test;
import projet100h.topRace.entities.Carte;
import projet100h.topRace.managers.GameLibrary;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarteDaoImplTest {

    private CarteDaoImpl carteDao = new CarteDaoImpl();

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
    public void listCarte() throws Exception {
        List<Carte> carteList = GameLibrary.getInstance().listCarte();

        assertThat(carteList).hasSize(3);
        assertThat(carteList.get(0).getIdCarte()).isEqualTo(1);
        assertThat(carteList.get(1).getIdCarte()).isEqualTo(2);
        assertThat(carteList.get(2).getIdCarte()).isEqualTo(3);



    }

    @Test
    public void listDeplacementCarte() throws Exception {
        List cartedeplacement=GameLibrary.getInstance().listDeplacementCarte(3);
        assertThat(cartedeplacement).hasSize(2);
        AssertionsForClassTypes.assertThat(((List) cartedeplacement.get(0)).get(0)).isEqualTo(5);
        AssertionsForClassTypes.assertThat(((List) cartedeplacement.get(0)).get(1)).isEqualTo("Jaune");
        AssertionsForClassTypes.assertThat(((List) cartedeplacement.get(1)).get(0)).isEqualTo(2);
        AssertionsForClassTypes.assertThat(((List) cartedeplacement.get(1)).get(1)).isEqualTo("Violet");

    }



}
