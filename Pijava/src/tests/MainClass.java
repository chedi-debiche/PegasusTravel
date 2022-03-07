/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Evenement;
import entities.ReservationEvenement;
import entities.Sponsor;
import entities.Reservation;
import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;
import services.EvenementCRUD;
import services.ReservationEvenementCRUD;
import services.SponsorCRUD;
import utils.MyConnection;

/**
 *
 * @author rahma
 */
public class MainClass {

    public static void main(String[] args) {
        MyConnection mc2 = MyConnection.getInstance();
           EvenementCRUD ecrud = new EvenementCRUD();
//        Date d1 = new Date(2000,05,13);
    Evenement E1 = new Evenement("mbereh", (float)15.4 ,new Date(1995, 05, 20));
    Evenement E3 = new Evenement (1,"lyoum",(float)123.7,new Date(2000, 05, 05));
    Evenement E5 = new Evenement (5,"jjijijijs",(float)123.7,new Date(2000, 05, 05));
   
       // System.out.println(ecrud.triParDate());
//        Date d2 = new Date(2000,01,01);
      //  Evenement E2 = new Evenement("birthday ", new Date(1999, 05, 05));
     // System.out.println(ecrud.rechercheEvenement("lyoum"));  
   // ecrud.supprimer(E3);
      //ecrud.AjouterEvenement(E3);
     // ecrud.modifier(E5);
     //  System.out.println(ecrud.AfficherEvenement());
       SponsorCRUD scrud = new SponsorCRUD();
        Sponsor s1 = new Sponsor("tiss", "rahma", "1000","string0");
        Sponsor s2 = new Sponsor("mathlouthi", "khitem", "1000","string1");
        Sponsor s3 = new Sponsor("farhat", "acil", "1000","string2");
        Sponsor s4 = new Sponsor("hedfi", "nourchen", "1000","string3");
        Sponsor s5 = new Sponsor("yoyoyo", "yiyiyiyi", "1000","kakaka");
        
       
      //scrud.AjouterSponsor(s4);
//        scrud.AjouterSponsor(s2);
       //scrud.supprimerSponsor(s1);
       //Sponsor s5 = new Sponsor(1,"amorri", "nour", "1000","string3");
     // scrud.modifierSponsor(s5);
    //  System.out.println(scrud.rechercheSponsor("vasco"));
//           Sponsored espon1 = new Sponsored();
////        //System.out.println(espon1.AfficherSponsored());

 //ecrud.AjouterEvenement(E5);
//     ReservationEvenement re = new ReservationEvenement("nyahahah" ,new Date(2022,02,22), (float) 12.0,1);
  ReservationEvenementCRUD recrud = new ReservationEvenementCRUD ();
    ReservationEvenement re4 = new ReservationEvenement("cat" ,new Date(2022,02,22),2);
   // recrud.AjouterRE(re4);
     //System.out.println(recrud.AfficherRE());
      //recrud.supprimer(re);
      ReservationEvenement r1 = new ReservationEvenement(1,"yoyoyoy" ,new Date(2022,02,22), (float) 120.0);
     //recrud.modifierRE(r1);
 //   System.out.println(recrud.rechercheReservationEvenement("khiten"));
  //  Sponsor s6 = new Sponsor (5,"mimi","mylove","myworld","string5");
//   scrud.modifierSponsor(s6);
//System.out.println(scrud.rechercheSponsor("mimi"));

      //  System.out.println( java.sql.Date.valueOf(java.time.LocalDate.now()));
    }

}
