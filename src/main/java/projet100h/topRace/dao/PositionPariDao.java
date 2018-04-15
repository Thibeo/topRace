package projet100h.topRace.dao;

import java.util.List;

public interface PositionPariDao {

    public List getPositionPari(int idPartie, int numeroPari);

    public void nouvellePositionPari(int numeroPari,int idPartie,String couleur,int x,String y);
}
