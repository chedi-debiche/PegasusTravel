
package tests;

import entities.Client;
import entities.admin;
import entities.employee;
import services.admincrud;
import services.clientcrud;
import services.employeecrud;
import utiles.MyConnexion;

/**
 *
 * @author Zoghlami
 */
public class MainClass {
    public static void main(String[] args) {
    //MyConnexion mc = new MyConnexion();
    clientcrud ccd = new clientcrud();
    admincrud acd = new admincrud();
    employeecrud ecd = new employeecrud();
    employee e = new employee("raze", "hatake", "raze@brazil", "Boomer", 2000);
    //ecd.ajouteremployee(e);
    //admin a = new admin("jack", "sparrow", "good@job", 500);
    //acd.ajouteradmin(a);
//Client C = new Client("jack", "smith", "smith@gmailcom");
//ccd.ajouterclient2(C);
   // System.out.println(ccd.afficherClient());
        //System.out.println(acd.afficheradmin());
        //System.out.println(ecd.afficheremp());
        //ecd.modifierNemployee("yuri", "takachi");
        //ecd.ajouteremployee(e);
        ecd.modifierposteemployee("Boomer", "Booomer");
       //ccd.modifierNClient("jack", "oreki");
       //ccd.supprimerClient("oreki");
    }
    
}
