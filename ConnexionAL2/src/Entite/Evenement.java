package Entite;

public class Evenement {
    private int id_evenement;
    private String titre;
    private String description;
    private String nom_club;


    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getNom_club() {
        return nom_club;
    }

    public Evenement(int id_evenement, String titre, String description, String nom_club) {
        this.id_evenement = id_evenement;
        this.titre = titre;
        this.description = description;
        this.nom_club = nom_club;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id_evenement=" + id_evenement +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", nom_club='" + nom_club + '\'' +
                '}';
    }
}
