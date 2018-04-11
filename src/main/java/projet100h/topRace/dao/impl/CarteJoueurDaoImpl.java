package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.CarteJoueurDao;
import projet100h.topRace.entities.CarteJoueur;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.PartieCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarteJoueurDaoImpl implements CarteJoueurDao {

    @Override
    public void createCarteJoueur(CarteJoueur carteJoueur){
        String query = "INSERT INTO cartejoueur(idPartie, couleurJ, idCarte, utilisee) VALUES(?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,carteJoueur.getIdPartie());
            statement.setString(2,carteJoueur.getCouleurJ());
            statement.setInt(3,carteJoueur.getIdCarte());
            statement.setBoolean(4,carteJoueur.isUtilisee());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error203");
        }
    }

    @Override
    public void utilisation(int idCarte, int idPartie, String couleurJ){
        String query = "UPDATE cartejoueur SET utilisee = ? WHERE couleurJ = ? AND idPartie = ? AND idCarte=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1,true);
            statement.setString(2,couleurJ);
            statement.setInt(3,idPartie);
            statement.setInt(4,idCarte);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error204");
        }
    }


    @Override
    public List<CarteJoueur> getCarteJoueur(int idPartie, String couleurJ){
        String query = "SELECT * FROM cartejoueur WHERE idPartie=? AND couleurJ=? AND utilisee=?";
        List<CarteJoueur> list = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPartie);
            statement.setString(2, couleurJ);
            statement.setBoolean(3, false);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            new CarteJoueur(
                                    resultSet.getInt("idCarte"),
                                    resultSet.getInt("idPartie"),
                                    resultSet.getString("couleurJ"),
                                    resultSet.getBoolean("utilisee")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error205");
        }
        return list;
    }

}
