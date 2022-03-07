/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class PegasusFrontController implements Initializable {

    @FXML
    private Button buttonAbout;
    @FXML
    private Button WeatherBtn;
    @FXML
    private Button eventBtn;
    @FXML
    private Button btn_logouta;
    @FXML
    private Pane paneMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleSwitch button = new ToggleSwitch();
         SimpleBooleanProperty isOn = button.switchOnProperty();
         isOn.addListener((observable, oldvalue, newValue) -> {
         if(newValue){
             button.getScene().getRoot().getStylesheets().add(getClass().getResource("styles.css").toString());
             System.out.println("adding");
         }else{
             button.getScene().getRoot().getStylesheets().remove(getClass().getResource("styles.css").toString());
             System.out.println("rmoving");
         }
         });
                 paneMain.getChildren().add(button);
    }    
    
     @FXML
    private void Voyages(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VoyFront.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des reservations maisons d'hotes");
        stage.show();
        
    }
    
    @FXML
    private void maisonHotes(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MFront.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des reservations maisons d'hotes");
        stage.show();
        
    }
    
        @FXML
    private void EvenementsBtn(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showEvents.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("evenements ");
        stage.show();
        
    }  
    
            @FXML
    private void ContactBtn(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui1/InAjouterRec.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("reclamation ");
        stage.show();
        
    }  
    
       @FXML
    private void Weather(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle(" Weather check ");
        stage.show();
        
    }     
    
    
    @FXML
    private void About(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AboutUs.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("Pegasus Travel");
        stage.show();
        
    }   
    
    
    @FXML
         public void logout(ActionEvent event) throws Exception{
         btn_logouta.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Successfully log out");
        alert.showAndWait();
         
     }
}
