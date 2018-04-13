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
                                    resultSet.getString("etat"))
                    );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error231");
        }
        return listOfPartie;
    }

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

    @Override
    public List<Integer> nbDeJoueur(){
        String query = "SELECT * FROM joueur";
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

    @Override
    public Partie createPartie(Partie partie){
        String query = "INSERT INTO partie(nomDePartie, couleurDeProprio, etat) VALUES(?, ?, ?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,partie.getNomDePartie());
            statement.setString(2,partie.getCouleurDeProprio());
            statement.setString(3,partie.getEtat());
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
                            resultSet.getString("etat")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error236");
        }
        return null;
    }

    @Override
    public void changeEtat(int idPartie, String etat){
        String query = "UPDATE partie SET etat=? WHERE idPartie = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, etat);
            statement.setInt(2, idPartie);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error237");
        }
    }

    @Override
    public String getEtat(int idPartie){
        String query = "SELECT * FROM partie WHERE idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("etat");
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
