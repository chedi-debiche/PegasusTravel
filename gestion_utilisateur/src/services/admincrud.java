
package services;


import entities.admin;
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
public class admincrud {
    Connection cnx2;
    
    public admincrud(){
         cnx2 = MyConnexion.getInstance().getcnx();
        
    }
    
     public void ajouteradmin(admin a){
         
        try {
            String requetea = "INSERT INTO  admin (nom,prenom,email,salaire)"
+ "VALUES(?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requetea);
            pst.setString(1,a.getNom());
            pst.setString(2,a.getPrenom());
            pst.setString(3,a.getEmail());
            pst.setInt(4,a.getSalaire());
            pst.executeUpdate();
            System.out.println("Admin ajouter avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
         
     }
     public List<admin> afficheradmin(){
         
         List<admin> myList = new ArrayList<>();
         
        try {
            String requete3 = "SELECT * FROM admin";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()){
                admin a = new admin();
                a.setId(rs.getInt(1));
                a.setNom(rs.getString("nom"));
                a.setPrenom(rs.getString("prenom"));
                a.setEmail(rs.getString("email"));
                a.setSalaire(rs.getInt("salaire"));
                myList.add(a);
                
            }

        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }     return myList;
     }
     
     public void modifierNadmin(String nom , String nomadminNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from admin where nom='"+ nom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update admin set nom='"+nomadminNouveau+"' where nom='"+nom +"'");
                update.executeUpdate();
                System.out.println("Nom du admin modifié avec succes");
            }
            else {
                System.err.println("admin non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     public void modifierPadmin(String prenom , String prenomadminNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from admin where prenom='"+ prenom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update admin set prenom='"+prenomadminNouveau+"' where prenom='"+prenom +"'");
                update.executeUpdate();
                System.out.println("prenom du admin modifié avec succes");
            }
            else {
                System.err.println("admin non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     
     public void modifierEadmin(String email , String emailadminNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from admin where email='"+ email+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update admin set email='"+emailadminNouveau+"' where email='"+email +"'");
                update.executeUpdate();
                System.out.println("email du admin modifié avec succes");
            }
            else {
                System.err.println("admin non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
      public void modifierSadmin(int salaire , int salaireadminNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from admin where salaire='"+ salaire+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update admin set salaire='"+salaireadminNouveau+"' where salaire='"+salaire +"'");
                update.executeUpdate();
                System.out.println("salaire du admin modifié avec succes");
            }
            else {
                System.err.println("admin non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     
     
     
     
     
     
     
     
     public void supprimeradmin (String nom){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from admin where nom='"+nom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
             update = cnx2.prepareStatement("delete from admin where nom='"+nom+"'");
                update.executeUpdate();
                System.out.println("admin supprimee avec succeess");
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
