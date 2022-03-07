/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import Entités.Publication;
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
 * @author 21695
 */
public class PublicationCRUD implements PublicationInterface{
Connection cnx3;
public PublicationCRUD(){
     cnx3= MyConnection.getInstance().getCnx();
}
    @Override
    public void AjoutPub(Publication F) {
      try {
            String requete2 = "INSERT INTO Publication(datePub,path,description) VALUES (?,?,?)";
            PreparedStatement pst = cnx3.prepareStatement(requete2);
            pst.setDate(1, F.getDatePub());
            pst.setString(2, F.getPath());
            pst.setString(3, F.getDescription());
           
            pst.executeUpdate();
            System.out.println("la réservation est ajoutée !");
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
//datePub,path,description,idReact
    @Override
    public ObservableList<Publication> afficherPub() {
           ObservableList<Publication> myList = FXCollections.observableArrayList();
      try {
            
            String requete3="SELECT *FROM  Publication  ";
            Statement st =cnx3.createStatement();
            ResultSet rs =st.executeQuery(requete3);
            while(rs.next()){
                Publication p =new Publication();
                p.setIdPub(rs.getInt("idPub"));
             
                p.setDatePub(rs.getDate("datePub"));
                p.setPath(rs.getString("Path"));
                p.setDescription(rs.getString("description"));
                
                myList.add(p);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
        return  myList;
    }

    @Override
    public void supprimer(Publication P) {
       try {
            String req = "DELETE FROM Publication WHERE datePub=?";
            PreparedStatement pst = cnx3.prepareStatement(req);
            pst.setDate(1, P.getDatePub());
            pst.executeUpdate();
            System.out.println("Publication suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publication p) {
        try {
            String req = "UPDATE Publication SET description=?,datePub =? WHERE idPub=?";
            PreparedStatement pst = cnx3.prepareStatement(req);
            
            pst.setString(1, p.getDescription());
            pst.setDate(2, p.getDatePub());
            pst.setInt(3,p.getIdPub());
            
           
            pst.executeUpdate();
            System.out.println("Publication modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public ObservableList<Publication>  recherchePublication(int idPub) {
        ObservableList<Publication> myList = FXCollections.observableArrayList();
         try {
            String query = "SELECT * FROM Publication where idPub="+idPub;
            Statement st = cnx3.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Publication R = new Publication();
                R.setIdPub(rs.getInt("idPub"));
                R.setDatePub(rs.getDate("datePub"));
                R.setPath(rs.getString("path"));
                R.setDescription(rs.getString("description"));
                
                myList.add(R);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return myList;
    }
     public ObservableList<Publication> rechercheParDescp(String test) {
       // Reclamation p = new Reclamation();
         
        ObservableList<Publication> List = FXCollections.observableArrayList();
        try {
            String requete3 = "SELECT * FROM Publication WHERE description=? ";
            PreparedStatement pst = cnx3.prepareStatement(requete3);
            pst.setString(1, test);
            ResultSet rs = pst.executeQuery();
             Publication R = new Publication();
            rs.first();
            R.setIdPub(rs.getInt("idPub"));
                R.setDatePub(rs.getDate("datePub"));
                R.setPath(rs.getString("path"));
                R.setDescription(rs.getString("description"));
             List.add(R);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return List;
    }
    }
    

