package projet100h.topRace.dao;

import projet100h.topRace.entities.CarteJoueur;

import java.util.List;

public interface CarteJoueurDao {

    public void createCarteJoueur(CarteJoueur carteJoueur);

    public List<CarteJoueur> getCarteJoueur(int idPartie, String couleurJ);

    public void utilisation(int idCarte, int idPartie, String couleurJ);

}