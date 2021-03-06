package projet100h.topRace.dao.impl;

import projet100h.topRace.dao.CarteDao;
import projet100h.topRace.entities.Carte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDaoImpl implements CarteDao{

    @Override
    /**
     * retourne la liste de l'ensemble des cartes du jeu
     */
    public List<Carte> listCarte() {
        String query = "SELECT * FROM carte WHERE NOT idCarte=0";
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
            System.out.println("");
            System.out.println("error201");
        }
        return listOfCarte;
    }

    /**
     *
     * @param id (l'id d'une carte)
     * @return une liste contenant les couleurs des voitures et le nombre de déplacements associé que la carte permet
     */

    public List listDeplacementCarte(int id) {
        String query = "SELECT * FROM nbCase WHERE idCarte=? ";
        List listDeplacemementCouleur = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
                 statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    List listCouleur = new ArrayList<>();
                    listCouleur.add(resultSet.getInt("nbCase"));
                    listCouleur.add(resultSet.getString("couleurV"));
                    listDeplacemementCouleur.add(listCouleur);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
            System.out.println("error202");
        }
        return listDeplacemementCouleur;
    }

}