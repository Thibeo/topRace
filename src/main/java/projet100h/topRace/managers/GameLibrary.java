package projet100h.topRace.managers;

import projet100h.topRace.dao.*;
import projet100h.topRace.dao.impl.*;
import projet100h.topRace.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private PariDao pariDao = new PariDaoImpl();

    private PositionPariDao positionPariDao=new PositionPariDaoImpl();

    private CarteJoueurDao carteJoueurDao = new CarteJoueurDaoImpl();


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
    public List listDeplacementCarte(int id){ return carteDao.listDeplacementCarte(id);}/* < <couleurVoiture, nbCase> , <couleurVoiture, nbCase> , <couleurVoiture, nbCase> > */
    public List<CarteJoueur> getCarteJoueur(int idPartie, String couleurJ){return carteJoueurDao.getCarteJoueur(idPartie,couleurJ);}
    public int nbDeJoueurIdPartie(int idPartie){ return partieDao.nbDeJoueurIdPartie(idPartie);}


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
    public void changerCase(Joueur joueur, PartieCase cse) {joueurDao.changerCase(joueur, cse);} // change la case actuelle du joueur dans la BDD
    public void changeEtatActuel(int idPartie, String etatActuel){partieDao.changeEtatActuel(idPartie,etatActuel);} // change l'état actuel de la partie dans la BDD
    public void changeEtatAncien(int idPartie, String etatAncien){partieDao.changeEtatAncien(idPartie,etatAncien);} // change l'état de la partie dans la BDD
    public void changerDernierAction(int idPartie, String couleurJ, String action){joueurDao.changerDernierAction(idPartie,couleurJ,action);} // change la dernière action d'un joueur dans la BDD
    public void utilisation(int idCarte, int idPartie, String couleurJ){carteJoueurDao.utilisation(idCarte,idPartie,couleurJ);}
    public boolean actionFinieParTousJoueurs(int idPartie, String action){return joueurDao.actionFinieParTousJoueurs(idPartie,action);} // retourne si oui ou non, l'action en parametre a été effectué par tout les joueurs
    public void ajoutPari(int idPartie, String couleurJ, int numeroPari, boolean jaune, boolean bleue, boolean rouge, boolean violette, boolean blanche, boolean verte){pariDao.ajoutPari(idPartie, couleurJ, numeroPari, jaune, bleue, rouge, violette, blanche, verte);}
    public boolean pariExiste(int idPartie, String couleurJ, int numeroPari){return pariDao.pariExiste(idPartie, couleurJ, numeroPari);}
    public String getPari(int idPartie, String couleurJ, int numeroPari){return pariDao.getPari(idPartie,couleurJ,numeroPari);}
    public String getEtatActuel(int idPartie){return partieDao.getEtatActuel(idPartie);}
    public String getEtatAncien(int idPartie){return partieDao.getEtatAncien(idPartie);}
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

    public int getScoreJoueur(String couleur, int idPartie){ return joueurDao.getScoreJoueur(couleur, idPartie); }
    /**
     *
     * @param couleur
     * @param idPartie
     * @return un joueur
     */
    public Joueur getJoueur(String couleur, int idPartie){
        List<String> list = joueurDao.getXYByCouleur(couleur,idPartie);
        PartieCase cse = partieCaseDao.getPartieCase(Integer.parseInt(list.get(0)), list.get(1).charAt(0), idPartie);
        return joueurDao.getJoueurByCase(couleur,idPartie,cse);
    }
    public void deleteJoueur (String couleurJ, int idPartie){ joueurDao.deleteJoueur(couleurJ, idPartie);}
    public void creationPartieCase(int idPartie){ partieCaseDao.creationPartieCase(idPartie);}

    /**
     * permet de modifier le statut des cases présentants des exceptions
     * @param cse
     * @param occupee
     */
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
    public Partie creerPartie(Partie partie){//fonction crer partie (permet de rentrer une nouvelle partie dans la base de données:
        return (partieDao.createPartie(partie));
    }
    public void creerJoueur(Joueur joueur){ joueurDao.createJoueur(joueur); } // fonction creerJoueur (permet de rentrer un nouveau joueur dans la base de données:


    /**
     *
     * @return la liste des couleurs des différentes voitures
     */
    public ArrayList listCouleur(){
        return (voitureDao.listeCouleur());
    }

    /**
     *
     * @param idPartie
     * @return retournant la liste des couleurs des différentes voitures déjà présentes sur la partie placée en paramètre
     */
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
    public int getIdPartie(String nom){ return(partieDao.getIdPartieByName(nom)); }    //fonction retournant l'id correspondant à la partie dont le nom est rentré en parametre:
    public String getDerniereAction(int idPartie, String couleurJ){ return joueurDao.getDerniereAction(idPartie, couleurJ);}

    /**
     * fonction permettant d'attribuer à chaque joueur des cartes de manière aleatoire
     * @param idPartie
     */
    public void repartitionCarteJoueur(int idPartie){

        List<Carte> listofCarte = listCarte(); // on recupère toutes les cartes
        int compteurNbCoup = 0; // compteur créé pour les test
        int compteur = 1; // on crèè un compteur qui va distribuer les carte a chaque joueur
        int taille = listofCarte.size(); // on récupère la taille de la liste pour la boucle

        for (int i = 0; i < taille; i++) { // on va faire autant de fois qu'il y a de carte la boucle ci dessous
            Random rand = new Random();
            int nombreAleatoire = rand.nextInt((listofCarte.size() - 1) - 0 + 1); // on créé un nombra aléatoire compris entre 0 et le nombre de cartes restante -1
            if (compteur == 1) { // puis en fonction du compteur on va ajouter une carte au joueur, chacun a son tour
                carteJoueurDao.createCarteJoueur(new CarteJoueur(listofCarte.get(nombreAleatoire).getIdCarte(), idPartie, "Bleu", false));
                listofCarte.remove(nombreAleatoire); // puis on enlève la carte de la liste
                compteurNbCoup++;
            } else if (compteur == 2) {
                carteJoueurDao.createCarteJoueur(new CarteJoueur(listofCarte.get(nombreAleatoire).getIdCarte(), idPartie, "Blanc", false));
                listofCarte.remove(nombreAleatoire);
                compteurNbCoup++;
            } else if (compteur == 3) {
                carteJoueurDao.createCarteJoueur(new CarteJoueur(listofCarte.get(nombreAleatoire).getIdCarte(), idPartie, "Vert", false));
                listofCarte.remove(nombreAleatoire);
                compteurNbCoup++;
            } else if (compteur == 4) {
                carteJoueurDao.createCarteJoueur(new CarteJoueur(listofCarte.get(nombreAleatoire).getIdCarte(), idPartie, "Rouge", false));
                listofCarte.remove(nombreAleatoire);
                compteurNbCoup++;
            } else if (compteur == 5) {
                carteJoueurDao.createCarteJoueur(new CarteJoueur(listofCarte.get(nombreAleatoire).getIdCarte(), idPartie, "Jaune", false));
                listofCarte.remove(nombreAleatoire);
                compteurNbCoup++;
            } else if (compteur == 6) {
                carteJoueurDao.createCarteJoueur(new CarteJoueur(listofCarte.get(nombreAleatoire).getIdCarte(), idPartie, "Violet", false));
                listofCarte.remove(nombreAleatoire);
                compteurNbCoup++;
            }
            if (compteur != 6) { // une fois fini on va augmenté le compteur pour passer au joueur suivant
                compteur++;
            } else { // et si c'est le 6ème joueur, on va revenir au premier
                compteur = 1;
            }
        }
        System.out.println("/////////////////////////////////////////////////");
        System.out.println("il y a eu " + compteurNbCoup + " distribution de carte");
        System.out.println("/////////////////////////////////////////////////");
    }

    /**
     *
     * @param idPartie
     * @param idPari
     * @param couleurJoueur
     * @return le score du joueur
     */
    public int calcul(int idPartie, int idPari, String couleurJoueur) {
        //recupere dans la table positionPari les positions des voitures:

        List positionPari = positionPariDao.getPositionPari(idPartie, idPari);
        //recupere dans la table pari le pari du joueur:

        List pariJoueur = pariDao.getListPari(idPartie, couleurJoueur, idPari);
        // recupere le score du joueur
        int resultatJoueur = joueurDao.getScoreJoueur(couleurJoueur, idPartie);





        
        /*
        //trie la liste positionPari en ordre decroissant (pour avoir en 1 position la couleur de la voiture la plus avancée)
        List<String> positionPariTriee=new ArrayList<String>();
        for (int i=1; i<positionPari.size();i++){
            List couleurAAjouter=(List) positionPari.get(i);
            for(int j=i;j<positionPari.size();j++){
                List couleurAComparer=(List) positionPari.get(j);
                // compare les positions :
                // d'abord les x:
                if(((int) couleurAComparer.get(1)) > ((int) couleurAAjouter.get(1))){
                    couleurAAjouter=couleurAComparer;
                 //si les x sont égaux, il faut comparer les y:
                }else if (((int) couleurAComparer.get(1)) == ((int) couleurAAjouter.get(1))){
                    if(((String) couleurAComparer.get(2)).charAt(0)=='a'){
                        couleurAAjouter=couleurAComparer;
                    }else if((((String) couleurAComparer.get(2)).charAt(0)=='b') && (((String) couleurAAjouter.get(2)).charAt(0)=='c')){
                        couleurAAjouter=couleurAComparer;
                    }
                }
                positionPariTriee.add((String) couleurAAjouter.get(0));
            }
        }
        */


        // une fois qu'on a trié la liste, il faut comparer les deux listes (positions et pari):
        for (int i = 0; i < pariJoueur.size(); i++) {
            String couleur = (String) pariJoueur.get(i);

            int compteurF=0;
            for (int j = 0; j < positionPari.size(); j++) {

                if (((List) positionPari.get(j)).get(0).equals(couleur)) {

                    compteurF = j+1;
                }
            }
            //pari 1:
            if (idPari == 1) {
                if (compteurF == 1) {
                    resultatJoueur = resultatJoueur + 9;
                } else if (compteurF == 2) {
                    resultatJoueur = resultatJoueur + 6;
                } else if (compteurF == 3) {
                    resultatJoueur = resultatJoueur + 3;
                } else if (compteurF == 5) {
                    resultatJoueur = resultatJoueur - 1;
                } else if (compteurF == 6) {
                    resultatJoueur = resultatJoueur - 3;
                }
                //pari 2:
            } else if (idPari == 2) {
                if (compteurF == 1) {
                    resultatJoueur = resultatJoueur + 6;
                } else if (compteurF == 2) {
                    resultatJoueur = resultatJoueur + 4;
                } else if (compteurF == 3) {
                    resultatJoueur = resultatJoueur + 2;
                } else if (compteurF == 4) {
                    resultatJoueur = resultatJoueur - 1;
                } else if (compteurF == 5) {
                    resultatJoueur = resultatJoueur - 3;
                } else if (compteurF == 6) {
                    resultatJoueur = resultatJoueur - 6;
                }
                //pari 3:
            } else if (idPari == 3) {
                if (compteurF == 1) {
                    resultatJoueur = resultatJoueur + 3;
                } else if (compteurF == 2) {
                    resultatJoueur = resultatJoueur + 2;
                } else if (compteurF == 3) {
                    resultatJoueur = resultatJoueur + 1;
                } else if (compteurF == 4) {
                    resultatJoueur = resultatJoueur - 2;
                } else if (compteurF == 5) {
                    resultatJoueur = resultatJoueur - 6;
                } else if (compteurF == 6) {
                    resultatJoueur = resultatJoueur - 9;
                }
            }
        }
        // pour changer dans la base de données le score du joueur
        joueurDao.updateScoreJoueur(couleurJoueur, resultatJoueur, idPartie);
        return resultatJoueur;
    }

    public void calculLigneArrivee(int idPartie, int numeroPari,String couleurJoueur){
        //recupere dans la table positionPari les positions des voitures:
        List positionPari = positionPariDao.getPositionPari(idPartie, numeroPari);
        // recupere le score du joueur
        int resultatJoueur = joueurDao.getScoreJoueur(couleurJoueur, idPartie);
        int compteur=0;

        for (int j = 0; j < positionPari.size(); j++) {
            compteur=compteur+1;
            if ((positionPari.get(j)).equals(couleurJoueur)) {
                if (compteur==1){
                    resultatJoueur=resultatJoueur+20;
                }else if (compteur==2){
                    resultatJoueur=resultatJoueur+15;
                }else if (compteur==3){
                    resultatJoueur=resultatJoueur+10;
                }else if (compteur==4){
                    resultatJoueur=resultatJoueur+6;
                }else if (compteur==5){
                    resultatJoueur=resultatJoueur+3;
                }else if (compteur==6){
                    resultatJoueur=resultatJoueur+1;
                }
            }
        }
        joueurDao.updateScoreJoueur(couleurJoueur, resultatJoueur,idPartie);
    }

    public void calculPari(int idPartie, int numeroPari){
        List<Joueur> listJoueur= joueurDao.listOfJoueur(idPartie);
        for (int i=0;i<listJoueur.size();i++) {
            Joueur joueur = listJoueur.get(i);
            String couleurJoueur = joueur.getCouleur();
            GameLibrary.getInstance().calcul(idPartie, numeroPari, couleurJoueur);
        }
    }
    public void calculFinal(int idPartie,int numeroPari){
        List<Joueur> listJoueur= joueurDao.listOfJoueur(idPartie);
        for (int i=0;i<listJoueur.size();i++) {
            Joueur joueur = listJoueur.get(i);
            String couleurJoueur = joueur.getCouleur();
            GameLibrary.getInstance().calculLigneArrivee(idPartie, numeroPari, couleurJoueur);
        }
    }

}
















