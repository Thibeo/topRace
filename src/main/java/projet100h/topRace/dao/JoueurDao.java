package projet100h.topRace.dao;

import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.PartieCase;

import java.util.List;

public interface JoueurDao {

    public Joueur getJoueurByCase(String couleur, int idPartie, PartieCase cse);

    public List<String> getXYByCouleur(String couleur, int idPartie);

    public void changerCase(Joueur joueur, PartieCase cse);

    public void createJoueur(Joueur joueur);

    public List listOfJoueur(int idPartie);

    public int getScoreJoueur(String couleur, int idPartie);

    public void updateScoreJoueur(String couleurJoueur,int resultatJoueur, int idPartie);

    public void deleteJoueur (String couleurJ, int idPartie);

    public void changerDernierAction(int idPartie, String couleurJ, String action);

    public boolean actionFinieParTousJoueurs(int idPartie, String action);

    public String getDerniereAction(int idPartie, String couleurJ);

    public List listOfPosition(int idPartie);

    public List<PartieCase> getXYByIdPartie(int idPartie);

}
