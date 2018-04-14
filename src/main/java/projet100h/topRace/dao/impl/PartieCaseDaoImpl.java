package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.PartieCaseDao;
import projet100h.topRace.entities.PartieCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartieCaseDaoImpl implements PartieCaseDao {

    /**
     * permet de creer les cases d'un plateau au commencement d'une partie
     * @param idPartie
     */
    @Override
    public void creationPartieCase(int idPartie){
        String query = "SELECT * FROM cse";
        try (   Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                int x = resultSet.getInt("x");
                char y = resultSet.getString("y").charAt(0);
                boolean occupee = resultSet.getBoolean("occupee");
                String query1 = "INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (?, ?, ?, ?);";
                try (Connection connection2 = DataSourceProvider.getDataSource().getConnection();
                     PreparedStatement statement2 = connection2.prepareStatement(query1)) {
                    statement2.setInt(1, x);
                    statement2.setString(2, String.valueOf(y));
                    statement2.setInt(3, idPartie);
                    statement2.setBoolean(4,occupee);
                    statement2.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("error225");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error224");
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param idPartie
     * @return une case d'une partie
     */
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
            System.out.println("");
            System.out.println("error226");
        }
        return null;
    }

    /**
     * permet de modifier le statut d'une case d'une partie
     * @param cse
     * @param occupe
     */
    @Override
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
            System.out.println("");
            System.out.println("error227");
        }


    }

    /**
     *
     * @param idPartie
     * @return la liste des cases d'une partie
     */
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error228");
        }
        return listOfcases;
    }




}
