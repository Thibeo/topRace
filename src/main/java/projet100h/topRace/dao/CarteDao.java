package projet100h.topRace.dao;

import projet100h.topRace.entities.Carte;
import java.util.List;

public interface CarteDao {

    public List<Carte> listCarte();

    public List listDeplacementCarte(int id);

}
