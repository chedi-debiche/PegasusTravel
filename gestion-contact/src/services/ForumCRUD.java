/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Forum;
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
 * @author 21695
 */
public class ForumCRUD implements ForumInterface  {
    Connection cnx2;

    public ForumCRUD() {
        cnx2= MyConnection.getInstance().getCnx();
    }
    
    /**
     *
     */
    @Override
    public void AjoutForum(){
      try {
          String requete = "INSERT INTO forum(commentaire,titre)  VALUES('','')";
          Statement st = cnx2.createStatement();
          st.executeUpdate(requete);
          System.out.println("Forum ajoutee avec succes");
      } catch (SQLException ex) {
      System.err.println(ex.getMessage());
      }
  }

    /**
     *
     * @param F
     */
    @Override
    public void AjoutForum2(Forum F){
        try {
            String requete2 = "INSERT INTO forum(commentaire,titre) VALUES(?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setString(1, F.getCommentaire());
            pst.setString(2, F.getTitre());
            
            pst.executeUpdate();
            System.out.println("votre Forum est ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
          }  
    @Override
  public List <Forum> afficherReclamation(){
        List<Forum>  myList =new ArrayList<>();
      try {
            
            String requete3="SELECT *FROM  Reclamation  ";
            Statement st =cnx2.createStatement();
            ResultSet rs =st.executeQuery(requete3);
            while(rs.next()){
                Forum F =new Forum();
                F.setCommentaire(rs.getString("Commentaire"));
                F.setTitre("titre");
                myList.add(F);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
        return myList;
  }
    @Override
   public void supprimer(Forum f  ) {
        try {
            String req = "DELETE FROM forum WHERE commentaire=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setString(1, f.getCommentaire());
            pst.executeUpdate();
            System.out.println("forum suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
   public void modifier(Forum f) {
        try {
            String req = "DELETE FROM forum WHERE commentaire=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            
            pst.setString(1,f.getCommentaire());
            
            pst.executeUpdate();
            System.out.println("Forum modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
