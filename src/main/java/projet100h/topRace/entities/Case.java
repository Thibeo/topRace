package projet100h.topRace.entities;

import java.util.ArrayList;

public class Case {
    private int x;
    private char y;
    private boolean occupee;
    private float top;
    private float left;
    private int rotate;


    public Case(int x, char y, boolean occupee, float top, float left, int rotate){
        this.x=x;
        this.y=y;
        this.occupee=occupee;
        this.top=top;
        this.left=left;
        this.rotate=rotate;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public char getY() { return y; }
    public void setY(char x) { this.y = y; }

    public boolean isOccupee() { return occupee; }
    public void setOccupee(boolean occupee) { this.occupee = occupee; }

    public float getTop() { return top; }
    public void setTop(float top) { this.top = top; }

    public float getLeft() { return left; }
    public void setLeft(float left) { this.left = left; }


}
