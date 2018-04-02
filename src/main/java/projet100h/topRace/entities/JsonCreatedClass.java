package projet100h.topRace.entities;

public class JsonCreatedClass {

    private String couleurJ;
    private int idPartie;
    private String data;

    public JsonCreatedClass(String couleurJ, int idPartie, String data) {
        this.couleurJ = couleurJ;
        this.idPartie = idPartie;
        this.data = data;
    }

    public String getCouleur() {
        return couleurJ;
    }

    public void setCouleurJ(String couleurJ) {
        this.couleurJ = couleurJ;
    }

    public int getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
