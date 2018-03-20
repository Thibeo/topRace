package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.JoueurDao;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.entities.PartieCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoueurDaoImpl implements JoueurDao {

    @Override
    public Joueur getJoueurByCase(String couleur, int idPartie, PartieCase cse){
        String query = "SELECT * FROM joueur WHERE couleurJ=? and idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, couleur);
            statement.setInt(2, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Joueur(resultSet.getString("couleurJ"),
                                      resultSet.getString("nomDeJoueur"),
                                      cse,
                                      resultSet.getInt("idPartie"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getXYByCouleur(String couleur, int idPartie){
        String query = "SELECT * FROM joueur WHERE couleurJ=? and idPartie=?";
        List<String> list = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, couleur);
            statement.setInt(2, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    list.add(String.valueOf(resultSet.getInt("x")));
                    list.add(resultSet.getString("y"));
                    return list;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changerCase(Joueur joueur, PartieCase cse){
        String query1 = "UPDATE joueur SET x = ?, y = ? WHERE couleurJ = ? AND idPartie = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query1)) {
            statement.setInt(1, cse.getX());
            statement.setString(2, String.valueOf(cse.getY()));
            statement.setString(3, joueur.getCouleur());
            statement.setInt(4, joueur.getIdPartie());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void createJoueur(Joueur joueur){
        String query = "INSERT INTO joueur(couleurJ,nomDeJoueur,idPartie,x,y) VALUES(?,?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,joueur.getCouleur());
            statement.setString(2,joueur.getNomJoueur());
            statement.setInt(3,joueur.getIdPartie());
            statement.setInt(4,joueur.getCaseActuelle().getX());
            statement.setString(5,String.valueOf(joueur.getCaseActuelle().getY()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
