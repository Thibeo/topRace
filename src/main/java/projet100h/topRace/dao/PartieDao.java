package projet100h.topRace.dao;

import projet100h.topRace.entities.Partie;

import java.util.List;

public interface PartieDao {

    public List listPartie();

    public List<Integer> nbDeJoueur();

    public int nbDeJoueurIdPartie(int idPartie);

    public Partie createPartie(Partie partie);

    public int getIdPartieByName(String nomPartie);

    public Partie getPartieById(int idPartie);

    public void changeEtat(int idPartie, String etat);

    public String getEtat(int idPartie);
}
