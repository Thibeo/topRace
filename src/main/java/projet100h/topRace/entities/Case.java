package projet100h.topRace.entities;

import java.util.ArrayList;

public class Case {
    private int x;
    private char y;
    private boolean occupee;
    private int top;
    private int left;


    public Case(int x, char y, boolean occupee, int top, int left){
        this.x=x;
        this.y=y;
        this.occupee=occupee;
        this.top=top;
        this.left=left;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public char getY() { return y; }
    public void setY(char x) { this.y = y; }

    public boolean isOccupee() { return occupee; }
    public void setOccupee(boolean occupee) { this.occupee = occupee; }

    public int getTop() { return top; }
    public void setTop(int top) { this.top = top; }

    public int getLeft() { return left; }
    public void setLeft(int left) { this.left = left; }


}
