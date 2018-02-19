package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PartieCaseDao;
import projet100h.topRace.entities.PartieCase;

import java.sql.*;

public class PartieCaseDaoImpl implements PartieCaseDao {


    @Override
    public PartieCase getPartieCase(int x, char y, int idPartie){
        String query = "SELECT * FROM partieCase WHERE x=? and y=? and idPartie=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, x);
            statement.setString(2, String.valueOf(y));
            statement.setInt(2, idPartie);
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

}
