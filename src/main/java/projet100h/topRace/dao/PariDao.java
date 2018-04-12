package projet100h.topRace.dao;

import java.util.List;

public interface PariDao {

    public void ajoutPari(int idPartie, String couleurJ, int numeroPari, boolean jaune, boolean bleue, boolean rouge, boolean violette, boolean blanche, boolean verte);

    public boolean pariExiste(int idPartie, String couleurJ, int numeroPari);

    public String getPari(int idPartie, String couleurJ, int numeroPari);

    public List getListPari(int idPartie, String couleurJoueur, int idPari);

}
