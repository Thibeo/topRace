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
                                    resultSet.getString("nomDeProprio"))
                    );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfPartie;
    }

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
        }
        return listOfNbJoueur;
    }

    public Partie createPartie(Partie partie){
        String query = "INSERT INTO partie(nomDePartie, nomDeProprio) VALUES(?, ?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,partie.getNomDePartie());
            statement.setString(2,partie.getNomDeProprio());
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
        }
        return null;
    }

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
        }
        return 0;
    }





}
