/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.edu.esprit.test;

import tn.edu.esprit.models.ReservationM;
import tn.edu.esprit.models.maisonH;

import tn.edu.esprit.services.ServiceReservation;
import tn.edu.esprit.services.ServiceMaison;


import tn.edu.esprit.utils.DataSource;




/**
 *
 * @author 
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceMaison sm  = new ServiceMaison();
        ServiceReservation sr = new ServiceReservation(); 

                      // System.out.println(" ***** TABLE  maison d'hote  ************");
    
     System.out.println(" ***** Ajouter maison ************");
     maisonH m = new maisonH("dar khle3a", "image.jpeg", "nabeul", "une tres belle maison ", 450 );
     sm.ajouter(m); 
 
  

     
          //System.out.println(" ***** modifier maison ************");

    //  maisonH m = new maisonH(10 ,"miboun", "ertg", "ghh", "iguyjyyj", 55 );
    //  sm.modifier(m); 
       

    //  sm.supprimer(10); 
                


               
               
               
               
               
               
               
       
                  // System.out.println(" ***** TABLE reservation maison d'hote  ************");
         //  System.out.println(" ***** Ajouter reservation ************");        
        
              ReservationM r= new ReservationM(4,5,"17/12/22",23);
              sr.ajouter(r);

              
             // ReservationM r= new ReservationM(2,4,5,"17/12/66",2);
             // sr.modifier(r);    
             //sr.supprimer(2);            


    
                 
                 
        System.out.println(sm.getAll());
        
        
       
        
        
    }
    
}
