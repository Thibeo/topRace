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

    public void changeEtatActuel(int idPartie, String etatActuel);

    public String getEtatActuel(int idPartie);

    public void changeEtatAncien(int idPartie, String etatAncien);

    public String getEtatAncien(int idPartie);
}
