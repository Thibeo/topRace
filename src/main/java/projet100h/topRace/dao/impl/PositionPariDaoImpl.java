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


    //recupere dans la table positionPari les positions des voitures:

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


}
