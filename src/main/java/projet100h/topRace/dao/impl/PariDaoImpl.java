package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PariDao;
import projet100h.topRace.entities.PartieCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PariDaoImpl implements PariDao{

    public void ajoutPari(int idPartie, String couleurJ, int numeroPari, boolean jaune, boolean bleue, boolean rouge, boolean violette, boolean blanche, boolean verte){
        String query = "INSERT INTO pari (idPartie, CouleurJ, numeroPari, jaune, bleue, rouge, violette, blanche, verte) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,idPartie);
            statement.setString(2,couleurJ);
            statement.setInt(3,numeroPari);
            statement.setBoolean(4,jaune);
            statement.setBoolean(5, bleue);
            statement.setBoolean(6,rouge);
            statement.setBoolean(7,violette);
            statement.setBoolean(8,blanche);
            statement.setBoolean(9,verte);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean pariExiste(int idPartie, String couleurJ, int numeroPari){
        String query = "SELECT COUNT(*) AS compte FROM pari WHERE idPartie=? AND couleurJ=? AND numeroPari=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            statement.setString(2, couleurJ);
            statement.setInt(3, numeroPari);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    if (resultSet.getInt("compte") != 0){
                        return true;
                    } else{
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getPari(int idPartie, String couleurJ, int numeroPari){
        String query = "SELECT * FROM pari WHERE idPartie=? and couleurJ=? and numeroPari=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            statement.setString(2, couleurJ);
            statement.setInt(3, numeroPari);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String answer="";
                    if (resultSet.getBoolean("jaune") == true ){answer=answer+"jaune-";}
                    if (resultSet.getBoolean("bleue") == true ){answer=answer+"bleue-";}
                    if (resultSet.getBoolean("rouge") == true ){answer=answer+"rouge-";}
                    if (resultSet.getBoolean("violette") == true ){answer=answer+"violette-";}
                    if (resultSet.getBoolean("blanche") == true ){answer=answer+"blanche-";}
                    if (resultSet.getBoolean("verte") == true ){answer=answer+"verte-";}
                    return answer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
