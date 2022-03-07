/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.ReservationEvenement;
import java.sql.Connection;
import java.sql.Date;
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
public class ReservationEvenementCRUD implements ReservationEvenementInterface {

       Connection cnx3;
       public ReservationEvenementCRUD() {
    cnx3 = MyConnection.getInstance().getCnx();
    }
@Override
    public void AjouterRE (ReservationEvenement RE) {
            try {
            String requete2 = "INSERT INTO ReservationEvenement( nomRE , dateRE  ,idEvent) VALUES (?,?,?)";
            PreparedStatement pst = cnx3.prepareStatement(requete2);
            pst.setString(1, RE.getNomRE());
            pst.setDate(2, RE.getdateRE());
            
            pst.setInt(3, RE.getIdEvent());
            pst.executeUpdate();
            System.out.println("la réservation est ajoutée !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
@Override
 
    public ObservableList<ReservationEvenement> AfficherRE() {
       ObservableList<ReservationEvenement> myList1 = FXCollections.observableArrayList();
        try {
            
            String requete3=" SELECT * FROM reservationevenement";
            Statement st = cnx3.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
           ReservationEvenement e = new ReservationEvenement();
           e.setIdRE(rs.getInt("idRE"));
           e.setNomRE(rs.getString("nomRE"));
           e.setdateRE (rs.getDate("dateRE"));
           e.setIdEvent (rs.getInt("idEvent"));
           myList1.add(e);
           }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             ex.printStackTrace();
        }
        return myList1 ;
    }
@Override
    public void supprimer(ReservationEvenement RE) {
        try {
            String req = "DELETE FROM reservationevenement WHERE nomRE=?";
            PreparedStatement pst = cnx3.prepareStatement(req);
            pst.setString(1, RE.getNomRE());
            pst.executeUpdate();
            System.out.println("réservation suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//    @Override
//    public void modifierRE(ReservationEvenement RE) {
//          
//         try {
//            String requete4 = "update reservationevenement set nomRE=? ,dateRE=?   where idRE=? ";
//
//
//            PreparedStatement pst = cnx3.prepareStatement(requete4);
//            pst.setString(1, RE.getNomRE());
//            pst.setDate(2, RE.getdateRE());
////            pst.setFloat(3,RE.getPrixRE());
//          // pst.setInt(4, RE.getIdEvent());
//            pst.setInt(3, RE.getIdRE());
//            int ok = pst.executeUpdate();
//
//            if (ok == -1) {
//                System.out.println("Insertion produit failed");
//            } else {
//                System.out.println("Insertion produit succes ! ");
//            }
//            System.out.println("Evenement modifiée avec succès");
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        }S
public ObservableList<ReservationEvenement> rechercheReservationEvenement(String nom) {
      ObservableList<ReservationEvenement> list = FXCollections.observableArrayList();
        try {
            String requete3 = "SELECT  * FROM reservationevenement WHERE nomRE=? ";
            PreparedStatement pst = cnx3.prepareStatement(requete3);
           pst.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            ReservationEvenement e = new ReservationEvenement();
            rs.first();
             e.setIdRE(rs.getInt(1));
           e.setIdRE(rs.getInt("idRE"));
           e.setNomRE(rs.getString("nomRE"));
           e.setdateRE (rs.getDate("dateRE"));
//           e.setPrixRE(rs.getFloat("prixRE"));
           e.setIdEvent (rs.getInt("idEvent"));
           list.add(e);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
               
public ObservableList<ReservationEvenement> rechercheParIdEvent (int idevent) {
       ObservableList <ReservationEvenement> listReservationEvenement = FXCollections.observableArrayList();;
         try {
            String query = "SELECT * FROM reservationevenement where idEvent="+idevent;
            Statement st = cnx3.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ReservationEvenement e = new ReservationEvenement();
                e.setIdRE(rs.getInt(1));
                e.setNomRE(rs.getString("nomRE"));
                e.setdateRE(rs.getDate("dateRE"));
//                e.setPrixRE(rs.getFloat("prixRE"));
                e.setIdEvent(rs.getInt("idEvent"));
                 
                listReservationEvenement.add(e);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listReservationEvenement;
    }
//public float calculPromotion (ReservationEvenement r  ) 
//{
//  float  prix = r.getPrixRE();
//    ReservationEvenementCRUD re = new ReservationEvenementCRUD () ;
//    if (( r.getDate().getDay()==14 && r.getDate().getMonth()==02 )||( r.getDate().getDay()==30 && r.getDate().getMonth()==11 )||(r.getDate().getDay()==01 && r.getDate().getMonth()==01)){
//        prix= (float) (prix*(0.2*prix));
//        System.out.println("le nouveau prix est : "+prix);
//    }
//    return prix;
//}

}
