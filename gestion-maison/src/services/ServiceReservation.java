/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.ReservationM;
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
public class ServiceReservation implements IService<ReservationM>{
 Connection cnx ;
    public ServiceReservation() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    
 @Override
     public void add(ReservationM r) throws SQLException{
        
        Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into ReservationM (id_res, nb_chambre , nb_personne, date) values (" +r.getId_res()+ ",'"+r.getNb_chambre()+" ' ,'"+r.getNb_personne()+" ' , '"+r.getDate() +"' )"; 
    st.executeUpdate(req);



    }

    @Override
    public List<ReservationM> read() throws SQLException{
    List<ReservationM> ls = new ArrayList<ReservationM>();
    Statement st = cnx.createStatement();
    String req = "select * from ReservationM";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id_res = rs.getInt("id_res");
        int nb_chambre = rs.getInt(2);
        int nb_personne = rs.getInt(3);
        String date = rs.getString(4);

        ReservationM r = new ReservationM(id_res, nb_chambre, nb_personne, date);
        ls.add(r);

    }
    
    return ls;

    }

   @Override
    public void update(ReservationM r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update ReservationM set nb_personne = ? where id_res = ? ");
        pt.setInt(1, 69);
        pt.setInt(2, r.getId_res());
        pt.executeUpdate(); 


    }

    @Override
    public void delete(ReservationM r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from ReservationM where id_res = ?");
        pt.setInt(1, r.getId_res());
        pt.executeUpdate();    }

    
    
    
    
    
    
    
   
 
    
}
