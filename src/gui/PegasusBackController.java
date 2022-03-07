/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaErrorEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class PegasusBackController implements Initializable {

    @FXML
    private Button homeBtn;
    @FXML
    private Button Voyage_backBtn;
    @FXML
    private Button Maison_BackBtn;
    @FXML
    private Button Event_backBtn;
    @FXML
    private Button Contact_BackBtn;
    @FXML
    private Button btn_logouta;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
     @FXML
    private void MaisonBackBtn(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardM.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
        stage.show();
        
    }
    @FXML
    private void HomeFront(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PegasusFront.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
        stage.show();
        
    }
       @FXML
       private void VoyageBackBtn(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VoyageBack.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
        stage.show();
        
    }
       
         @FXML
       private void EventSponsor(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("back.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
        stage.show();
        
    }
       
              @FXML
       private void contact(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Front/Interface.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
        stage.show();
        
    }
       
                @FXML
       private void users(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminpage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des maisons d'hotes");
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
