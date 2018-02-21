package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PartieCaseDao;
import projet100h.topRace.entities.PartieCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartieCaseDaoImpl implements PartieCaseDao {


    @Override
    public PartieCase getPartieCase(int x, char y, int idPartie){
        String query = "SELECT * FROM partieCase WHERE x=? and y=? and idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, x);
            statement.setString(2, String.valueOf(y));
            statement.setInt(3, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PartieCase(resultSet.getInt("x"),
                                          resultSet.getString("y").charAt(0),
                                          resultSet.getInt("idPartie"),
                                          resultSet.getBoolean("occupee"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void modifierStatut(PartieCase cse,boolean occupe){
        String query = "UPDATE partieCase SET occupee=? WHERE x=? and y=? and idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1,occupe);
            statement.setInt(2, cse.getX());
            statement.setString(3, String.valueOf(cse.getY()));
            statement.setInt(4, cse.getIdPartie());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<PartieCase> listPartieCase(int idPartie) {
        String query = "SELECT * FROM partieCase WHERE idPartie=?";
        List<PartieCase> listOfcases = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    listOfcases.add(
                            new PartieCase(resultSet.getInt("x"),
                                           resultSet.getString("y").charAt(0),
                                           resultSet.getInt("idPartie"),
                                           resultSet.getBoolean("occupee")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfcases;
    }

}
