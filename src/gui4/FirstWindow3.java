/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui4;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 21695
 */
public class FirstWindow3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EmployerReclamation.fxml"));
            Scene scene = new Scene(root);
        
            primaryStage.setTitle("Reclamation");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(gui4.FirstWindow3.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }  }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
