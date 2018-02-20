package projet100h.topRace.dao;

import projet100h.topRace.entities.PartieCase;

import java.util.List;

public interface PartieCaseDao {

    public PartieCase getPartieCase(int x, char y, int idPartie);

    public List<PartieCase> listPartieCase(int idPartie);

}
