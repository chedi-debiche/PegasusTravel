/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Reclamation;
import services.ReclamationCRUD;
import utils.MyConnection;

/**
 *
 * @author 21695
 */
public class MainClass  {
 
public static void main(String[] args)  {
   // MyConnection mc = new MyConnection();
   ReclamationCRUD rcd = new ReclamationCRUD ();
//   rcd.AjoutReclamation();
Reclamation R2= new Reclamation("khitem","mathlouthi","khite.mathlouthi@esprit.tn","ajoute reclamation");
rcd.AjoutReclamation2(R2);
System.out.println(rcd.afficherReclamation());
rcd.AjoutReclamation2(R2);
rcd.modifier(R2);
rcd.supprimer(R2);

}       
}
