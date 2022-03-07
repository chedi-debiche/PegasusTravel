/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entités.ReponseReclamation;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author 21695
 */
public interface ReponseInterface {
    public ObservableList <ReponseReclamation> afficherReponse();
     public void supprimer(ReponseReclamation R) ;
      public void modifier(ReponseReclamation R);
}
