package projet100h.topRace.dao;

import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.PartieCase;

import java.util.List;

public interface CaseDao {

    public List<Case> listCase();

    public String getTopLeft(PartieCase cse);

}
