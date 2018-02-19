package projet100h.topRace.managers;

import projet100h.topRace.dao.*;
import projet100h.topRace.dao.impl.*;
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
    private PartieCaseDao partieCaseDao = new PartieCaseDaoImpl();
    private JoueurDao joueurDao = new JoueurDaoImpl();

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


    public Joueur getJoueur(String couleur, int idPartie){
        List<String> list = joueurDao.getXYByCouleur(couleur,idPartie);
        PartieCase cse = partieCaseDao.getPartieCase(Integer.parseInt(list.get(0)), list.get(2).charAt(0), idPartie);
        return joueurDao.getJoueurByCase(couleur,idPartie,cse);
    }

}
