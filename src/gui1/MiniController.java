/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui1;

import Entités.Reclamation;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class MiniController implements Initializable {

    @FXML
    private Label Nom;
    @FXML
    private Label Prenom;
    @FXML
    private Label email;
    @FXML
    private Label Commentaire;
    @FXML
    private Label date;
    @FXML
    private Label type;
     @FXML
    private void click(MouseEvent event) {
        mylistener.onClickListener(rec);
        
    }
private MyListener mylistener;
private Reclamation rec;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setData(Reclamation Prod, MyListener myListener){
        {
            this.rec = Prod;
            this.mylistener = myListener;
            Nom.setText(Prod.getNom());
            Prenom.setText(Prod.getPrenom());
            email.setText(Prod.getEmail());
            Commentaire.setText(Prod.getCommentaire());
             date.setText(String.valueOf(Prod.getDateReclamation()));
            type.setText(Prod.getTypeReclamation());
        
     }
    
}
}