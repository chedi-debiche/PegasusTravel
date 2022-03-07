/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class Main extends Application {
    
   @Override
      public void start(Stage primaryStage) throws Exception {
 Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
            Scene scene = new Scene(root);
        
            primaryStage.setTitle("Gestion Contact");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(gui1.FirstWindow.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
