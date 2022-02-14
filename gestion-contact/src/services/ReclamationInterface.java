/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import java.util.List;

/**
 *
 * @author 21695
 */
public interface ReclamationInterface {
    public void AjoutReclamation();
      public void AjoutReclamation2(Reclamation R);
       public List <Reclamation> afficherReclamation();
       public void supprimer(Reclamation R );
        public void modifier(Reclamation R);
}
