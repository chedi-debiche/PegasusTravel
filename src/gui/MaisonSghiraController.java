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
public class MaisonSghiraController implements Initializable {

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
     private maisonH maisonh;
  
    
    public void setmaisonH(maisonH m){
  this.maisonh = m;      
        
        
    }
    
   
    public void setData(maisonH m){
      
        proName.setText(m.getNom());
       prodPrice.setText(m.getPrix()+" DT");
           //   prodDes.setText(m.getDescription());

       prodDes.setText(m.getLocalisation());
       prodID.setText("N " +m.getId_maison());
     prodDescription.setText(m.getDescription());
 //    prodImage.setImage(new Image(getClass().getResourceAsStream(m.getImage_maison())));
         // prodImage.setImage(new Image(getClass().getResourceAsStream("/images/egypte.jpg")));
         // prodImage.setImage(new Image(getClass().getResourceAsStream(v.getImage())));
        // prodImage.getImage().impl_getUrl().substring(5);
        // prodImage.setImage(new Image(getClass().getResourceAsStream(v.getImage())));
        
        
        
    }
    
    
}
