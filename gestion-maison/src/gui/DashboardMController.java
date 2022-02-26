/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class DashboardMController implements Initializable {

    @FXML
    private Button maisonBtn;
    @FXML
    private Button ResBtn;
    @FXML
    private Button closeBtn;

    /**
     * Initializes the controller class.
     */
     @FXML
    private void MaisonBtn(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("maison.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
        stage.show();
        
    }
    
     @FXML
    private void ResBtn(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservationm.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des reservations maisons d'hotes");
        stage.show();
        
    }
    
    @FXML
    public void view_close_fn(){
    Stage stage = (Stage) closeBtn.getScene().getWindow();
    stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}


