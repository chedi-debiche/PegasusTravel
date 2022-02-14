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
          String req =" insert into reservationv (idr, nb_personnes , date) values (" +r.getIdr()+ ", '"+r.getNb_personnes()+" ' , '"+r.getDate()+ "')"; 
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

        
        ReservationV r = new ReservationV(idr, nb_personnes, date);
        ls.add(r);
    }
    
    return ls;

    }

   @Override
    public void update(ReservationV r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update reservationv set date = ? where idr = ? ");
        pt.setString(1, "20/5/2022");
        pt.setInt(2, r.getIdr());
        pt.executeUpdate(); 


    }

  @Override
    public void delete(ReservationV r) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from reservationv where idr = ?");
        pt.setInt(1, r.getIdr());
        pt.executeUpdate();    } 
    
}
