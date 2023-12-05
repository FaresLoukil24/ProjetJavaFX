package Entite;

public class ListDemandesPublicationEvenemenets {

    private int id_demande;

    @Override
    public String toString() {
        return "ListDemandesPublicationEvenemenets{" +
                "id_demande=" + id_demande +
                ", nom_evenemnt='" + nom_evenemnt + '\'' +
                '}';
    }

    private String nom_evenemnt;

    public ListDemandesPublicationEvenemenets(int id_demande, String nom_evenemnt) {
        this.id_demande = id_demande;
        this.nom_evenemnt = nom_evenemnt;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public String getNom_evenemnt() {
        return nom_evenemnt;
    }

    public void setNom_evenemnt(String nom_evenemnt) {
        this.nom_evenemnt = nom_evenemnt;
    }
}
