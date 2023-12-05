package Services;

import Entite.Evenement;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EvenementService implements IService<Evenement> {

    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public EvenementService() {
        try {
            ste = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void ajouter(Evenement evenement) throws SQLException {
        String req = "INSERT INTO `evenement` (`id_evenement`, `titre`, `description`, `nom_club`) VALUES (NULL, '"
                + evenement.getTitre() + "', '" + evenement.getDescription() + "', '" + evenement.getNom_club() + "');";
        int res = ste.executeUpdate(req);
    }

    @Override
    public void update(Evenement evenement) throws SQLException {
        String req = "UPDATE `evenement` SET `titre` = '" + evenement.getTitre() + "', `description` = '"
                + evenement.getDescription() + "', `nom_club` = '" + evenement.getNom_club() + "' WHERE `id_evenement` = "
                + evenement.getId_evenement();
        int res = ste.executeUpdate(req);
    }

    @Override
    public void delete(int id) throws SQLException {
        String req = "DELETE FROM `evenement` WHERE `id_evenement` = " + id;
        int res = ste.executeUpdate(req);
    }

    @Override
    public ArrayList<Evenement> readAll() throws SQLException {
        ArrayList<Evenement> list = new ArrayList<>();
        try {
            ResultSet resultSet = ste.executeQuery("SELECT * FROM evenement");
            while (resultSet.next()) {
                int id = resultSet.getInt("id_evenement");
                String titre = resultSet.getString("titre");
                String description = resultSet.getString("description");
                String nom_club = resultSet.getString("nom_club");
                Evenement e = new Evenement(id, titre, description, nom_club);
                list.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Evenement get(int id) throws SQLException {
        Evenement evenement = null;
        try {
            ResultSet resultSet = ste.executeQuery("SELECT * FROM evenement WHERE id_evenement = " + id);
            if (resultSet.next()) {
                String titre = resultSet.getString("titre");
                String description = resultSet.getString("description");
                String nom_club = resultSet.getString("nom_club");
                evenement = new Evenement(id, titre, description, nom_club);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return evenement;
    }
}
