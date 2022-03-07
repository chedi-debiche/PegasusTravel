/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
 * @author Fayechi
 */
public class ServiceReservation implements IService<ReservationM>{
 Connection cnx ;
    public ServiceReservation() {
         cnx = Database.getInstance().getConn();
        
    }






    public void ajouter(ReservationM m) {
        try {
            String req = "INSERT INTO `ReservationM` (`nb_chambre`, `nb_personne`,`date`,`id_maison` ) VALUES ( ? , ? ,str_to_date(?,'%d/%m/%y'), ?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, m.getNb_chambre());
            ps.setInt(2, m.getNb_personne());
            ps.setString(3, m.getDate());
            ps.setInt(4, m.getId_maison());

               
               
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

  

    @Override
    public List<ReservationM> read() {
        List<ReservationM> list = new ArrayList<>();
        try {
            String req = "Select * from ReservationM";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ReservationM r = new ReservationM(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean modifier(ReservationM r) {
        try {
            String req = "UPDATE  `ReservationM` SET nb_chambre= ? , nb_personne= ? , date =str_to_date(?,'%d/%m/%y'), id_maison = ? WHERE id_res= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getNb_chambre());
            ps.setInt(2, r.getNb_personne());
            ps.setString(3, r.getDate());
            ps.setInt(4, r.getId_maison());

             ps.setInt(5, r.getId_res());
               
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    
                    

        }
        return true ; 
    }
    

    @Override
    public boolean supprimer(int id ) {
        
        
        
            try {
            String req = "DELETE FROM ReservationM  WHERE id_res= ?" ;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,id);
          

               
               
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    
        }
        return true ; 
        
    }

}
