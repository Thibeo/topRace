package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.JoueurDao;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.Joueur;

import java.sql.*;

public class JoueurDaoImpl extends JoueurDao {

    @Override
    public Joueur DefinirJoueur(String couleur, int idPartie){
        String query = "SELECT * FROM joueur WHERE couleurJ=? and idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, couleur);
            statement.setInt(2, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Joueur(resultSet.getString("couleurJ"),
                                      resultSet.getString("nomDeJoueur"),
                                      new Case(resultSet.getInt("x"),
                                      resultSet.getInt("y")),
                            resultSet.getInt("idPartie"), );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
