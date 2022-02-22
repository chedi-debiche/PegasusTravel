/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.models.maisonH;
import tn.edu.esprit.utils.DataSource;



/**
 *
 * @author Fayechi
 */
public class ServiceMaison implements IService<maisonH> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
   

    public void ajouter(maisonH m) {
        try {
            String req = "INSERT INTO `maisonH` (`nom`, `image`,`localisation`,`description`,`prix`) VALUES (?, ? , ? , ? , ?  )";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getImage());
            ps.setString(3, m.getLocalisation());
            ps.setString(4, m.getDescription());
            ps.setFloat(5, m.getPrix());


               
               
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public maisonH getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<maisonH> getAll() {
        List<maisonH> list = new ArrayList<>();
        try {
            String req = "Select * from maisonH";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                maisonH m = new maisonH(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6) );
                list.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean modifier(maisonH m) {
        try {
            String req = "UPDATE  `maisonH` SET nom= ? ,image= ? ,localisation= ? ,description= ? ,prix=?  WHERE id_maison= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getImage());
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