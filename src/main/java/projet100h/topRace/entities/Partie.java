package projet100h.topRace.entities;

public class Partie {
    Integer idPartie;
    String nomDePartie;
    String couleurDeProprio;
    String etat;


    public Partie(Integer idPartie,String nomPartie, String couleurDeProprio, String etat){
        this.nomDePartie=nomPartie;
        this.idPartie=idPartie;
        this.couleurDeProprio=couleurDeProprio;
        this.etat=etat;
    }

    public int getIdPartie() { return idPartie; }
    public void setIdPartie(int idPartie) { this.idPartie = idPartie; }

    public String getNomDePartie() { return nomDePartie; }
    public void setNomDePartie(String nomDePartie) { this.nomDePartie = nomDePartie; }

    public String getCouleurDeProprio() { return couleurDeProprio; }
    public void setCouleurDeProprio(String couleurDeProprio) { this.couleurDeProprio = couleurDeProprio; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
}
