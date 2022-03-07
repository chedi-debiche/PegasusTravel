/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.Evenement;
import java.sql.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author rahma
 */
public interface EvenementInterface {


    public void AjouterEvenement(Evenement E);

    public  ObservableList<Evenement> AfficherEvenement();

    public void supprimer(Evenement E);
//    public boolean modifier(Evenement E);
     public void modifier(Evenement E );
    // public boolean AcceptDate (Evenement E );
}
