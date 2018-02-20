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

    public List<PartieCase> listPartieCase (int idPartie) { return partieCaseDao.listPartieCase(idPartie); }

    public void changerCase(Joueur joueur, PartieCase cse) {joueurDao.changerCase(joueur, cse);}

    public String getTopLeft(PartieCase cse){ return caseDao.getTopLeft(cse);}

    public Partie getPlateau (int idPartie){
        PartieCase tableauCase[][] = new PartieCase[69][3];
        PartieCase cse;
        List<PartieCase> listPartieCase = listPartieCase(idPartie);
        for (int i=0 ; i< listPartieCase.size() ; i++){
            if (listPartieCase.get(i).getY()=='a'){
                int x = listPartieCase.get(i).getX();
                cse=listPartieCase.get(i);
                tableauCase[x][0]=cse;
            }else if(listPartieCase.get(i).getY()=='b'){
                tableauCase[listPartieCase.get(i).getX()][1]=listPartieCase.get(i);
            }else if(listPartieCase.get(i).getY()=='c'){
                tableauCase[listPartieCase.get(i).getX()][2]=listPartieCase.get(i);
            }
        }
        Partie partie = new Partie();
        partie.setTableauCase(tableauCase);
        return partie;
    }

    public List listDeplacementCarte(int id){
        return carteDao.listDeplacementCarte(id); /* < <couleurVoiture, nbCase> , <couleurVoiture, nbCase> , <couleurVoiture, nbCase> > */
    }

    public Joueur getJoueur(String couleur, int idPartie){
        List<String> list = joueurDao.getXYByCouleur(couleur,idPartie);
        PartieCase cse = partieCaseDao.getPartieCase(Integer.parseInt(list.get(0)), list.get(1).charAt(0), idPartie);
        return joueurDao.getJoueurByCase(couleur,idPartie,cse);
    }

    /*
    public void transformerStatut(PartieCase cseActuelle, Case Ancienne, Partie partie){

        if (partie.lierCasesException(cseActuelle).equals("sortie de tournant")){

        }else if (partie.lierCasesException(cseActuelle).equals("sortie dernier tournant exterieur")){

        }else if (partie.lierCasesException(cseActuelle).equals("sortie dernier tournant milieu")){

        }else if (partie.lierCasesException(cseActuelle).equals("sortie dernier tournant interieur")){

        }else if (partie.lierCasesException(cseActuelle).equals("rien")){

        }




        partie.lierCasesException(Ancienne);



    }
*/



}
