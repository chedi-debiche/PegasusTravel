/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entités.Publication;
import java.sql.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author 21695
 */
public interface PublicationInterface {
    public void AjoutPub(Publication F);
    public ObservableList <Publication> afficherPub();
    public void supprimer(Publication P);
    public void modifier(Publication p);
}
