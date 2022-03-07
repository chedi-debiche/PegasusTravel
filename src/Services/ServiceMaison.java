/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import gui.maisonH;
//import Entités.maisonH;
import Intservice.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Database;




/**
 *
 * @author CC
 */

 public class ServiceMaison implements IService<maisonH>{
 Connection cnx ;
    public ServiceMaison() {
         cnx = Database.getInstance().getConn();
        
    }
    
    
    
    

   
@Override
    public void ajouter(maisonH m) {
        try {
            String req = "INSERT INTO `maisonH` (`nom`, `image`,`localisation`,`description`,`prix`) VALUES (?, ? , ? , ? , ?  )";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getLocalisation());
            ps.setString(3, m.getDescription());
            ps.setFloat(4, m.getPrix());
            ps.setString(5, m.getImage_maison());



               
               
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

 
/*    @Override
    public List<maisonH> getAll() {
        List<maisonH> list = new ArrayList<>();
        try {
            String req = "Select * from maisonH";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                maisonH m = new maisonH(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6));
                list.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }*/
    
@Override
    public List<maisonH> read() throws SQLException{
    List<maisonH> ls = new ArrayList<maisonH>();
    Statement st = cnx.createStatement();
    String req = "select * from maisonH";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id_maison = rs.getInt("id_maison");
        String nom = rs.getString("nom");
        String localisation = rs.getString("localisation");
        String description = rs.getString("description");
        Float prix = rs.getFloat("prix");
        String image_maison = rs.getString("image_maison");
        
        maisonH m = new maisonH(id_maison, nom, localisation, description, prix,image_maison);
        ls.add(m);
    }
    
    return ls;

    }
    
  /*  @Override
    public List<maisonH> getMaisonhote() throws SQLException {
        
        Statement stm = cnx.createStatement();
        String query = "select * from `maisonH`";
        ResultSet rst = stm.executeQuery(query);
        List<maisonH> maisonHote = new ArrayList<>();
        while (rst.next()) {
            maisonH m2 = new maisonH();
            m2.setId_maison(rst.getInt("id_maison"));
            m2.setNom(rst.getString("nom"));
            m2.setLocalisation(rst.getString("localisation"));
            m2.setDescription(rst.getString("description"));
            m2.setPrix(rst.getFloat("prix"));
            m2.setImage_maison(rst.getString("image_maison"));
           
            maisonHote.add(m2);
            
        }
     return maisonHote;
     
    }*/

    @Override
    public boolean modifier(maisonH m) {
        try {
            String req = "UPDATE  `maisonH` SET nom= ? ,image= ? ,localisation= ? ,description= ? ,prix=?  WHERE id_maison= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getImage_maison());
            ps.setString(3, m.getLocalisation());
            ps.setString(4, m.getDescription());
            ps.setFloat(5,  m.getPrix());
            
             ps.setInt(6, m.getId_maison());

               
               
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    
            
                    

        }
        return true ; 
    }
    

    @Override
    public boolean supprimer(int id ) {
        
        
        
            try {
            String req = "DELETE FROM maisonH  WHERE id_maison= ?" ;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,id);
          

               
               
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    
        }
        return true ; 
        
    }

}


 //str_to_date(?,'%d/%m/%y')