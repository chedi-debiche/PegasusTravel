/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import java.util.List;

/**
 *
 * @author rahma
 */
public interface EvenementInterface {

    public void AjouterEvenement();

    public void AjouterEvenement2(Evenement E);

    public List<Evenement> AfficherEvenement();

    public void supprimer(Evenement E);
    public void modifier(Evenement  E);
}
