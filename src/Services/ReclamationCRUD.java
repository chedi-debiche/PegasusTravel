/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.Reclamation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author 21695
 */
public class ReclamationCRUD implements ReclamationInterface {

    Connection cnx2;

    public ReclamationCRUD() {
        cnx2 = MyConnection.getInstance().getCnx();
    }

    @Override
    public void AjoutReclamation2(Reclamation R) {
        try {
            String requete2 = "INSERT INTO reclamation(numero,nom,prenom,email,commentaire,dateReclamation,typeReclamation,id) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, R.getNumero());
            pst.setString(2, R.getNom());
            pst.setString(3, R.getPrenom());
            pst.setString(4, R.getEmail());
            pst.setString(5, R.getCommentaire());
            pst.setDate(6, R.getDateReclamation());
            pst.setString(7, R.getTypeReclamation());
            pst.setInt(8, R.getId());
            pst.executeUpdate();
            System.out.println("votre reclamation est ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public ObservableList<Reclamation> afficherReclamation() {
        ObservableList<Reclamation> myList = FXCollections.observableArrayList();
        try {

            String requete3 = "SELECT *FROM  Reclamation  ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Reclamation r = new Reclamation();
                r.setNumero(rs.getInt(1));
                r.setId(rs.getInt("id"));
                r.setNom(rs.getString("nom"));
                r.setPrenom(rs.getString("prenom"));
                r.setEmail(rs.getString("email"));
                r.setCommentaire(rs.getString("Commentaire"));
                r.setDateReclamation(rs.getDate("dateReclamation"));
                r.setTypeReclamation(rs.getString("typeReclamation"));
                myList.add(r);
                //Collections.sort(myList, Collections.reverseOrder());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }

    

    @Override
    public void supprimer(Reclamation R) {
        try {
            String req = "DELETE FROM reclamation where nom=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setString(1, R.getNom());
            pst.executeUpdate();
            System.out.println("Reclamation suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 

    }

    @Override
    public void modifier(Reclamation R) {
        try {
            String requete4 = "update Reclamation set nom=?,prenom=?,email=?,commentaire=?,dateReclamation=?,typeReclamation=? where numero=? ";


            PreparedStatement pst = cnx2.prepareStatement(requete4);
            pst.setString(1, R.getNom());
             pst.setString(2, R.getPrenom());
             pst.setString(3, R.getEmail());
              pst.setString(4, R.getCommentaire());
                 pst.setDate(5, R.getDateReclamation());
              pst.setString(6, R.getTypeReclamation());
           
            pst.setInt(7,R.getNumero());

            int ok = pst.executeUpdate();

            if (ok == -1) {
                System.out.println("Insertion Reclamation failed");
            } else {
                System.out.println("Insertion Reclamation succes ! ");
            }
            System.out.println("Reclamation modifiée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }

    public List<Reclamation> rechercheReclamation(int numero) {
        List<Reclamation> listReclamation = new ArrayList<>();
        try {
            String query = "SELECT * FROM reclamation where numero=?" ;
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Reclamation R = new Reclamation();
                R.setNumero(rs.getInt("numero"));
                R.setNom(rs.getString("nom"));
                R.setPrenom(rs.getString("prenom"));
                R.setEmail(rs.getString("email"));
                R.setCommentaire(rs.getString("commentaire"));
                R.setDateReclamation(rs.getDate("DateReclamation"));
                R.setTypeReclamation(rs.getString("typeReclamation"));
                listReclamation.add(R);
               Collections.sort(listReclamation, Collections.reverseOrder());
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listReclamation;
        
    }

//    public ObservableList <Reclamation>findreclamation(int test)  {
//           
//    
//        ObservableList<Reclamation> myList = FXCollections.observableArrayList();
//         try {
//            String query = "SELECT * FROM reclamation WHERE numero=? ";
//            PreparedStatement pst = cnx2.prepareStatement(query);
//            pst.setInt(1, test);
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Reclamation p = new Reclamation();
//                p.setNumero(rs.getInt(1));
//                p.setNom(rs.getString("nom"));
//                p.setPrenom(rs.getString("prenom"));
//                p.setCommentaire(rs.getString("commentaire"));
//                p.setDateReclamation(rs.getDate("dateReclamation"));
//                p.setTypeReclamation(rs.getString("typeReclamation"));
//
//
//                myList.add(p);
//            }
//          } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//           
//        }
//        
//
//            return myList;
//    }
    public int rechercheParRE(String test,String test1) {
        int numero = 0;
        try {
            String query = "SELECT numero FROM reclamation WHERE nom=? AND prenom=?";
            PreparedStatement pst = cnx2.prepareStatement(query);
            pst.setString(1, test);
            pst.setString(2, test1);
            ResultSet rs = pst.executeQuery();
            rs.first();
            numero = rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return numero;
    }
public ObservableList<Reclamation> rechercheParNom(String test) {
       // Reclamation p = new Reclamation();
         
        ObservableList<Reclamation> List = FXCollections.observableArrayList();
        try {
            String requete3 = "SELECT * FROM reclamation WHERE typeReclamation=? ";
            PreparedStatement pst = cnx2.prepareStatement(requete3);
            pst.setString(1, test);
            ResultSet rs = pst.executeQuery();
             Reclamation p = new Reclamation();
           // rs.first();
           while (rs.next()){
            p.setNumero(rs.getInt(1));
           p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCommentaire(rs.getString("commentaire"));
                p.setDateReclamation(rs.getDate("dateReclamation"));
                p.setTypeReclamation(rs.getString("typeReclamation"));
             List.add(p);
           }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return List;
    }

 public ObservableList<Reclamation> trier() {
        ObservableList<Reclamation> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM reclamation ";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Reclamation(rs.getInt("numero"), rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("commentaire"),rs.getDate("dateReclamation"),rs.getString("typeReclamation"),rs.getInt("id")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        Collections.sort(list, new MyComparatorReclamation());

        return list;
    }
class MyComparatorReclamation implements Comparator<Reclamation>{

        @Override
        public int compare(Reclamation o1, Reclamation o2) {
          return o1.getDateReclamation().compareTo(o2.getDateReclamation());
            
        }

}
}