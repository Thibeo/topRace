package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.CaseDao;
import projet100h.topRace.entities.Case;

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
                                resultSet.getInt("top"),
                                resultSet.getInt("left")
                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCase;
    }

}
