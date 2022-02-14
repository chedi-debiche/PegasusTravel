/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Sponsor;
import java.util.List;

/**
 *
 * @author rahma
 */
public interface SponsorInterface {
    
    public void AjouterSponsor() ;
    
    public void AjouterSponsor2(Sponsor S) ;
    
    public List<Sponsor> AfficherSponsor();
    
    public void supprimerSponsor(Sponsor S);
    
    public void modifierSponsor(Sponsor  S);
}
