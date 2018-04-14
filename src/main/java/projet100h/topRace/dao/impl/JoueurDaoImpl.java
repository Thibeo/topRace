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

    /**
     *
     * @param couleur
     * @param idPartie
     * @param cse
     * @return un joueur d'après la postion de sa voiture sur le plateau
     */
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
                                      resultSet.getString("derniereAction"),
                                      resultSet.getInt("score"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error208");
        }
        return null;
    }

    /**
     *
     * @param couleur
     * @param idPartie
     * @return la position d'une voiture d'après sa couleur
     */
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
            System.out.println("");
            System.out.println("error209");
        }
        return null;
    }

    /**
     * permet de changer le statut d'une case dans la base de données
     * @param joueur
     * @param cse
     */
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
            System.out.println("");
            System.out.println("error210");
        }
    }

    /**
     * permet de modifier la derniere action d'un joueur
     * @param idPartie
     * @param couleurJ
     * @param action
     */
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
            System.out.println("");
            System.out.println("error211");
        }
    }

    /**
     * permet de savoir lorsqu'une action est finie par tous les joueurs
     * @param idPartie
     * @param action
     * @return
     */
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
            System.out.println("");
            System.out.println("error212");
        }
        if (list.size()==6){
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param idPartie
     * @param couleurJ
     * @return la derniere action d'un joueur
     */
    @Override
    public String getDerniereAction(int idPartie, String couleurJ){
        String query = "SELECT * FROM joueur WHERE idPartie=? AND couleurJ=?";
        List list = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            statement.setString(2, couleurJ);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return (resultSet.getString("derniereAction"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error213");
        }
        return null;
    }

    /**
     * permet de creer un joueur
     * @param joueur
     */
    public void createJoueur(Joueur joueur){
        String query = "INSERT INTO joueur(couleurJ,nomDeJoueur,idPartie,x,y,derniereAction,score) VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,joueur.getCouleur());
            statement.setString(2,joueur.getNomJoueur());
            statement.setInt(3,joueur.getIdPartie());
            statement.setInt(4,joueur.getCaseActuelle().getX());
            statement.setString(5,String.valueOf(joueur.getCaseActuelle().getY()));
            statement.setString(6,joueur.getDerniereAction());
            statement.setInt(7,joueur.getScore());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error214");
        }
    }


    /**
     *
     * @param idPartie
     * @return la liste des joueurs d'une partie
     */
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
                            resultSet.getString("derniereAction"),
                            resultSet.getInt("score")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error215");
        }
        return list;
    }

    /**
     *
     * @param couleur
     * @param idPartie
     * @return le score d'un joueur
     */
    public int getScoreJoueur(String couleur, int idPartie){
        String query = "SELECT score FROM joueur WHERE couleurJ=? and idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, couleur);
            statement.setInt(2, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return (resultSet.getInt("score"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * permet de mettre à jour le score d'un joueur
     * @param couleurJoueur
     * @param resultatJoueur
     */
    public void updateScoreJoueur(String couleurJoueur,int resultatJoueur){
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE joueur SET score=? WHERE couleur=?") ) {
            statement.setInt(1,resultatJoueur);
            statement.setString(2,couleurJoueur);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * permet de supprimer un joueur
     * @param couleurJ
     * @param idPartie
     */
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
            System.out.println("");
            System.out.println("error216");
        }
        if (couleurJ.equals(couleurProprio) || couleurJ==couleurProprio){ // si le joueur est le propriétaire
            String query2 = "DELETE FROM `partie`  WHERE idPartie=?"; // on supprime la partie
            try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query2)) {
                statement.setInt(1, idPartie);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("");
                System.out.println("error217");
            }

            String query3 = "DELETE FROM `joueur`  WHERE idPartie=?"; // et tous les joueurs
            try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query3)) {
                statement.setInt(1, idPartie);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("");
                System.out.println("error218");
            }

        } else {
            String query3 = "DELETE FROM `joueur`  WHERE couleurJ=?"; // sinon on supprime que le joueur
            try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query3)) {
                statement.setString(1, couleurJ);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("");
                System.out.println("error219");
            }
        }

    }

    /**
     *
     * @param idPartie
     * @return la liste des postions des joueurs à un instant t
     */

    public List listOfPosition(int idPartie){
        String query = "SELECT (x,y,couleurJ)  FROM joueur WHERE idPartie=? ORDER BY x DESC";
        PartieCase partieCse = null;
        List list = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    List couleurPosition = new ArrayList<>();
                    couleurPosition.add(resultSet.getString("couleurJ"));
                    couleurPosition.add(resultSet.getInt("x"));
                    couleurPosition.add(resultSet.getString("y"));
                    list.add(couleurPosition);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error215");
        }
        return list;
    }


}
