/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.maisonH;
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
 * @author chedi
 */
public class ServiceMaison implements IService<maisonH>{
 Connection cnx ;
    public ServiceMaison() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    
 @Override
     public void add(maisonH M) throws SQLException{
        
        Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into maisonH (id, nom , image, localisation , description ,prix) values (" +M.getId()+ ",'"+M.getNom()+" ' ,'"+M.getImage()+" ' , '"+M.getLocalisation() +"' , '"+M.getDescription() +"','"+M.getPrix() +"')"; 
    st.executeUpdate(req);



    }

    @Override
    public List<maisonH> read() throws SQLException{
    List<maisonH> ls = new ArrayList<maisonH>();
    Statement st = cnx.createStatement();
    String req = "select * from maisonH";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt("id");
        String nom = rs.getString(2);
        String image = rs.getString(3);
        String localisation = rs.getString(4);
        String description = rs.getString(5);
        int prix = rs.getInt(6);

        maisonH M = new maisonH(id,nom, image, localisation, description , prix);
        ls.add(M);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return ls;

    }

   @Override
    public void update(maisonH M) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update maisonH set nom = ? where id = ? ");
        pt.setString(1, "maisooooon");
        pt.setInt(2, M.getId());
        pt.executeUpdate(); 


    }

    @Override
    public void delete(maisonH M) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from maisonH where id = ?");
        pt.setInt(1, M.getId());
        pt.executeUpdate();    }

    
    
    
    
    
    
    
   
 
    
}
