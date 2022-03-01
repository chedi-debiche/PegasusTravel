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
 public class JDBCJAVAFX {

    /**
     * @param args the command line arguments
     */   
    
  
    public static void main(String[] args) {

       // Voyage v1 = new Voyage("Départ Groupe à Turquie" , "Istanbul", "Vol avec Tunisair + Hôtel 4*",1100);
        //Voyage v2 = new Voyage("Depart Groupe à France", "Paris", "Vol avec Tunisair + Hôtel 5*",1700);
        //Voyage v3 = new Voyage("Départ Groupe à Spain" , "Barcelone", "Vol avec Tunisair + Hôtel 5*",1600);
       // Voyage v4 = new Voyage("Départ Groupe à Italie" , "Rome", "Vol avec Tunisair + Hôtel 5*",1500);
       // Voyage v5 = new Voyage("Départ Groupe à Egypte" , "Cairo", "Vol avec Tunisair + Hôtel 4*",1200);
        
       Voyage v7 = new Voyage(52,"Départ Groupe à France" , "Monaco", "Vol avec Tunisair + Hôtel 5*",1900);

      //ReservationV r1 = new ReservationV(1, "3/3/2022",51);
     // ReservationV r2 = new ReservationV(2, "16/5/2022",53);
        
       ReservationV r4 = new ReservationV(25,2, "7/7/2022",51);

       ServiceVoyage sv= new ServiceVoyage();
       ServiceReservationV sr= new ServiceReservationV();

        try {
         //  sv.add(v1);      
         //  sv.add(v2);
         //  sv.add(v3);
          // sv.add(v4);
           // sv.add(v5);
            
            System.out.println();
            System.out.println(" ************* Affichage listes des voyages **************");
            List<Voyage> l = new ArrayList<Voyage>();
            l = sv.read();
            for( Voyage v : l){
                            System.out.println(v.toString());

            }
          System.out.println();
          System.out.println(" ************** Modification listes des voyages ************");
         sv.update(v7);
         
           
          System.out.println(sv.read());
          System.out.println(); 
          System.out.println(" *********** Affichage listes de voyages aprés la suppression **************");
          sv.delete(v7);
          System.out.println(sv.read()); 
 
       
    
              System.out.println();
        
       // sr.add(r1);      
       // sr.add(r2);
        
            
            System.out.println();
            System.out.println(" ************* Affichage les reservations des voyages **************");
            List<ReservationV> k = new ArrayList<ReservationV>();
            k = sr.read();
            for( ReservationV r : k){
                            System.out.println(r.toString());

            }
          System.out.println();
          System.out.println(" ****************** Modification reservations des voyages **************");
          sr.update(r4);
           
          System.out.println(sr.read());
          System.out.println(); 
          System.out.println(" *********** Affichage les reservations de voyages aprés la suppression **************");
         sr.delete(r4);
          System.out.println(sr.read()); 
 
          
          
          
        } catch (SQLException ex) {
            Logger.getLogger(JDBCJAVAFX.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
    
}
 
