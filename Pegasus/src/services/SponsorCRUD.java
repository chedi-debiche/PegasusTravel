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
    public void AjouterSponsor() {
        try {
            String requete = "INSERT INTO sponsor( nomS , prenomS , descriptionS) VALUES ('rahma' , 'tiss' , '100 milles dinars')";
            Statement st = cnx3.createStatement();
            st.executeUpdate(requete);
            System.out.println("sponsor ajouté avec succès ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void AjouterSponsor2(Sponsor S) {
        try {
            String requete2 = "INSERT INTO sponsor( nomS , prenomS , descriptionS) VALUES (?,?,?)";
            PreparedStatement pst = cnx3.prepareStatement(requete2);
            pst.setString(1, S.getNomS());
            pst.setString(2, S.getPrenomS());
            pst.setString(3, S.getDescriptionS());
            pst.executeUpdate();
            System.out.println("sponsor est ajouter !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

     @Override
    public List<Sponsor> AfficherSponsor() {
        List<Sponsor> myList2 = new ArrayList<>();
        try {

            String requete3 = " SELECT * FROM sponsor ";
            Statement st = cnx3.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Sponsor s = new Sponsor();
                s.setIdS(1);
                s.setNomS(rs.getString("nomS"));
                s.setPrenomS(rs.getString("prenomS"));
                s.setDescriptionS(rs.getString("descriptionS"));
                myList2.add(s);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
 
        }
        return myList2;
        
        
    }

    @Override
    public void supprimerSponsor(Sponsor S) {
        try {
            String req = "DELETE FROM sponsor where id=" + S.getIdS();
            Statement st = cnx3.createStatement();
            st.executeUpdate(req);
            System.out.println("Sponsor supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void modifierSponsor(Sponsor  S) {
        try {

            String req = "UPDATE  sponsor SET description='" + S.getDescriptionS() + "'nom'" + S.getNomS() +"'nom'" + S.getPrenomS() + "' WHERE id=" + S.getIdS();
            Statement st = cnx3.createStatement();
            st.executeUpdate(req);
            System.out.println("Sponsor modifée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
