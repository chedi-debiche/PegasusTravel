/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author CC
 */
public class ReserverFrontController implements Initializable {

    @FXML
    private TextField tfId_reservation;
    @FXML
    private TextField tfNombre_chambre;
    @FXML
    private TextField tfNombre_personne;
    @FXML
    private DatePicker tfDate_reservation;
    @FXML
    private TextField tfId_maison;
    @FXML
    private Button btnInsert_reservation;
    @FXML
    private Button btnInsert_reservation1;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {        
        
        if(event.getSource() == btnInsert_reservation){
            insertRecord();
            ajoutersimple(event);
            Notification();
            
        
        }
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //  showReservation();
    }    
     public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasustravel", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
  
        
          private void insertRecord(){
        String query = "INSERT INTO ReservationM VALUES (" + tfId_reservation.getText() + ",'" + tfNombre_chambre.getText() + "','" + tfNombre_personne.getText() + "','" + tfDate_reservation.getValue() + "','" + tfId_maison.getText() + "')";
        executeQuery(query);
       // showReservation();
    }
       
        private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML    
    public void closeFn(){
    Stage stage = (Stage) backBtn.getScene().getWindow();
    stage.close();
    }
    
    private void InformationAlert(ActionEvent event){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Votre Réservation Est Enregistrée Avec Succés");
     alert.setContentText("Merci d'utiliser notre application , on vous répond dans les plus brefs délais , bonne journée ");
     alert.setHeaderText("Maison d'hote réservée");
     alert.showAndWait();
    
    
    }
    
   
    
    private void ajoutersimple(ActionEvent event) throws IOException 
    {
        if ( tfId_reservation.getText().isEmpty() | tfNombre_chambre.getText().isEmpty() | tfNombre_personne.getText().isEmpty() | tfId_maison.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
 
         else if (tfDate_reservation.getValue().getYear() < 2022)
        {
            Alert al2 = new Alert(Alert.AlertType.ERROR);
            al2.setHeaderText(null);
            al2.setContentText("Veuillez choisir une date courante");
            al2.showAndWait();
        }

}
    
    public void Notification(){
	Platform.runLater(new Runnable() {
		@Override
		public void run() {
			Notifications notify = Notifications.create().title("Pegasus Travel")
					.text("Votre réservation a été enregistré avec succés , Bonne Journée")
					.hideAfter(javafx.util.Duration.seconds(4))
					.position(Pos.BOTTOM_RIGHT);
			notify.darkStyle();
			notify.showInformation();
		}
	}); 


}
    
}
