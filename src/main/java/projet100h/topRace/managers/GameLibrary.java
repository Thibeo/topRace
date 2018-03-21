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
    private PartieDao partieDao = new PartieDaoImpl();
    private TypeVoitureDao voitureDao = new TypeVoitureDaoImpl();


    private GameLibrary() { }

    // toutes les listes :
    public List<Carte> listCarte() { return  carteDao.listCarte(); }
    public List<Case> listCase() { return  caseDao.listCase(); }
    public List<NbCase> listNbCase() { return  nbCaseDao.listNbCase(); }
    public List<PartieCase> listPartieCase (int idPartie) { return partieCaseDao.listPartieCase(idPartie); }
    public Partie getPartieById(int idPartie){ return partieDao.getPartieById(idPartie); }
    public List<Joueur> listOfJoueur(int idPartie){ return joueurDao.listOfJoueur(idPartie); }
    public List listPartie(){
        return partieDao.listPartie(); /* < <2, "best party"> , <3, "partie pour le fun"> > */
    }
    public List listDeplacementCarte(int id){
        return carteDao.listDeplacementCarte(id); /* < <couleurVoiture, nbCase> , <couleurVoiture, nbCase> , <couleurVoiture, nbCase> > */
    }
    public List<Integer> nbDeJoueur() {
        List<Integer> listJoueur = partieDao.nbDeJoueur(); // liste des idPartie de tous les joueurs
        List listFinal = new ArrayList<>(); //creation de la liste final qui sera composé de liste intermediaire
        int idPartie = listJoueur.get(0); //idPartie est initialisé au 1er element de listJoueur
        int compteur = 1; //vu qu'on a initialisé l'idPartie avec le 1er element de lisJoueur, on met le compteur a 1
        for (int i = 1 ; i < listJoueur.size() ; i++){
            if (listJoueur.get(i) == idPartie){ //si l'element actuelle de la liste est égale a idPartie
                compteur=compteur+1; // on augmente le compteur
            } else {
                List listIntermediaire = new ArrayList<>();
                listIntermediaire.add(idPartie); //sinon on met <idPartie, nbJoueurPrésent> dans une liste
                listIntermediaire.add(compteur);
                listFinal.add(listIntermediaire); // puis on ajoute cette liste a la liste finale
                idPartie=listJoueur.get(i); // et on reinitialise l'idPartie et le compteur
                compteur=1;
            }
        }
        List listIntermediaire = new ArrayList<>();
        listIntermediaire.add(idPartie);
        listIntermediaire.add(compteur);
        listFinal.add(listIntermediaire);

        return listFinal; // resultat = < <1,5>, <2,1>, <3,6> >    ( de type  < idpartie , nb de joueur présent Dans la partie > )
    }

    public void changerCase(Joueur joueur, PartieCase cse) {joueurDao.changerCase(joueur, cse);}

    public String getTopLeft(PartieCase cse){ return caseDao.getTopLeft(cse);}

    public Plateau getPlateau (int idPartie){
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
        Plateau plateau = new Plateau();
        plateau.setTableauCase(tableauCase);
        return plateau;
    }



    public Joueur getJoueur(String couleur, int idPartie){
        List<String> list = joueurDao.getXYByCouleur(couleur,idPartie);
        PartieCase cse = partieCaseDao.getPartieCase(Integer.parseInt(list.get(0)), list.get(1).charAt(0), idPartie);
        return joueurDao.getJoueurByCase(couleur,idPartie,cse);
    }

    public void creationPartieCase(int idPartie){ partieCaseDao.creationPartieCase(idPartie);}

    public void modifierCaseException(PartieCase cse,boolean occupee) {
        int x=cse.getX();
        char y=cse.getY();
        int idPartie=cse.getIdPartie();


        // deux premiers tournants à l'intérieur: une case équivaut à deux colonnes
        if ((x==9 && y=='a') || (x==17 && y=='a')) {
            PartieCase cseAutre=new PartieCase(x-1,'a',idPartie,true);
            if (occupee==true) {
                partieCaseDao.modifierStatut(cseAutre,true);
            }else{
                partieCaseDao.modifierStatut(cseAutre,false);
            };

            // dernier tournant extérieur: une case équivaut à deux colonnes
        }else if ((x==53 && y=='c') || (x==55 && y=='c') || (x==57 && y=='c') || (x==60 && y=='c') || (x==62 && y=='c') || (x==64 && y=='c')) {
            PartieCase cseAutre=new PartieCase(x-1,'c',idPartie,true);
            if (cse.isOccupee()==true) {
                partieCaseDao.modifierStatut(cseAutre,true);
            }else{
                partieCaseDao.modifierStatut(cseAutre,false);
            };
            // dernier tournant milieu: une case équivaut à trois colonnes
            // entrée par la case du début:
        }else if ((x==54 && y=='b') || (x==57 && y=='b') || (x==61 && y=='b') || (x==64 && y=='b')) {
            if (cse.isOccupee()==true) {
                for(int i=1;i<3;i++) {
                    PartieCase cseAutre=new PartieCase(x-i,'b',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,true);
                }

            }else{
                for(int i=1;i<3;i++) {
                    PartieCase cseAutre=new PartieCase(x-i,'b',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,false);
                }
            };
            // dernier tournant milieu: une case équivaut à trois colonnes
            //entrée par la case du mileu
        }else if ((x==56 && y=='b') || (x==63 && y=='b')) {
            if (cse.isOccupee()==true) {
                for(int i=-1;i<2;i++) {
                    PartieCase cseAutre=new PartieCase(x+i,'b',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,true);
                }
            }else{
                for(int i=-1;i<2;i++) {
                    PartieCase cseAutre=new PartieCase(x+i,'b',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,false);
                }
            };
            // dernier tournant intérieur: une case équivaut à six colonnes
            // entrée par une case du début:
        }else if ((x==57 && y=='a') || (x==64 && y=='a')) {
            if (cse.isOccupee()==true) {
                for(int i=1;i<6;i++) {
                    PartieCase cseAutre=new PartieCase(x-i,'a',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,true);
                }
            }else{
                for(int i=1;i<6;i++) {
                    PartieCase cseAutre=new PartieCase(x-i,'a',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,false);
                }
            };

            // dernier tournant intérieur: une case équivaut à six colonnes
            //entrée par une case du milieu:
        }else if ((x==55 && y=='a') || (x==62 && y=='a')) {
            if (cse.isOccupee()==true) {
                for(int i=-3;i<3;i++) {
                    PartieCase cseAutre=new PartieCase(x+i,'a',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,true);
                }
            }else{
                for(int i=-3;i<3;i++) {
                    PartieCase cseAutre=new PartieCase(x+i,'a',idPartie,true);
                    partieCaseDao.modifierStatut(cseAutre,false);
                }
            };
        }
        partieCaseDao.modifierStatut(cse,occupee);

    }


    //fonction crer partie (permet de rentrer une nouvelle partie dans la base de données:
    public Partie creerPartie(Partie partie){
        return (partieDao.createPartie(partie));
    }

    // fonction creerJoueur (permet de rentrer un nouveau joueur dans la base de données:
    public void creerJoueur(Joueur joueur){ joueurDao.createJoueur(joueur); }

    // fonction retournant la liste des couleurs des différentes voitures:
    public ArrayList listCouleur(){
        return (voitureDao.listeCouleur());
    }

    // fonction retournant la liste des couleurs des différentes voitures déjà présentent sur la partie placé en paramètre
    public ArrayList listCouleurIdPartie(Integer idPartie){
        ArrayList listCouleurIdPartie = voitureDao.listeCouleurIdPartie(idPartie);
        ArrayList listCouleur = voitureDao.listeCouleur();
        ArrayList listCouleurFinal = new ArrayList<>();
        for (int i = 0 ; i < listCouleur.size() ; i++){
            boolean jeSuisDansLaListe = false;
            int positionOuJeSuis = i;
            for (int j = 0 ; j < listCouleurIdPartie.size() ; j++){
                if (listCouleurIdPartie.get(j).equals( ( (List) listCouleur.get(i) ).get(2))){
                   jeSuisDansLaListe = true;
                }
            }
            if (jeSuisDansLaListe == false) {
                ArrayList list = new ArrayList<>();
                list.add( ( (List) listCouleur.get(positionOuJeSuis) ).get(0));
                list.add( ( (List) listCouleur.get(positionOuJeSuis) ).get(1));
                list.add( ( (List) listCouleur.get(positionOuJeSuis) ).get(2));
                listCouleurFinal.add(list);
            }
        }
        return (listCouleurFinal);
    }

    //fonction retournant l'id correspondant à la partie dont le nom est rentré en parametre:

    public int getIdPartie(String nom){ return(partieDao.getIdPartieByName(nom)); }



}
