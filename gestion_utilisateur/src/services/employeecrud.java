
package services;

import entities.employee;
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
public class employeecrud {
     Connection cnx2;
    public employeecrud(){
         cnx2 = MyConnexion.getInstance().getcnx();
        
    }
     public void ajouteremployee(employee e){
         
        try {
            String requetee = "INSERT INTO `employee`(`nom`, `prenom`, `email`, `poste`, `salaire`)"+ "VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requetee);
            pst.setString(1,e.getNom());
            pst.setString(2,e.getPrenom());
            pst.setString(3,e.getEmail());
            pst.setString(4,e.getPoste());
            pst.setInt(5,e.getSalaire());
            pst.executeUpdate();
            System.out.println("employee ajouter avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
         
     }
     public List<employee> afficheremp(){
         
         List<employee> myList = new ArrayList<>();
         
        try {
            String requete3 = "SELECT * FROM employee";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()){
                employee e = new employee();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setEmail(rs.getString("email"));
                e.setPoste(rs.getString("poste"));
                e.setSalaire(rs.getInt("salaire"));
                myList.add(e);
            }

        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }     return myList;
     }
     public void modifierNemployee(String nom , String nomemployeeNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from employee where nom='"+ nom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update employee set nom='"+nomemployeeNouveau+"' where nom='"+nom +"'");
                update.executeUpdate();
                System.out.println("Nom du employee modifié avec succes");
            }
            else {
                System.err.println("employee non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     public void modifierPemployee(String prenom , String prenomemployeeNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from employee where prenom='"+ prenom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update employee set prenom='"+prenomemployeeNouveau+"' where prenom='"+prenom +"'");
                update.executeUpdate();
                System.out.println("prenom du employee modifié avec succes");
            }
            else {
                System.err.println("employee non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     
     public void modifierEemployee(String email , String emailemployeeNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from employee where email='"+ email+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update employee set email='"+emailemployeeNouveau+"' where email='"+email +"'");
                update.executeUpdate();
                System.out.println("email du employee modifié avec succes");
            }
            else {
                System.err.println("employee non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
      public void modifierSemployee(int salaire , int salaireemployeeNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from employee where salaire='"+ salaire+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update employee set salaire='"+salaireemployeeNouveau+"' where salaire='"+salaire +"'");
                update.executeUpdate();
                System.out.println("salaire du employee modifié avec succes");
            }
            else {
                System.err.println("employee non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      public void modifierposteemployee(String poste , String posteemployeeNouveau){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from employee where poste='"+ poste+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst()){
                update= cnx2.prepareStatement("update employee set poste='"+posteemployeeNouveau+"' where poste='"+poste +"'");
                update.executeUpdate();
                System.out.println("poste du employee modifié avec succes");
            }
            else {
                System.err.println("employee non trouvé");
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
     
     
     
     
     
     
     
     
     
     public void supprimeremployee (String nom){

        PreparedStatement select;
        PreparedStatement update;
        ResultSet resultat;
        try
        {
            select = cnx2.prepareStatement("select * from employee where nom='"+nom+"'");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
             update = cnx2.prepareStatement("delete from employee where nom='"+nom+"'");
                update.executeUpdate();
                System.out.println("employee supprimee avec succeess");
            }
            else
                System.err.println("employee non trouvee");
        }
        catch(SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
     
    
}
