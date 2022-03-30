/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author rahma
 */
public class EvenementCRUD implements EvenementInterface {
    Connection cnx2 ;
    public EvenementCRUD() {
    cnx2 = MyConnection.getInstance().getCnx();
    }
    @Override
    public void AjouterEvenement() {
        try {
            String requete = "INSERT INTO evenement( nomEvent , date) VALUES ('new year' , '1/1/2022')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("évènement ajouté avec succès ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           
        }

    }
@Override
    public void AjouterEvenement2(Evenement E) {
        try {
            String requete2 = "INSERT INTO evenement( nomEvent , date) VALUES (?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, E.getNomEvent());
            pst.setString(2, E.getDate());
            pst.executeUpdate();
            System.out.println("l'événement est ajouter !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
@Override
    public List<Evenement> AfficherEvenement() {
       List<Evenement> myList1 = new ArrayList<> ();
        try {
            
            String requete3=" SELECT * FROM evenement";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
           Evenement e = new Evenement();
           e.setIdEvent(1);
           e.setNomEvent(rs.getString("nomEvent"));
           e.setNomEvent(rs.getString("date"));
           myList1.add(e);
           }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             ex.printStackTrace();
        }
        return myList1 ;
    }
@Override
    public void supprimer(Evenement E) {
        try {
            String req = "DELETE FROM personne where id=" + E.getIdEvent();
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void modifier(Evenement  E) {
        try {
            String req = "UPDATE Event SET date='" + E.getDate() + "'nom'" + E.getNomEvent() + "' WHERE id=" + E.getIdEvent();
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne modifée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
