package projet100h.topRace.dao.impl;

import jdk.nashorn.internal.scripts.JO;
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
                                      resultSet.getInt("idPartie"),
                                      resultSet.getString("derniereAction"));
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

    @Override
    public void changerDernierAction(int idPartie, String couleurJ, String action){
        String query1 = "UPDATE joueur SET derniereAction = ? WHERE couleurJ = ? AND idPartie = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query1)) {
            statement.setString(1, action);
            statement.setString(2, couleurJ);
            statement.setInt(3, idPartie);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean actionFinieParTousJoueurs(int idPartie, String action){
        String query = "SELECT * FROM joueur WHERE idPartie=? AND derniereAction=?";
        List list = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            statement.setString(2, action);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(resultSet.getString("couleurJ"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.size()==6){
            return true;
        } else {
            return false;
        }

    }

    public void createJoueur(Joueur joueur){
        String query = "INSERT INTO joueur(couleurJ,nomDeJoueur,idPartie,x,y,derniereAction) VALUES(?,?,?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,joueur.getCouleur());
            statement.setString(2,joueur.getNomJoueur());
            statement.setInt(3,joueur.getIdPartie());
            statement.setInt(4,joueur.getCaseActuelle().getX());
            statement.setString(5,String.valueOf(joueur.getCaseActuelle().getY()));
            statement.setString(6,joueur.getDerniereAction());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List listOfJoueur(int idPartie){
        String query = "SELECT * FROM joueur WHERE idPartie=? ORDER BY couleurJ DESC";
        PartieCase partieCse = null;
        List<Joueur> list = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                        new Joueur(
                            resultSet.getString("couleurJ"),
                            resultSet.getString("nomDeJoueur"),
                            partieCse,
                            resultSet.getInt("idPartie"),
                            resultSet.getString("derniereAction")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void deleteJoueur (String couleurJ, int idPartie){
        String query = "SELECT * FROM `partie`  WHERE idPartie=?";
        String couleurProprio="";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    couleurProprio = resultSet.getString("couleurDeProprio");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (couleurJ.equals(couleurProprio) || couleurJ==couleurProprio){ // si le joueur est le propriétaire
            String query2 = "DELETE FROM `partie`  WHERE idPartie=?"; // on supprime la partie
            try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query2)) {
                statement.setInt(1, idPartie);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            String query3 = "DELETE FROM `joueur`  WHERE idPartie=?"; // et tous les joueurs
            try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query3)) {
                statement.setInt(1, idPartie);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String query3 = "DELETE FROM `joueur`  WHERE couleurJ=?"; // sinon on supprime que le joueur
            try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query3)) {
                statement.setString(1, couleurJ);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
