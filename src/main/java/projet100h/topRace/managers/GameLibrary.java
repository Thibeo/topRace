package projet100h.topRace.managers;

import projet100h.topRace.dao.CarteDao;
import projet100h.topRace.dao.CaseDao;
import projet100h.topRace.dao.NbCaseDao;
import projet100h.topRace.dao.impl.CarteDaoImpl;
import projet100h.topRace.dao.impl.CaseDaoImpl;
import projet100h.topRace.dao.impl.NbCaseDaoImpl;
import projet100h.topRace.entities.*;

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


    public List listDeplacementCarte(int id){
        return carteDao.listDeplacementCarte(id);
    }

    public void transformerStatut(Case cseActuelle, Case Ancienne, Partie partie){

        if (partie.lierCasesException(cseActuelle).equals("sortie de tournant")){

        }else if (partie.lierCasesException(cseActuelle).equals("sortie dernier tournant exterieur")){

        }else if (partie.lierCasesException(cseActuelle).equals("sortie dernier tournant milieu")){

        }else if (partie.lierCasesException(cseActuelle).equals("sortie dernier tournant interieur")){

        }else if (partie.lierCasesException(cseActuelle).equals("rien")){

        }




        partie.lierCasesException(Ancienne);



    }

}
