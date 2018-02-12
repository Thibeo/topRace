package projet100h.topRace.managers;

import projet100h.topRace.dao.CarteDao;
import projet100h.topRace.dao.CaseDao;
import projet100h.topRace.dao.NbCaseDao;
import projet100h.topRace.dao.impl.CarteDaoImpl;
import projet100h.topRace.dao.impl.CaseDaoImpl;
import projet100h.topRace.dao.impl.NbCaseDaoImpl;
import projet100h.topRace.entities.Carte;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.NbCase;

import java.util.ArrayList;
import java.util.List;

public class GameLibrary {

    private static class GameLibraryHolder {
        private final static GameLibrary instance = new GameLibrary();
    }

    public static GameLibrary getInstance() {
        return GameLibraryHolder.instance;
    }


    private CarteDao carteDao = new CarteDaoImpl();
    private CaseDao caseDao = new CaseDaoImpl();
    private NbCaseDao nbCaseDao = new NbCaseDaoImpl();

    private GameLibrary() {
    }

    public List<Carte> listCarte() { return  carteDao.listCarte(); }

    public List<Case> listCase() { return  caseDao.listCase(); }

    public List<NbCase> listNbCase() { return  nbCaseDao.listNbCase(); }

}
