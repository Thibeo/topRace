package projet100h.topRace.entities;

public class Partie {
    Integer idPartie;
    String nomDePartie;
    String couleurDeProprio;
    String etatActuel;
    String etatAncien;


    public Partie(Integer idPartie,String nomPartie, String couleurDeProprio, String etatActuel, String etatAncien){
        this.nomDePartie=nomPartie;
        this.idPartie=idPartie;
        this.couleurDeProprio=couleurDeProprio;
        this.etatActuel=etatActuel;
        this.etatAncien=etatAncien;
    }

    public int getIdPartie() { return idPartie; }
    public void setIdPartie(int idPartie) { this.idPartie = idPartie; }

    public String getNomDePartie() { return nomDePartie; }
    public void setNomDePartie(String nomDePartie) { this.nomDePartie = nomDePartie; }

    public String getCouleurDeProprio() { return couleurDeProprio; }
    public void setCouleurDeProprio(String couleurDeProprio) { this.couleurDeProprio = couleurDeProprio; }

    public String getEtatActuel() { return etatActuel; }
    public void setEtatActuel(String etatActuel) { this.etatActuel = etatActuel; }

    public String getEtatAncien() { return etatAncien; }
    public void setEtatAncien(String etatAncien) { this.etatAncien = etatAncien; }
}
