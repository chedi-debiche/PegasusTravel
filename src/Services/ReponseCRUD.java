/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.Reclamation;
import Entités.ReponseReclamation;
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
 * @author 21695
 */
public class ReponseCRUD implements ReponseInterface {
    Connection cnx2;
    public ReponseCRUD() {
        cnx2= MyConnection.getInstance().getCnx();
    }

    @Override
    public ObservableList<ReponseReclamation> afficherReponse() {
      
        ObservableList<ReponseReclamation>  myList =FXCollections.observableArrayList();
      try {
            
            String requete3="SELECT * FROM  ReponseReclamation ";
            Statement st =cnx2.createStatement();
            ResultSet rs =st.executeQuery(requete3);
            while(rs.next()){
                ReponseReclamation r =new ReponseReclamation();
                r.setIdRep(rs.getInt("IdRep"));
                r.setNumero(rs.getInt("numero"));
                r.setReponse(rs.getString("Reponse"));
                
                myList.add(r);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
          ex.printStackTrace();
        }
        return myList;
  }
   

    public void AjoutReponse2(ReponseReclamation R){
        try {
            String requete2 = "INSERT INTO ReponseReclamation (numero,Reponse) VALUES(?,?)";
           
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            
            
            pst.setInt(1, R.getNumero());
            pst.setString(2,R.getReponse());
            pst.executeUpdate();
            System.out.println("votre ReponseReclamation est ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
          
          } 
    @Override
    public void supprimer(ReponseReclamation R) {
        
                    try {
            String requete3 = "DELETE FROM ReponseReclamation where IdRep=? ";
            PreparedStatement pst = cnx2.prepareStatement(requete3);
            pst.setInt(1,R.getIdRep());
            int ok = pst.executeUpdate();

            if (ok == -1) {
                System.out.println("suppretion ReponseReclamation failed");
            } else {
                System.out.println("suppretion ReponseReclamation succes ! ");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 

    }
   @Override
    public void modifier(ReponseReclamation R) {
        try {
            String requete4 = "update ReponseReclamation set Reponse=? where IdRep=? ";


            PreparedStatement pst = cnx2.prepareStatement(requete4);
            
            pst.setString(1, R.getReponse());
            pst.setInt(2,R.getIdRep());

            int ok = pst.executeUpdate();

            if (ok == -1) {
                System.out.println("Insertion Reponse failed");
            } else {
                System.out.println("Insertion Reponse succes ! ");
            }
            System.out.println("ReponseReclamation modifiée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }

     public List<Reclamation> rechercheReclamationRep(int IdRep) {
        List<Reclamation> listReclamation = new ArrayList<>();
        try {
            String query = "SELECT * FROM ReponseReclamation where IdRep=" + IdRep;
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ReponseReclamation R = new ReponseReclamation();
                R.setIdRep(rs.getInt("IdRep"));
                R.setNumero(rs.getInt("numero"));
                R.setReponse(rs.getString("Reponse"));
                
                listReclamation.add(R);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listReclamation;
    }

   
    }
   
