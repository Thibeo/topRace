package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.NbCaseDao;
import projet100h.topRace.entities.NbCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NbCaseDaoImpl implements NbCaseDao {

    @Override
    public List<NbCase> listNbCase() {
        String query = "SELECT * FROM nbCase";
        List<NbCase> listOfCarte = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                listOfCarte.add(
                        new NbCase(
                                resultSet.getString("couleurV"),
                                resultSet.getInt("idCarte"),
                                resultSet.getInt("nbCase")
                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCarte;
    }

}
