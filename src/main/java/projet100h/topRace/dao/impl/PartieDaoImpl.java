package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PartieDao;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.Partie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


}
