/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import entities.Evenement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class EventController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label price;
    @FXML
    private Label date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private MyListener myListener ;
private Evenement Event ;
    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListner(Event);
        
    }    
     
     public void setData(Evenement Event, MyListener myListener){
         this.Event = Event;
         this.myListener = myListener;
         name.setText(Event.getNomEvent());
         price.setText(String.valueOf(Event.getPrixEvent()));
         date.setText(String.valueOf(Event.getDate()));
     }
}

