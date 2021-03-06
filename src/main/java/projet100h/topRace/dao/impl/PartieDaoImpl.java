package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PartieDao;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.entities.PartieCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartieDaoImpl implements PartieDao{

    /**
     *
     * @return la liste des parties existantes
     */
    @Override
    public List listPartie(){
        String query = "SELECT * FROM partie";
        List<Partie> listOfPartie = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                    listOfPartie.add(
                            new Partie(resultSet.getInt("idPartie"),
                                    resultSet.getString("nomDePartie"),
                                    resultSet.getString("couleurDeProprio"),
                                    resultSet.getString("etatActuel"),
                                    resultSet.getString("etatAncien"))
                    );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error231");
        }
        return listOfPartie;
    }

    /**
     *
     * @param idPartie
     * @return le nombre de joueurs déjà présents sur une partie
     */
    @Override
    public int nbDeJoueurIdPartie(int idPartie){
        String query = "SELECT * FROM joueur WHERE idPartie=?";
        int comp = 0;
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    comp ++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error232");
        }
        return comp;
    }

    /**
     *
     * @return la liste des joueurs d'une partie
     */
    @Override
    public List<Integer> nbDeJoueur(){
        String query = "SELECT * FROM joueur ORDER BY idPartie ASC";
        List<Integer> listOfNbJoueur = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                listOfNbJoueur.add(resultSet.getInt("idPartie"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error233");
        }
        return listOfNbJoueur;
    }

    /**
     *
     * @param partie
     * @return la partie créée
     */
    @Override
    public Partie createPartie(Partie partie){
        String query = "INSERT INTO partie(nomDePartie, couleurDeProprio, etatActuel, etatAncien) VALUES(?, ?, ?, ?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,partie.getNomDePartie());
            statement.setString(2,partie.getCouleurDeProprio());
            statement.setString(3,partie.getEtatActuel());
            statement.setString(4,partie.getEtatAncien());
            statement.executeUpdate();
            try (ResultSet ids = statement.getGeneratedKeys()) {
                if(ids.next()) {
                    int generatedId = ids.getInt(1);
                    partie.setIdPartie(generatedId);
                    return partie;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error234");
        }
        return null;
    }


    /**
     *
     * @param nomPartie
     * @return l'id de la partie en fonction de son nom
     */
    @Override
    public int getIdPartieByName(String nomPartie){
        String query = "SELECT idPartie FROM partie WHERE nomDePartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("idPartie");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error235");
        }
        return 0;
    }

    /**
     *
     * @param idPartie
     * @return la partie correspondant à l'id
     */
    @Override
    public Partie getPartieById(int idPartie){
        String query = "SELECT * FROM partie WHERE idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return (new Partie(resultSet.getInt("idPartie"),
                            resultSet.getString("nomDePartie"),
                            resultSet.getString("couleurDeProprio"),
                            resultSet.getString("etatActuel"),
                            resultSet.getString("etatAncien")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error236");
        }
        return null;
    }

    /**
     * permet de changer l'état d'une partie
     * @param idPartie
     * @param etatActuel
     */
    @Override
    public void changeEtatActuel(int idPartie, String etatActuel){
        String query = "UPDATE partie SET etatActuel=? WHERE idPartie = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, etatActuel);
            statement.setInt(2, idPartie);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error237");
        }
    }

    /**
     *
     * @param idPartie
     * @return l'etat d'une partie
     */
    @Override
    public String getEtatActuel(int idPartie){
        String query = "SELECT * FROM partie WHERE idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("etatActuel");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error238");
        }
        return "error238";
    }

    /**
     * permet de changer l'état d'une partie
     * @param idPartie
     * @param etatAncien
     */
    @Override
    public void changeEtatAncien(int idPartie, String etatAncien){
        String query = "UPDATE partie SET etatAncien=? WHERE idPartie = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, etatAncien);
            statement.setInt(2, idPartie);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error237");
        }
    }

    /**
     *
     * @param idPartie
     * @return l'etat d'une partie
     */
    @Override
    public String getEtatAncien(int idPartie){
        String query = "SELECT * FROM partie WHERE idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("etatAncien");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error238");
        }
        return "error238";
    }

}
