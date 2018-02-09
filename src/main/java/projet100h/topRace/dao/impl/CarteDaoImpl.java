package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.CarteDao;
import projet100h.topRace.entities.Carte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDaoImpl implements CarteDao{

    @Override
    public List<Carte> listCarte() {
        String query = "SELECT * FROM carte";
        List<Carte> listOfCarte = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                listOfCarte.add(
                        new Carte(
                                resultSet.getInt("idCarte")
                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCarte;
    }

}