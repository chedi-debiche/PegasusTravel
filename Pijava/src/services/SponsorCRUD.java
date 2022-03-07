/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Sponsor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author rahma
 */
public class SponsorCRUD implements SponsorInterface {

    Connection cnx3;

    public SponsorCRUD() {
        cnx3 = MyConnection.getInstance().getCnx();
    }

    @Override
    public void AjouterSponsor(Sponsor S) {
        try {
            String requete2 = "INSERT INTO sponsor( nomS , prenomS , descriptionS ,imageS) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx3.prepareStatement(requete2);
            pst.setString(1, S.getNomS());
            pst.setString(2, S.getPrenomS());
            pst.setString(3, S.getDescriptionS());
            pst.setString(4, S.getImageS());
            pst.executeUpdate();
            System.out.println("sponsor est ajouter !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Sponsor> AfficherSponsor() {
        ObservableList<Sponsor> list = FXCollections.observableArrayList();
        try {

            String requete3 = " SELECT * FROM sponsor ";
            Statement st = cnx3.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Sponsor s = new Sponsor();
                s.setIdS(rs.getInt("idS"));
                s.setNomS(rs.getString("nomS"));
                s.setPrenomS(rs.getString("prenomS"));
                s.setDescriptionS(rs.getString("descriptionS"));
                s.setImageS(rs.getString("imageS"));

                list.add(s);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return list;

    }

    @Override
    public void supprimerSponsor(Sponsor S) {
        try {
            String req = "DELETE FROM sponsor WHERE nomS=?";
            PreparedStatement pst = cnx3.prepareStatement(req);
            pst.setString(1, S.getNomS());
            pst.executeUpdate();
            System.out.println("sponsor suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierSponsor(Sponsor S) {
        try {
            String requete4 = "update sponsor set nomS=?,prenomS=?,descriptionS=?, imageS=?  where idS=? ";

            PreparedStatement pst = cnx3.prepareStatement(requete4);

            pst.setString(1, S.getNomS());
            pst.setString(2, S.getPrenomS());
            pst.setString(3, S.getDescriptionS());
            pst.setString(4, S.getImageS());
            pst.setInt(5, S.getIdS());

            int ok = pst.executeUpdate();

            if (ok == -1) {
                System.out.println("Insertion Sponsor failed");
            } else {
                System.out.println("Insertion Sponsor succes ! ");
            }
            System.out.println(" Sponsor modifié avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList <Sponsor>  rechercheSponsor(String nom) {
         ObservableList<Sponsor> list = FXCollections.observableArrayList();
        try {
            
            String requete3 = " SELECT * FROM sponsor WHERE nomS=?";
           PreparedStatement pst =cnx3.prepareStatement(requete3);
           pst.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            Sponsor s = new Sponsor();
            while (rs.next()) {
                s.setIdS(rs.getInt(1));
                s.setNomS(rs.getString("nomS"));
                s.setPrenomS(rs.getString("prenomS"));
                s.setDescriptionS(rs.getString("descriptionS"));
                s.setImageS(rs.getString("imageS"));
                list.add(s);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return list;

    }

}
