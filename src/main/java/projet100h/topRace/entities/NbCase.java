package projet100h.topRace.entities;

public class NbCase {

    private String couleur;
    private int idCarte;
    private int nbCase;

    public NbCase(String couleur, Integer idCarte, Integer nbCase){
        super();
        this.couleur=couleur;
        this.idCarte=idCarte;
        this.nbCase=nbCase;
    }

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public Integer getIdCarte() { return idCarte; }
    public void setIdCarte(Integer idCarte) { this.idCarte = idCarte; }

    public Integer getNbCase() { return nbCase; }
    public void setNbCase(Integer nbCase) { this.nbCase = nbCase; }
}
