package projet100h.topRace.entities;

public class Case {
    private int x;
    private char y;
    private boolean occupee;
    private int top;
    private int left;

    public Case(Integer x, Character y, Boolean occupee, Integer top, Integer left){
        super();
        this.x=x;
        this.y=y;
        this.occupee=occupee;
        this.top=top;
        this.left=left;
    }

    public Integer getX() { return x; }
    public void setX(Integer x) { this.x = x; }

    public Character getY() { return y; }
    public void setY(Character x) { this.y = y; }

    public boolean isOccupee() { return occupee; }
    public void setOccupee(boolean occupee) { this.occupee = occupee; }

    public Integer getTop() { return top; }
    public void setTop(Integer top) { this.top = top; }

    public Integer getLeft() { return left; }
    public void setLeft(Integer left) { this.left = left; }

}
