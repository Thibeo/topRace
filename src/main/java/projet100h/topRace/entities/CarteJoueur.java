package projet100h.topRace.entities;

public class CarteJoueur {

    private int idCarte;
    private int idPartie;
    private String CouleurJ;
    private boolean utilisee;

    public CarteJoueur(int idCarte, int idPartie, String couleurJ, boolean utilisee) {
        this.idCarte = idCarte;
        this.idPartie = idPartie;
        CouleurJ = couleurJ;
        this.utilisee = utilisee;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public int getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public String getCouleurJ() {
        return CouleurJ;
    }

    public void setCouleurJ(String couleurJ) {
        CouleurJ = couleurJ;
    }

    public boolean isUtilisee() {
        return utilisee;
    }

    public void setUtilisee(boolean utilisee) {
        this.utilisee = utilisee;
    }
}
