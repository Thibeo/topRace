package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PositionPariDao;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.PartieCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionPariDaoImpl implements PositionPariDao {




    /**
     * recupere dans la table positionPari les positions des voitures:
     * @param idPartie
     * @param numeroPari
     * @return une liste ([couleur,x,'y'],[couleur2,x2,'y2'],etc..)
     */
    public List getPositionPari(int idPartie, int numeroPari){
        String query = "SELECT * FROM positionpari WHERE idPartie=? AND numeroPari=? ORDER BY x,y";
        List listPosition = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            statement.setInt(2, numeroPari);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    List listCouleur=new ArrayList();
                    listCouleur.add(resultSet.getString("couleurV"));
                    listCouleur.add(resultSet.getInt("x"));
                    listCouleur.add(resultSet.getString("y").charAt(0));
                    listPosition.add(listCouleur);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPosition;
    }


    /**
     * rempli la table positionPari avec les emplacements des voitures au moment d'un franchissement de ligne jaune
     * @param numeroPari
     * @param idPartie
     */

    public void nouvellePositionPari(int numeroPari,int idPartie,String couleur,int x,String y){
        String query = "INSERT INTO positionpari(idPartie,couleurV,numeroPari,x,y) VALUES(?,?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,idPartie);
            statement.setString(2,couleur);
            statement.setInt(3,numeroPari);
            statement.setInt(4,x);
            statement.setString(5,y);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error214");
        }
    }


}
