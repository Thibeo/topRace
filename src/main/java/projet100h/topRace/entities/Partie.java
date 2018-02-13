package projet100h.topRace.entities;

public class Partie {
    private Case tableauCase[][];


    public void setTableauCase(Case [][] tableau) {
        this.tableauCase=tableau;
    }





    public boolean isOccuped(int x,char y){
        Case caseAChecke=null;
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


    public Case getCase(int x, char y) {
        int b=0;
        if (y=='b') {
            b=1;
        } else if (y=='c') {
            b=2;
        }
        //System.out.println("x: "+this.tableauCase[x][b].getX()+" y:"+this.tableauCase[x][b].getY());
        return this.tableauCase[x][b];
    }

    public String exception(Case cse) {
        int x=cse.getX();
        char y=cse.getY();
        if((x==4 && y=='a') || (x==12 && y=='a') || (x==24 && y=='a')) {
            return "retrecissement";
        }else if((x==8 && y=='b') || (x==17 && y=='b') || (x==43 && y=='b')) {
            return "agrandissement";
        }
        else if ((x==6 && y=='a') || (x==14 && y=='a')) {
            return "tournant a l interieur";
        }
        else if ((x==52 && y=='c') ||(x==50 && y=='c') || (x==54 && y=='c') || (x==59 && y=='c') || (x==57 && y=='c') || (x==61 && y=='c')) {
            return "dernier tournant a l'extérieur";
        }
        else if ((x==50 && y=='a') || (x==57 && y=='a')) {
            return "dernier tournant a l'interieur debut";
        }
        else if ((x==53 && y=='a') || (x==60 && y=='a')) {
            return "dernier tournant a l'interieur milieu";
        }
        else if ((x==50 && y=='b') || (x==53 && y=='b') || (x==57 && y=='b') || (x==60 && y=='b')) {
            return "dernier tournant au milieu debut";
        }
        else if ((x==54 && y=='b') || (x==61 && y=='b')) {
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
    public void lierCasesException(Case cse) {
        int x=cse.getX();
        char y=cse.getY();

        // deux premiers tournants à l'intérieur: une case équivaut à deux colonnes
        if ((x==7 && y=='a') || (x==15 && y=='a')) {
            if (cse.isOccupee()==true) {
                this.tableauCase[cse.getX()-1][0].setOccupee(true);
            }else{
                this.tableauCase[cse.getX()-1][0].setOccupee(false);
            };


            // dernier tournant extérieur: une case équivaut à deux colonnes
        }else if ((x==51 && y=='c') || (x==53 && y=='c') || (x==55 && y=='c') || (x==58 && y=='c') || (x==60 && y=='c') || (x==62 && y=='c')) {
            if (cse.isOccupee()==true) {
                this.tableauCase[cse.getX()-1][2].setOccupee(true);
            }else{
                this.tableauCase[cse.getX()-1][2].setOccupee(false);
            };
            // dernier tournant milieu: une case équivaut à trois colonnes
            // entrée par la case du début:
        }else if ((x==52 && y=='b') || (x==55 && y=='b') || (x==59 && y=='b') || (x==62 && y=='b')) {
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
        }else if ((x==54 && y=='b') || (x==61 && y=='b')) {
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
        }else if ((x==55 && y=='a') || (x==62 && y=='a')) {
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
        }else if ((x==53 && y=='a') || (x==60 && y=='a')) {
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
