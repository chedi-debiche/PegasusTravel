/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesReservation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rahma
 */
public class ResMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("InterfacesRes.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle(" Interface de réservation ");

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
