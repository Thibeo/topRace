package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PartieDao;
import projet100h.topRace.entities.Case;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PartieDaoImpl implements PartieDao{

    public List listPartie(){
        String query = "SELECT * FROM partie";
        List listOfPartie = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                List listt = new ArrayList<>();
                    listt.add(resultSet.getInt("idPartie"));
                    listt.add(resultSet.getString("nomDePartie"));
                    listOfPartie.add(listt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfPartie;
    }


}
