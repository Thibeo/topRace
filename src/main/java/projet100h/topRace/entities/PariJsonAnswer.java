package projet100h.topRace.entities;

public class PariJsonAnswer {
    private int numeroPari;
    private boolean jaune;
    private boolean bleue;
    private boolean rouge;
    private boolean violette;
    private boolean blanche;
    private boolean verte;

    public PariJsonAnswer(int numeroPari, boolean jaune, boolean bleue, boolean rouge, boolean violette, boolean blanche, boolean verte) {
        this.numeroPari = numeroPari;
        this.jaune = jaune;
        this.bleue = bleue;
        this.rouge = rouge;
        this.violette = violette;
        this.blanche = blanche;
        this.verte = verte;
    }

    public int getNumeroPari() {
        return numeroPari;
    }

    public void setNumeroPari(int numeroPari) {
        this.numeroPari = numeroPari;
    }

    public boolean isJaune() {
        return jaune;
    }

    public void setJaune(boolean jaune) {
        this.jaune = jaune;
    }

    public boolean isBleue() {
        return bleue;
    }

    public void setBleue(boolean bleue) {
        this.bleue = bleue;
    }

    public boolean isRouge() {
        return rouge;
    }

    public void setRouge(boolean rouge) {
        this.rouge = rouge;
    }

    public boolean isViolette() {
        return violette;
    }

    public void setViolette(boolean violette) {
        this.violette = violette;
    }

    public boolean isBlanche() {
        return blanche;
    }

    public void setBlanche(boolean blanche) {
        this.blanche = blanche;
    }

    public boolean isVerte() {
        return verte;
    }

    public void setVerte(boolean verte) {
        this.verte = verte;
    }
}
