/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.ReservationV;
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
public class ServiceReservationV implements IService<ReservationV>{
 Connection cnx ;
    public ServiceReservationV() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    
    @Override
    public void add(ReservationV r) throws SQLException{
        
        Statement st = cnx.createStatement();
          String req =" insert into reservationv (idr, nb_personnes , date,id) values (" +r.getIdr()+ ", '"+r.getNb_personnes()+" ' , '"+r.getDate()+" ' , '"+r.getId()+ "')"; 
    st.executeUpdate(req);



    }

    @Override
    public List<ReservationV> read() throws SQLException{
    List<ReservationV> ls = new ArrayList<ReservationV>();
    Statement st = cnx.createStatement();
    String req = "select * from reservationv";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idr = rs.getInt("idr");
        int nb_personnes = rs.getInt(2);
        String date = rs.getString(3);
        int id = rs.getInt(4);

        
        ReservationV r = new ReservationV(idr, nb_personnes, date,id);
        ls.add(r);
    }
    
    return ls;

    }

 /* @Override
    public void update(ReservationV r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update reservationv set date = ? where id = ? ");
        pt.setString(1, "20/5/2022");
        pt.setInt(2, r.getId());
        pt.executeUpdate(); 


    }*/
       @Override
    public void update(ReservationV r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update reservationv set nb_personnes = ? , date = ? where idr = ? ");
        
        pt.setInt(1, r.getNb_personnes());
        pt.setString(2, r.getDate());
        pt.setInt(3, r.getIdr());
        pt.executeUpdate(); 


    }


  @Override
    public void delete(ReservationV r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from reservationv where idr = ?");
        pt.setInt(1, r.getIdr());
        pt.executeUpdate();    } 
    
     /*  @Override
    public void delete(ReservationV r) {
        try {
            String req = "DELETE FROM voyage where id =" + r.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            //System.out.println("Evenement supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}
