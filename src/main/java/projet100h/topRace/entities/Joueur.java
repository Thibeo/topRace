package projet100h.topRace.entities;

import com.sun.org.glassfish.gmbal.GmbalException;
import projet100h.topRace.dao.JoueurDao;
import projet100h.topRace.dao.PartieCaseDao;
import projet100h.topRace.dao.PartieDao;
import projet100h.topRace.dao.PositionPariDao;
import projet100h.topRace.dao.impl.JoueurDaoImpl;
import projet100h.topRace.dao.impl.PartieCaseDaoImpl;
import projet100h.topRace.dao.impl.PartieDaoImpl;
import projet100h.topRace.dao.impl.PositionPariDaoImpl;
import projet100h.topRace.managers.GameLibrary;

import java.util.List;

public class Joueur {
    private String nomJoueur;
    private String couleur;
    private PartieCase caseActuelle;
    private int idPartie;
    private String derniereAction;
    private int score;



    public Joueur(String couleur, String nomJoueur, PartieCase caseActuelle, int idPartie, String derniereAction, int score){
        this.nomJoueur=nomJoueur;
        this.couleur=couleur;
        this.caseActuelle=caseActuelle;
        this.idPartie=idPartie;
        this.derniereAction=derniereAction;
        this.score=score;
    }

    private JoueurDao joueurDao = new JoueurDaoImpl();
    private PositionPariDao positionPariDao=new PositionPariDaoImpl();
    private PartieDao partieDao=new PartieDaoImpl();

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getIdPartie(){ return (this.idPartie); }
    public void setIdPartie(int idPartie) { this.idPartie = idPartie; }

    public String getNomJoueur(){ return (this.nomJoueur); }
    public void setNomJoueur(String nomJoueur) { this.nomJoueur = nomJoueur; }

    public String getCouleur(){ return (this.couleur); }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public PartieCase getCaseActuelle(){ return (this.caseActuelle); }
    public void setCaseActuelle(PartieCase caseActuelle) { this.caseActuelle = caseActuelle; }

    public String getDerniereAction() { return derniereAction; }
    public void setDerniereAction(String derniereAction) { this.derniereAction = derniereAction; }


    /**
     * permet de regarder si la case sur laquelle on arrive est une case présentant un déplacement particulier
     * @param plateau
     */
    public void deplacementException(Plateau plateau) {


        if (plateau.exception(this.caseActuelle).equals("tournant a l interieur")) {
            // les cases en 'a' des colonnes 6à 7 et 14 à 15 représentent les memes cases, il faut donc modifier leur statut
            //pour qu'elles aient le meme:
            plateau.getCase(this.caseActuelle.getX()+1, this.caseActuelle.getY()).modifierOccupee();
            this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'a'));

        }else if (plateau.exception(this.caseActuelle).equals("dernier tournant a l'extérieur")) {
            // les cases en 'c' des colonnes 50 à 51, 52 à 53 et 54 à 55 représentent la meme case, il faut donc modifier leur statut pour qu'elles aient
            // toutes le meme
            plateau.getCase(this.caseActuelle.getX()+1,'c').modifierOccupee();
            this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'c'));


        }else if (plateau.exception(this.caseActuelle).equals("dernier tournant a l'interieur debut")) {
            // les cases en 'a' des colonnes 50 à 55 représentent la meme case, il faut donc modifier leur statut pour qu'il soit équal
            // à celui de la premiere et à celui de la derniere case du tournant (ligne 'a')
            //(cas lorsqu'on arrive de la premiere case)
            for (int i=1;i<6;i++) {
                plateau.getCase(this.caseActuelle.getX()+i, 'a').modifierOccupee();
            }

            this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+5,'a'));

        }else if (plateau.exception(this.caseActuelle).equals("dernier tournant a l'interieur milieu")) {
            // les cases en 'a' des colonnes 50 à 55 représentent la meme case, il faut donc modifier leur statut pour qu'il soit équal
            // à celui de la premiere et à celui de la derniere case du tournant (ligne 'a')
            //(cas lorsqu'on arrive de la case du milieu)
			/*for (int i=-3;i<3;i++) {
				plateau.getCase(this.caseActuelle.getX()+i, 'a').modifierOccupee();
			}
			plateau.getCase(this.caseActuelle.getX(),'a').modifierOccupee();*/
            this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+2,'a'));

        }else if (plateau.exception(this.caseActuelle).equals("dernier tournant au milieu debut")) {
            // les cases en 'b' des colonnes 50 à 52 et 53 à 55 représentent la meme case, il faut donc modifier leur statut pour qu'elles aient
            // toutes le meme
            //(cas lorsqu'on arrive de la premiere case)
            for (int i=1;i<3;i++) {
                plateau.getCase(this.caseActuelle.getX()+i, 'b').modifierOccupee();
            }
            this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+2,'b'));

        }else if (plateau.exception(this.caseActuelle).equals("dernier tournant au milieu milieu")) {
            // les cases en 'b' des colonnes 50 à 52 et 53 à 55 représentent la meme case, il faut donc modifier leur statut pour qu'elles aient
            // toutes le meme
            //(cas lorsqu'on arrive de la case du milieu)
            this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'b'));
        }

    }


    /**
     *
     * @param plateau
     * @return la nouvelle position du joueur après un déplacement de 1 case
     */
    public PartieCase deplacementSeul(Plateau plateau){


        if(this.caseActuelle.getY()=='a') {
            // si la case directement devant (sur la meme ligne) est libre:
            if(plateau.isOccuped(this.caseActuelle.getX()+1,'a')==false){
                plateau.getCase(this.caseActuelle.getX()+1, this.caseActuelle.getY()).modifierOccupee();
                this.caseActuelle.modifierOccupee();
                // la fonction lierCasesException permet de changer le statut d'un groupe de cases
                // en meme temps (pour les tournants par exemple, ou un groupe de cases evolue de la meme
                //maniere:
                // lorsque l'on quitte la case reliée aux autres:
                plateau.lierCasesException(this.caseActuelle);

                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'a'));

                // pour checker si la case sur laquelle on est correspond à un tournant ou une autre case "exception"
                //et ainsi adapter la caseActuelle de la voiture en fonction


                // sinon regarder si la case b de la colonne suivante est libre:
            }else if (plateau.isOccuped(this.caseActuelle.getX()+1,'b')==false) {
                plateau.getCase(this.caseActuelle.getX()+1, 'b').modifierOccupee();
                this.caseActuelle.modifierOccupee();
                plateau.lierCasesException(this.caseActuelle);
                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'b'));



                // sinon regarder si la case c de la colonne suivante est libre:
                // si oui, déplacer la voiture sur la ligne 'b' de la colonne actuelle, pour la faire passer par la case C le prochain coup
            }else if(plateau.isOccuped(this.caseActuelle.getX()+1,'c')==false) {
                if(plateau.isOccuped(this.caseActuelle.getX(),'b')==false) {
                    plateau.getCase(this.caseActuelle.getX(), 'b').modifierOccupee();
                    this.caseActuelle.modifierOccupee();
                    plateau.lierCasesException(this.caseActuelle);
                    this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX(),'b'));

                }
            }


        }else if (this.caseActuelle.getY()=='b') {
            // si la case a de la colonne suivante est libre:
            if(plateau.isOccuped(this.caseActuelle.getX()+1,'a')==false){
                plateau.getCase(this.caseActuelle.getX()+1, 'a').modifierOccupee();
                this.caseActuelle.modifierOccupee();
                plateau.lierCasesException(this.caseActuelle);
                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'a'));


                // sinon regarder si la case b de la colonne suivante est libre:
            }else if (plateau.isOccuped(this.caseActuelle.getX()+1,'b')==false) {
                plateau.getCase(this.caseActuelle.getX()+1, 'b').modifierOccupee();
                this.caseActuelle.modifierOccupee();
                plateau.lierCasesException(this.caseActuelle);
                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'b'));


                // sinon regarder si la case c de la colonne suivante est libre:
            }else if(plateau.isOccuped(this.caseActuelle.getX()+1,'c')==false) {
                plateau.getCase(this.caseActuelle.getX()+1, 'c').modifierOccupee();
                this.caseActuelle.modifierOccupee();
                plateau.lierCasesException(this.caseActuelle);
                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'c'));

            }

        }else if (this.caseActuelle.getY()=='c') {
            // si la case 'b' de la colonne suivante est libre:
            if(plateau.isOccuped(this.caseActuelle.getX()+1,'b')==false){
                plateau.getCase(this.caseActuelle.getX()+1, 'b').modifierOccupee();
                this.caseActuelle.modifierOccupee();
                plateau.lierCasesException(this.caseActuelle);
                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'b'));
                plateau.lierCasesException(this.caseActuelle);

                // sinon regarder si la case c de la colonne suivante est libre:
            }else if (plateau.isOccuped(this.caseActuelle.getX()+1,'c')==false) {
                plateau.getCase(this.caseActuelle.getX()+1, 'c').modifierOccupee();
                this.caseActuelle.modifierOccupee();
                plateau.lierCasesException(this.caseActuelle);
                this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'c'));


                // sinon regarder si la case a de la colonne suivante est libre:
                // si oui, déplacer la voiture sur la ligne 'b' de la colonne actuelle, pour la faire passer par la case 'a' au prochain coup
            }else if(plateau.isOccuped(this.caseActuelle.getX()+1,'a')==false) {
                if (plateau.isOccuped(this.caseActuelle.getX(),'b')==false) {
                    plateau.getCase(this.caseActuelle.getX(), 'b').modifierOccupee();
                    this.caseActuelle.modifierOccupee();
                    plateau.lierCasesException(this.caseActuelle);
                    this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX(),'b'));

                }
            }

        }
        // lorsque l'on arrive sur une case reliée aux autres:
        plateau.lierCasesException(this.caseActuelle);
        // pour gerer les exceptions dues aux entrées de tournants:
        this.deplacementException(plateau);


        return this.caseActuelle;

    }

    /**
     *focntion qui permet de savoir si une ligne jaune a été franchie
     * @param i (nombre de déplacements qu'il reste à la voiture de faire
     * @return le numéro de la ligne qui a été franchie ou 0 si aucune n'est franchie
     */
    public int ligneJaune(int idPartie, String couleurJ){
        int numeroLigne=0;
        List<PartieCase> listPosJoueur = GameLibrary.getInstance().getXYByIdPartie(idPartie);
        int voiturePassee=0; //position de la voiture la plus loin
        int compteur=0; //nb de gens qui on déjà passé le ligne d'arrivé
        for (int j = 0 ; j < 6 ; j++){
            if (listPosJoueur.get(j).getX() > voiturePassee){
                voiturePassee = listPosJoueur.get(j).getX();
            }
            if (listPosJoueur.get(j).getX() == 69){
                compteur++;
            }
        }
        if (this.caseActuelle.getX()==14 && voiturePassee<15){
            numeroLigne=1;
        } else if (this.caseActuelle.getX()==26 && voiturePassee<27){
            numeroLigne=2;
        } else if (this.caseActuelle.getX()==38 && voiturePassee<38){
            numeroLigne=3;
        } else if (this.caseActuelle.getX()==68){ // la voiture à dépassé la ligne d'arrivée
            int posFinal = 6-compteur;
            positionPariDao.nouvellePositionPari(4, idPartie,couleurJ,posFinal,"a");

            //changer la case du joueur dans la bdd
            Joueur joujou = new Joueur(couleurJ,"bob",caseActuelle,idPartie,"caca",10);
            PartieCase paCse = new PartieCase(69,'a',idPartie,false);
            GameLibrary.getInstance().changerCase(joujou,paCse);

            List<PartieCase> listPosJoueur2 = GameLibrary.getInstance().getXYByIdPartie(idPartie);
            boolean toutesArrivées = true;
            for (int j = 0 ; j < 6 ; j++){
                if (listPosJoueur2.get(j).getX() != 69){
                    toutesArrivées = false;
                }
            }
            if (toutesArrivées == true){// toute les voitures ont dépassés la ligne d'arrivée
                numeroLigne = 4;
            }
        }
        return numeroLigne;
    }

    /**
     * fonction qui permet de déplacer la voiture
     * @param nbreCase (nombre de déplacement à effectuer)
     * @param plateau (le plateau sur lequel evolue la voitures (avec les cases déjà occupées)
     * @return la nouvelle case de la voiture et donc du joueur
     */

    public PartieCase deplacer(int nbreCase, Plateau plateau){
        PartieCase ancienne=this.caseActuelle;
        PartieCase cse=null;
        List listPositionJoueur=joueurDao.listOfPosition(this.idPartie);


        for(int i=0;i<nbreCase;i++){
            if (this.caseActuelle.getX()==69){
                return caseActuelle;
            }

            //regarde si une ligne jaune va etre dépassée
            if (this.ligneJaune(this.idPartie, this.couleur)==1){
                for(int j=0;j<listPositionJoueur.size();j++){
                    List element=(List) listPositionJoueur.get(j);
                    String couleur=(String) element.get(0);
                    int x=(int) element.get(1);
                    String y=(String) element.get(2);
                    positionPariDao.nouvellePositionPari(1,this.idPartie,couleur,x, y);
                }
                partieDao.changeEtatActuel(this.idPartie,"ligneJaune1");
                GameLibrary.getInstance().calculPari(this.idPartie,1);

            }else if (this.ligneJaune( this.idPartie, this.couleur)==2){
                for(int j=0;j<listPositionJoueur.size();j++){
                    List element=(List) listPositionJoueur.get(j);
                    String couleur=(String) element.get(0);
                    int x=(int) element.get(1);
                    String y=(String) element.get(2);
                    positionPariDao.nouvellePositionPari(2,this.idPartie,couleur,x, y);
                }
                partieDao.changeEtatActuel(this.idPartie,"ligneJaune2");
                GameLibrary.getInstance().calculPari(this.idPartie,2);
            }else if (this.ligneJaune(this.idPartie, this.couleur)==3){
                for(int j=0;j<listPositionJoueur.size();j++){
                    List element=(List) listPositionJoueur.get(j);
                    String couleur=(String) element.get(0);
                    int x=(int) element.get(1);
                    String y=(String) element.get(2);
                    positionPariDao.nouvellePositionPari(3,this.idPartie,couleur,x, y);
                    }
                partieDao.changeEtatActuel(this.idPartie,"ligneJaune3");
                GameLibrary.getInstance().calculPari(this.idPartie,3);

            }else if (this.ligneJaune(this.idPartie, this.couleur)==4){
                for(int j=0;j<listPositionJoueur.size();j++){
                    List element=(List) listPositionJoueur.get(j);
                    String couleur=(String) element.get(0);
                    int x=(int) element.get(1);
                    String y=(String) element.get(2);
                    positionPariDao.nouvellePositionPari(4,this.idPartie,couleur,x, y);
                }
                    partieDao.changeEtatActuel(this.idPartie,"ligneFinale");
                    GameLibrary.getInstance().calculFinal(this.idPartie,4);

            }

            // si la case suivante correspond à un rétrécissement de plateau:
            if (plateau.exception(this.caseActuelle).equals("retrecissement")) {
                // si on est en a, on ne peut pas accèder à 'b' de la colonne suivante, on ne peut que
                //rester sur la ligne 'a':
                if (plateau.isOccuped(this.caseActuelle.getX()+1,'a')==false){
                    plateau.getCase(this.caseActuelle.getX()+1, 'a').modifierOccupee();
                    this.caseActuelle.modifierOccupee();
                    this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'a'));
                    // si la case 'b' de la colonne suivante est libre, alors on regarde si la case 'b' de la colonne actuelle
                    // est libre. Si oui, on va dessus pour pouvoir, le tour d'après, accéder à la case 'b' de la colonne suivante
                }else if (plateau.isOccuped(this.caseActuelle.getX()+1,'b')==false){
                    if(plateau.isOccuped(this.caseActuelle.getX(),'b')==false) {
                        plateau.getCase(this.caseActuelle.getX(), 'b').modifierOccupee();
                        this.caseActuelle.modifierOccupee();
                        this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX(),'b'));
                    }
                }


            }else if (plateau.exception(this.caseActuelle).equals("agrandissement")) {
                // si on est en b, on ne peut pas accèder à 'a' de la colonne suivante, on ne peut que
                //rester sur la ligne 'b':
                if (plateau.isOccuped(this.caseActuelle.getX()+1,'b')==false){
                    plateau.getCase(this.caseActuelle.getX()+1, 'b').modifierOccupee();
                    this.caseActuelle.modifierOccupee();
                    this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX()+1,'b'));
                    if (i == nbreCase-1){
                        cse = this.caseActuelle;
                    }
                    // si la case 'a' de la colonne suivante est libre, alors on regarde si la case 'a' de la colonne actuelle
                    // est libre. Si oui, on va dessus pour pouvoir, le tour d'après, accéder à la case 'a' de la colonne suivante
                }else if (plateau.isOccuped(this.caseActuelle.getX()+1,'a')==false){
                    if(plateau.isOccuped(this.caseActuelle.getX(),'a')==false) {
                        plateau.getCase(this.caseActuelle.getX(), 'a').modifierOccupee();
                        this.caseActuelle.modifierOccupee();
                        this.setCaseActuelle(plateau.getCase(this.caseActuelle.getX(),'a'));
                    }
                }
            }else{
                if (this.caseActuelle.getX()==68){
                    this.caseActuelle.setX(69);
                    this.caseActuelle.setY('a');
                    return caseActuelle;
                }else{
                    this.deplacementSeul(plateau);
                }

            }

            if (i == nbreCase-1){
                cse = this.caseActuelle;
            }
        }

        GameLibrary.getInstance().modifierCaseException(ancienne,false);
        GameLibrary.getInstance().modifierCaseException(cse,true);
        //System.out.println("case d'arrivé de la fonction est "+cse.getX()+","+cse.getY());

        return cse;
    }




    public void deplacementOptimise(Plateau plateau, int nbreCase){
        int x=this.caseActuelle.getX();
        char y=this.caseActuelle.getY();
        boolean bloqueC=false;
        boolean bloqueA=false;
        int caseBloquanteCX=0;
        char caseBloquanteCY='a';
        int caseBloquanteAX = 0;
        char caseBloquanteAY ='a';
        for (int i=1;i<nbreCase;i++){
            if(plateau.getCase(x+i,'b').isOccupee()==false){
                this.deplacementSeul(plateau);

        }else {
                if (plateau.getCase(x+i,'a').isOccupee()==false){
                    this.deplacementSeul(plateau);
                }else { caseBloquanteAX = x + i;
                        caseBloquanteAY = 'a';
                        for(int j=1;j<nbreCase;j++){
                            if(plateau.getCase(x+i,'c').isOccupee()==true) {
                                caseBloquanteCX = x + i;
                                caseBloquanteCY = 'c';
                                bloqueC = true;
                            }
                        }
                }
            }

        }if (bloqueC==true){
            if(caseBloquanteCX>caseBloquanteAX){

            }
        }
    }



}
