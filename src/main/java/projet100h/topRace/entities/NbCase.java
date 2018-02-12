package projet100h.topRace.entities;

public class NbCase {

    private String couleur;
    private int idCarte;
    private int nbCase;

    public NbCase(String couleur, int idCarte, int nbCase){
        
        this.couleur=couleur;
        this.idCarte=idCarte;
        this.nbCase=nbCase;
    }

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public int getIdCarte() { return idCarte; }
    public void setIdCarte(int idCarte) { this.idCarte = idCarte; }

    public int getNbCase() { return nbCase; }
    public void setNbCase(int nbCase) { this.nbCase = nbCase; }
}
