/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.Voyage;
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
 * @author ASUS
 */
public class ServiceVoyage implements IService<Voyage>{
 Connection cnx ;
    public ServiceVoyage() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    
    @Override
    public void add(Voyage v) throws SQLException{
        
        Statement st = cnx.createStatement();
          String req =" insert into voyage (id, nom , destination, description, prix) values (" +v.getId()+ ", '"+v.getNom()+" ' , '"+v.getDestination() +" ' , '"+v.getDescription() + " ' , '"+v.getPrix()+ "')"; 
    st.executeUpdate(req);



    }

    @Override
    public List<Voyage> read() throws SQLException{
    List<Voyage> ls = new ArrayList<Voyage>();
    Statement st = cnx.createStatement();
    String req = "select * from voyage";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt("id");
        String nom = rs.getString(2);
        String destination = rs.getString(3);
        String description = rs.getString(4);
        int prix = rs.getInt(5);
        
        Voyage v = new Voyage(id, nom, destination, description, prix);
        ls.add(v);
    }
    
    return ls;

    }

    @Override
    public void update(Voyage v) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update voyage set destination = ? where id = ? ");
        pt.setString(1, "Monaco");
        pt.setInt(2, v.getId());
        pt.executeUpdate(); 


    }

   @Override
    public void delete(Voyage v) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from voyage where id = ?");
        pt.setInt(1, v.getId());
        pt.executeUpdate();    } 
    
}
