/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;
import InterfacesEvent.InterfacesEventController ;
import InterfacesEvent.PrinWindow ;
import InterfacesEvent.UpdateEventController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rahma
 */
public class FrontMain extends Application {

   
   @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("showEvents.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle(" Interface Principale  ");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
            }
    public static void main(String[] args) {
        launch(args);
    }
    
}
