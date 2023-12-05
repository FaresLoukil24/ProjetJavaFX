package Services;

import Entite.ListDemandesPublicationEvenemenets;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListDemandesPublicationEvenementsService implements IService<ListDemandesPublicationEvenemenets> {

    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public ListDemandesPublicationEvenementsService() {
        try {
            ste = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void ajouter(ListDemandesPublicationEvenemenets listDemandesPublicationEvenemenets) throws SQLException {
        String req = "INSERT INTO `listdemandespublicationevenements` (`id_demande`, `nom_evenemnt`) VALUES (NULL, '"
                + listDemandesPublicationEvenemenets.getNom_evenemnt() + "');";
        int res = ste.executeUpdate(req);
    }

    @Override
    public void update(ListDemandesPublicationEvenemenets listDemandesPublicationEvenemenets) throws SQLException {
        // Assuming there is no need to update in this case
    }

    @Override
    public void delete(int id) throws SQLException {
        String req = "DELETE FROM `listdemandespublicationevenements` WHERE `id_demande` = " + id;
        int res = ste.executeUpdate(req);
    }

    @Override
    public ArrayList<ListDemandesPublicationEvenemenets> readAll() throws SQLException {
        ArrayList<ListDemandesPublicationEvenemenets> list = new ArrayList<>();
        try {
            ResultSet resultSet = ste.executeQuery("SELECT * FROM listdemandespublicationevenements");
            while (resultSet.next()) {
                int id = resultSet.getInt("id_demande");
                String nom_evenement = resultSet.getString("nom_evenemnt");
                ListDemandesPublicationEvenemenets l = new ListDemandesPublicationEvenemenets(id, nom_evenement);
                list.add(l);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public ListDemandesPublicationEvenemenets get(int id) throws SQLException {
        ListDemandesPublicationEvenemenets listDemandesPublicationEvenemenets = null;
        try {
            ResultSet resultSet = ste.executeQuery("SELECT * FROM listdemandespublicationevenements WHERE id_demande = " + id);
            if (resultSet.next()) {
                String nom_evenement = resultSet.getString("nom_evenemnt");
                listDemandesPublicationEvenemenets = new ListDemandesPublicationEvenemenets(id, nom_evenement);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listDemandesPublicationEvenemenets;



    }
}
