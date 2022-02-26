/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class MaisonItemController implements Initializable {

    @FXML
    private Label labelNomMaiosn;
    @FXML
    private Label labelLocalisationM;
    @FXML
    private Label labelDescriptionM;
    @FXML
    private Label labelPrixM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

     private maisonH maison;
  
    
    public void setMaison(maisonH m){
  this.maison = m;      
        
        
    }
    
   
    public void setData(maisonH m){
      
       labelNomMaiosn.setText(m.getNom());
       labelLocalisationM.setText(m.getLocalisation());
       labelDescriptionM.setText(m.getDescription());
       labelPrixM.setText(m.getPrix()+" DT");
       

      
     // prodImage.setImage(new Image(getClass().getResourceAsStream(p.getImage_p())));
         
        
        
        
    }
    
    
}