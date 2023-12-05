package Test;

import Entite.Evenement;
import Entite.ListDemandesPublicationEvenemenets;
import Services.EvenementService;
import Services.ListDemandesPublicationEvenementsService;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EvenementService evenementService = new EvenementService();

        Evenement newEvenement = new Evenement(0, "New Event", "Event Description", "Club XYZ");
        try {
            evenementService.ajouter(newEvenement);
            System.out.println("Evenement ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'événement : " + e.getMessage());
        }

        try {
            ArrayList<Evenement> evenements = evenementService.readAll();
            System.out.println("Liste des événements :");
            for (Evenement e : evenements) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la lecture des événements : " + e.getMessage());
        }

        try {
            Evenement eventToUpdate = evenementService.get(6);
            if (eventToUpdate != null) {
                eventToUpdate.setTitre("Updated Event Title");
                eventToUpdate.setDescription("Updated Event Description");
                eventToUpdate.setNom_club("Updated Club");
                evenementService.update(eventToUpdate);
                System.out.println("Evenement mis à jour avec succès.");
            } else {
                System.out.println("Événement non trouvé pour la mise à jour.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'événement : " + e.getMessage());
        }

        try {
            evenementService.delete(2);
            System.out.println("Evenement supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'événement : " + e.getMessage());
        }

/* theni */

        ListDemandesPublicationEvenementsService demandeService = new ListDemandesPublicationEvenementsService();

        ListDemandesPublicationEvenemenets newDemande = new ListDemandesPublicationEvenemenets(0, "New Event Demand");
        try {
            demandeService.ajouter(newDemande);
            System.out.println("Demande ajoutée avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la demande : " + e.getMessage());
        }

        try {
            ArrayList<ListDemandesPublicationEvenemenets> demandes = demandeService.readAll();
            System.out.println("Liste des demandes :");
            for (ListDemandesPublicationEvenemenets d : demandes) {
                System.out.println(d);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la lecture des demandes : " + e.getMessage());
        }

        try {
            demandeService.delete(2);
            System.out.println("Demande supprimée avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la demande : " + e.getMessage());
        }

    }

}
