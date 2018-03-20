package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.TypeVoitureDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeVoitureDaoImpl implements TypeVoitureDao {


    public ArrayList listeCouleur(){
        String query = "SELECT * FROM typeVoiture";
        ArrayList listCouleur = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ArrayList list= new ArrayList<>();
                    list.add(resultSet.getInt("x"));
                    list.add(resultSet.getString("y"));
                    list.add(resultSet.getString("couleurV"));
                    listCouleur.add(list);

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCouleur;

    }

}