/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Evenement;
import entities.Sponsor;
import services.EvenementCRUD;
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
        ecrud.AjouterEvenement();
        Evenement E2 = new Evenement("valentine","14/02/2022");
        ecrud.AjouterEvenement2(E2);
        System.out.println(ecrud.AfficherEvenement());
        SponsorCRUD scrud = new SponsorCRUD();
        scrud.AjouterSponsor();
        Sponsor s1 = new Sponsor("khitem","mathlouthi","hihihi");
         scrud.AjouterSponsor2(s1);
         System.out.println(scrud.AfficherSponsor());
    }

}
