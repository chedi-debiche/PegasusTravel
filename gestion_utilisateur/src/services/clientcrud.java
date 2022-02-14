
package services;

import entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utiles.MyConnexion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Zoghlami
 */
public class clientcrud {
    
    Connection cnx2;
    
    public clientcrud(){
        cnx2 = MyConnexion.getInstance().getcnx();
        
    }
    /*public void ajouterclient(){
        try {
            String requete = "INSERT INTO `client`(`nom`,`prenom`,`email`)"
                    + "VALUES ('iheb','zoghlami','blabla@gmail.com') ";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Client ajoutée avec succés");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                
    }*/
    
     public void ajouterclient2(Client C){
         
        try {
            String requete2 = "INSERT INTO  client (nom,prenom,email)"
+ "VALUES(?,?,?)";
            
            PreparedStatement pst = cnx2.prepareStatement(requete2);
           pst.setString(1,C.getNom());
           pst.setString(2,C.getPrenom());
           pst.setString(3,C.getEmail());
            pst.executeUpdate();
            System.out.println("Client ajoutée avec succés");
            
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
           ex. printStackTrace();
        }
        
    }
     
     public List<Client> afficherClient(){
         
         List<Client> myList = new ArrayList<>();
         
        try {
            String requete3 = "SELECT * FROM client";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()){
                Client c = new Client();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setEmail(rs.getString("email"));
                myList.add(c);
            }

        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }     return myList;
     }
     
     public void modifierNClient(String nom , String nomclientNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from client where nom='"+ nom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update client set nom='"+nomclientNouveau+"' where nom='"+nom +"'");
                update.executeUpdate();
                System.out.println("Nom du client modifié avec succes");
            }
            else {
                System.err.println("client non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     public void modifierPClient(String prenom , String prenomclientNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from client where prenom='"+ prenom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update client set prenom='"+prenomclientNouveau+"' where prenom='"+prenom +"'");
                update.executeUpdate();
                System.out.println("prenom du client modifié avec succes");
            }
            else {
                System.err.println("client non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     
     public void modifierEClient(String email , String emailclientNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from client where email='"+ email+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update client set email='"+emailclientNouveau+"' where email='"+email +"'");
                update.executeUpdate();
                System.out.println("email du client modifié avec succes");
            }
            else {
                System.err.println("client non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     
     
     
     
     
     
     
     
     public void supprimerClient (String nom){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from client where nom='"+nom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
             update = cnx2.prepareStatement("delete from client where nom='"+nom+"'");
                update.executeUpdate();
                System.out.println("client supprimee avec succeess");
            }
            else
                System.err.println("admin non trouvee");
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
     
     
    
    
}
