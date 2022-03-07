/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FrontVController implements Initializable {

    @FXML
    private Label proName;
    @FXML
    private ImageView prodImage;
    @FXML
    private Label prodPrice;
    @FXML
    private Label prodDes;
    @FXML
    private Label prodID;
    @FXML
    private Text prodDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private Voyage voyage;
  
    
    public void setVoyage(Voyage v){
  this.voyage = v;      
        
        
    }
    
   
    public void setData(Voyage v){
      
        proName.setText(v.getNom());
       prodPrice.setText(v.getPrix()+" DT");
       prodDes.setText(v.getDestination());
       prodID.setText("N " +v.getId());
      prodDescription.setText(v.getDescription());
     // prodImage.setImage(new Image(getClass().getResourceAsStream(v.getImage())));
         // prodImage.setImage(new Image(getClass().getResourceAsStream("/images/egypte.jpg")));
         // prodImage.setImage(new Image(getClass().getResourceAsStream(v.getImage())));
        // prodImage.getImage().impl_getUrl().substring(5);
        // prodImage.setImage(new Image(getClass().getResourceAsStream(v.getImage())));
        
        
        
    }
    
    
}
