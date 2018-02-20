package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.CaseDao;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.PartieCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaseDaoImpl implements CaseDao {

    @Override
    public List<Case> listCase() {
        String query = "SELECT * FROM cse";
        List<Case> listOfCase = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                listOfCase.add(
                        new Case(
                                resultSet.getInt("x"),
                                resultSet.getString("y").charAt(0),
                                resultSet.getBoolean("occupee"),
                                resultSet.getFloat("top"),
                                resultSet.getFloat("left"),
                                resultSet.getInt("rotate")

                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCase;
    }

    @Override
    public String getTopLeft(PartieCase cse) {
        String query = "SELECT * FROM cse WHERE x=? and y=?";
        String topLeft;
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cse.getX());
            statement.setString(2, String.valueOf(cse.getY()));
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    topLeft = String.valueOf(resultSet.getFloat("top"));
                    topLeft = topLeft + "/";
                    topLeft = topLeft + String.valueOf(resultSet.getFloat("left"));
                    topLeft = topLeft + "+";
                    topLeft = topLeft + String.valueOf(resultSet.getInt("rotate"));
                    return topLeft;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
