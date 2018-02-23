package projet100h.topRace.entities;

import projet100h.topRace.dao.PartieCaseDao;
import projet100h.topRace.dao.impl.PartieCaseDaoImpl;

public class Plateau {
    private PartieCase tableauCase[][];


    public void setTableauCase(PartieCase [][] tableau) {
        this.tableauCase=tableau;
    }


    public boolean isOccuped(int x,char y){
        PartieCase caseAChecke=null;
        for(int i=0;i<this.tableauCase.length;i++){
            for(int j=0;j<this.tableauCase[1].length;j++){
                if(i==x && y==tableauCase[x][j].getY()){
                    caseAChecke=this.tableauCase[i][j];
                }
            }
        }
        boolean resultat=caseAChecke.isOccupee();
        return (resultat);
    }


    public PartieCase getCase(int x, char y) {
        int b=0;
        if (y=='b') {
            b=1;
        } else if (y=='c') {
            b=2;
        }
        //System.out.println("x: "+this.tableauCase[x][b].getX()+" y:"+this.tableauCase[x][b].getY());
        return this.tableauCase[x][b];
    }

    public String exception(PartieCase cse) {
        int x=cse.getX();
        char y=cse.getY();
        if((x==6 && y=='a') || (x==14 && y=='a') || (x==26 && y=='a')) {
            return "retrecissement";
        }else if((x==10 && y=='b') || (x==19 && y=='b') || (x==45 && y=='b')) {
            return "agrandissement";
        }
        else if ((x==8 && y=='a') || (x==16 && y=='a')) {
            return "tournant a l interieur";
        }
        else if ((x==54 && y=='c') ||(x==52 && y=='c') || (x==56 && y=='c') || (x==61 && y=='c') || (x==59 && y=='c') || (x==62 && y=='c')) {
            return "dernier tournant a l'extérieur";
        }
        else if ((x==52 && y=='a') || (x==59 && y=='a')) {
            return "dernier tournant a l'interieur debut";
        }
        else if ((x==55 && y=='a') || (x==62 && y=='a')) {
            return "dernier tournant a l'interieur milieu";
        }
        else if ((x==52 && y=='b') || (x==55 && y=='b') || (x==59 && y=='b') || (x==62 && y=='b')) {
            return "dernier tournant au milieu debut";
        }
        else if ((x==56 && y=='b') || (x==63 && y=='b')) {
            return "dernier tournant au milieu milieu";
        }
        else {
            return "pas d'exception";
        }

    }

    /* en entrée: la case dont le statut fait évoluer le statut d'autres cases
     * permet de changer le statut de deux ou plusieurs cartes en meme temps
     *
     */
    public void lierCasesException(PartieCase cse) {
        int x=cse.getX();
        char y=cse.getY();

        // deux premiers tournants à l'intérieur: une case équivaut à deux colonnes
        if ((x==9 && y=='a') || (x==17 && y=='a')) {
            if (cse.isOccupee()==true) {
                this.tableauCase[cse.getX()-1][0].setOccupee(true);
            }else{
                this.tableauCase[cse.getX()-1][0].setOccupee(false);
            };


            // dernier tournant extérieur: une case équivaut à deux colonnes
        }else if ((x==53 && y=='c') || (x==55 && y=='c') || (x==57 && y=='c') || (x==60 && y=='c') || (x==62 && y=='c') || (x==64 && y=='c')) {
            if (cse.isOccupee()==true) {
                this.tableauCase[cse.getX()-1][2].setOccupee(true);
            }else{
                this.tableauCase[cse.getX()-1][2].setOccupee(false);
            };
            // dernier tournant milieu: une case équivaut à trois colonnes
            // entrée par la case du début:
        }else if ((x==54 && y=='b') || (x==57 && y=='b') || (x==61 && y=='b') || (x==64 && y=='b')) {
            if (cse.isOccupee()==true) {
                for(int i=1;i<3;i++) {
                    this.tableauCase[cse.getX()-i][1].setOccupee(true);
                }

            }else{
                for(int i=1;i<3;i++) {
                    this.tableauCase[cse.getX()-i][1].setOccupee(false);
                }
            };
            // dernier tournant milieu: une case équivaut à trois colonnes
            //entrée par la case du mileu
        }else if ((x==56 && y=='b') || (x==63 && y=='b')) {
            if (cse.isOccupee()==true) {
                for(int i=-1;i<2;i++) {
                    this.tableauCase[cse.getX()+i][1].setOccupee(true);
                }
            }else{
                for(int i=-1;i<2;i++) {
                    this.tableauCase[cse.getX()+i][1].setOccupee(false);
                }
            };
            // dernier tournant intérieur: une case équivaut à six colonnes
            // entrée par une case du début:
        }else if ((x==57 && y=='a') || (x==64 && y=='a')) {
            if (cse.isOccupee()==true) {
                for(int i=1;i<6;i++) {
                    this.tableauCase[cse.getX()-i][0].setOccupee(true);
                }
            }else{
                for(int i=1;i<6;i++) {
                    this.tableauCase[cse.getX()-i][0].setOccupee(false);
                }
            };

            // dernier tournant intérieur: une case équivaut à six colonnes
            //entrée par une case du milieu:
        }else if ((x==55 && y=='a') || (x==62 && y=='a')) {
            if (cse.isOccupee()==true) {
                for(int i=-3;i<3;i++) {
                    this.tableauCase[cse.getX()+i][0].setOccupee(true);
                }
            }else{
                for(int i=-3;i<3;i++) {
                    this.tableauCase[cse.getX()+i][0].setOccupee(false);
                }
            };
        }
    }




}
