/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.javafx;

import Entités.Voyage;
import Entités.ReservationV;
import java.beans.PersistenceDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceVoyage;
import services.ServiceReservationV;

/**
 *
 * @author ASUS
 */
/* public class JDBCJAVAFX {

    /**
     * @param args the command line arguments
     */   
    
  
   /* public static void main(String[] args) {

        Voyage v1 = new Voyage(10, "Départ Groupe à Turquie" , "Istanbul", "Vol avec Tunisair + Hôtel 4*",1100);
        Voyage v2 = new Voyage(20, "Depart Groupe à France", "Paris", "Vol avec Tunisair + Hôtel 5*",1700);
        Voyage v3 = new Voyage(30, "Départ Groupe à Spain" , "Barcelone", "Vol avec Tunisair + Hôtel 5*",1600);
        Voyage v4 = new Voyage(40, "Départ Groupe à Italie" , "Rome", "Vol avec Tunisair + Hôtel 5*",1500);
        Voyage v5 = new Voyage(50, "Départ Groupe à Egypte" , "Cairo", "Vol avec Tunisair + Hôtel 4*",1200);


       ServiceVoyage sp= new ServiceVoyage();

        try {
            sp.add(v1);      
            sp.add(v2);
            sp.add(v3);
            sp.add(v4);
            sp.add(v5);
            
            System.out.println();
            System.out.println(" ************* Affichage listes des voyages **************");
            List<Voyage> l = new ArrayList<Voyage>();
            l = sp.read();
            for( Voyage v : l){
                            System.out.println(v.toString());

            }
          System.out.println();
          System.out.println(" ************** Modification listes des voyages ************");
          sp.update(v2);
           
          System.out.println(sp.read());
          System.out.println(); 
          System.out.println(" *********** Affichage listes de voyages aprés la suppression **************");
          sp.delete(v4);
          System.out.println(sp.read()); 
 
        } catch (SQLException ex) {
            Logger.getLogger(JDBCJAVAFX.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
    
}
*/






public class JDBCJAVAFX {

    /**
     * @param args the command line arguments
     */   
 
    public static void main(String[] args) {

        ReservationV r1 = new ReservationV(1, 5 , "3/3/2022");
        ReservationV r2 = new ReservationV(2, 4, "16/5/2022");
    
       ServiceReservationV sp= new ServiceReservationV();

        try {
            sp.add(r1);      
            sp.add(r2);
        
            
            System.out.println();
            System.out.println(" ************* Affichage les reservations des voyages **************");
            List<ReservationV> l = new ArrayList<ReservationV>();
            l = sp.read();
            for( ReservationV r : l){
                            System.out.println(r.toString());

            }
          System.out.println();
          System.out.println(" ****************** Modification reservations des voyages **************");
          sp.update(r2);
           
          System.out.println(sp.read());
          System.out.println(); 
          System.out.println(" *********** Affichage les reservations de voyages aprés la suppression **************");
          sp.delete(r1);
          System.out.println(sp.read()); 
 
        } catch (SQLException ex) {
            Logger.getLogger(JDBCJAVAFX.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
    
}