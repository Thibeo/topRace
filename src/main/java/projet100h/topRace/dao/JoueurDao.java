package projet100h.topRace.dao;

import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.PartieCase;

import java.util.List;

public interface JoueurDao {

    public Joueur getJoueurByCase(String couleur, int idPartie, PartieCase cse);

    public List<String> getXYByCouleur(String couleur, int idPartie);

    public void changerCase(Joueur joueur, PartieCase cse);

    public void createJoueur(Joueur joueur);

}
