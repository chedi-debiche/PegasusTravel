/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
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
 * @author 21695
 */
public class ReclamationCRUD  implements ReclamationInterface{
 Connection cnx2;
    public ReclamationCRUD() {
        cnx2= MyConnection.getInstance().getCnx();
    }
    
 @Override
  public void AjoutReclamation(){
      try {
          String requete = "INSERT INTO reclamation(nom,prenom,email,commentaire) VALUES('khitem','mathlouthi',khitem.mathlouthi@esprit.tn','')";
          Statement st = cnx2.createStatement();
          st.executeUpdate(requete);
          System.out.println("Reclamation ajoutee avec succes");
      } catch (SQLException ex) {
      System.err.println(ex.getMessage());
      }
  }  
 @Override
  public void AjoutReclamation2(Reclamation R){
        try {
            String requete2 = "INSERT INTO reclamation(nom,prenom,email,commentaire) VALUES(?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setString(1, R.getNom());
            pst.setString(2, R.getPrenom());
            pst.setString(3, R.getEmail());
            pst.setString(4, R.getCommentaire());
            pst.executeUpdate();
            System.out.println("votre reclamation est ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
          }  
 @Override
  public List <Reclamation> afficherReclamation(){
        List<Reclamation>  myList =new ArrayList<>();
      try {
            
            String requete3="SELECT *FROM  Reclamation  ";
            Statement st =cnx2.createStatement();
            ResultSet rs =st.executeQuery(requete3);
            while(rs.next()){
                Reclamation r =new Reclamation();
                r.setNumero(rs.getInt(1));
                r.setNom(rs.getString("nom"));
                r.setPrenom(rs.getString("prenom"));
                r.setEmail(rs.getString("email"));
                r.setCommentaire(rs.getString("Commentaire"));
                myList.add(r);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
        return myList;
  }
 @Override
  public void supprimer(Reclamation R ) {
        try {
            String req = "DELETE FROM Reclamation WHERE numero=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, R.getNumero());
            pst.executeUpdate();
            System.out.println("Reclamation suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 @Override
 public void modifier(Reclamation R) {
        try {
            String req = "UPDATE Reclamation SET nom=?,prenom=? WHERE numero=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(3, R.getNumero());
            pst.setString(1, R.getNom());
            pst.setString(2, R.getPrenom());
            pst.executeUpdate();
            System.out.println("Reclamation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
