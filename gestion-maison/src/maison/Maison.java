/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maison;

import Entités.ReservationM;
import Entités.maisonH;
import java.beans.PersistenceDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceMaison;
import services.ServiceReservation;


/**
 *
 * @author JAIDI
 */
  public class Maison {


    public static void main(String[] args) {


        maisonH m1 = new maisonH(1,"dar jwed", "image","nabeul","tres belle maison",5000);
        maisonH m2 = new maisonH(2,"dar jaballah", "image","nabeul","tres belle maison",200);
        maisonH m3 = new maisonH(3,"hhhhh", "imag43","sfaaax","joliee",54545);


       
       ServiceMaison sm= new ServiceMaison();


        try {
            sm.add(m1);
            sm.add(m2);
            sm.add(m3);


            
           
            System.out.println(" ***** affichage maison************");
            List<maisonH> l = new ArrayList<maisonH>();
            l = sm.read();
            for( maisonH M : l){
                            System.out.println(M.toString());

            }

           System.out.println(" ***** modification ************");
           sm.update(m3);
           
           System.out.println(sm.read());
           
           System.out.println(" ***** supp ************");
           sm.delete(m2);
           System.out.println(sm.read());
 
        } catch (SQLException ex) {
            Logger.getLogger(Maison.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
       
     
} 


/*public class Maison {


    public static void main(String[] args) {


        ReservationM r1 = new ReservationM(1,4, 6,"sofkij");
        ReservationM r2 = new ReservationM(3,4, 6,"FFFFF");
        


       
       ServiceReservation sr= new ServiceReservation();


        try {
            sr.add(r1);
            sr.add(r2);



            
           
            System.out.println(" ***** affichage maison************");
            List<ReservationM> l = new ArrayList<ReservationM>();
            l = sr.read();
            for( ReservationM r : l){
                            System.out.println(r.toString());

            }

           System.out.println(" ***** modification ************");
           sr.update(r2);
           
           System.out.println(sr.read());
           
           System.out.println(" ***** supp ************");
           sr.delete(r2);
           System.out.println(sr.read());
 
        } catch (SQLException ex) {
            Logger.getLogger(Maison.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
       
     
}*/