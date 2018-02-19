package projet100h.topRace.entities;

public class PartieCase{

    private int x;
    private char y;
    private int idPartie;
    private boolean occupee;


    public PartieCase(int x, char y, int idPartie, boolean occupee){
        this.x=x;
        this.y=y;
        this.idPartie=idPartie;
        this.occupee=occupee;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public char getY() { return y; }
    public void setY(char x) { this.y = y; }

    public int getIdPartie() { return idPartie; }
    public void setIdPartie(int idPartie) { this.idPartie = idPartie; }

    public boolean isOccupee() { return occupee; }
    public void setOccupee(boolean occupee) { this.occupee = occupee; }

    public void modifierOccupee() {
        if (this.occupee == true) {
            this.occupee = false;

        } else {
            this.occupee = true;
        }
    }

}
