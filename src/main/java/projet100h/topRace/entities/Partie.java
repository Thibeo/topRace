package projet100h.topRace.entities;

public class Partie {
    int idPartie;
    String nomDePartie;
    String nomDeProprio;


    public Partie(int idPartie,String nomProprio, String nomPartie){
        this.nomDePartie=nomPartie;
        this.idPartie=idPartie;
        this.nomDeProprio=nomProprio;
    }

    public int getIdPartie() { return idPartie; }
    public void setIdPartie(int idPartie) { this.idPartie = idPartie; }

    public String getNomDePartie() { return nomDePartie; }
    public void setNomDePartie(String nomDePartie) { this.nomDePartie = nomDePartie; }

    public String getNomDeProprio() { return nomDeProprio; }
    public void setNomDeProprio(String nomDeProprio) { this.nomDeProprio = nomDeProprio; }
}
