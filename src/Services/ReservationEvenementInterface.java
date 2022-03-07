/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.ReservationEvenement;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author rahma
 */
public interface ReservationEvenementInterface {
     public void AjouterRE (ReservationEvenement RE);
     public List<ReservationEvenement> AfficherRE();
      public void supprimer(ReservationEvenement E);
    //    public void modifierRE(ReservationEvenement RE);
      
}
