/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class ConsulterReservationsController implements Initializable {

    @FXML
    private TextField tfId_maison;
    @FXML
    private TextField tfId_reservation;
    @FXML
    private TextField tfNombre_chambre;
    @FXML
    private TextField tfNombre_personne;
    @FXML
    private DatePicker tfDate_reservation;
    @FXML
    private TableView<ReservationM> tvReservation;
    @FXML
    private TableColumn<ReservationM, Integer> colId_reservation;
    @FXML
    private TableColumn<ReservationM, Integer> colNombre_chambre;
    @FXML
    private TableColumn<ReservationM, Integer> colNombre_personne;
    @FXML
    private TableColumn<ReservationM, String> colDate_reservation;
    @FXML
    private TableColumn<ReservationM, Integer> colId_maison;
    @FXML
    private Button btnDelete_reservation;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {        
        
        if(event.getSource() == btnDelete_reservation){
                  deleteButton();
                  Suppression(event);

        }
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReservation();
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
         public ObservableList<ReservationM> getReservationmList(){
        ObservableList<ReservationM> ReservationmList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM ReservationM";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ReservationM ReservationM;
            while(rs.next()){
                ReservationM = new ReservationM(rs.getInt("id_res"), rs.getInt("nb_chambre"), rs.getInt("nb_personne"), rs.getString("date"),rs.getInt("id_maison"));
                ReservationmList.add(ReservationM);
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return ReservationmList;
    }
             public void showReservation(){
        ObservableList<ReservationM> list = getReservationmList();
        
        colId_reservation.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("id_res"));
        colNombre_chambre.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("nb_personne"));
        colNombre_personne.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("nb_chambre"));
        colDate_reservation.setCellValueFactory(new PropertyValueFactory<ReservationM, String>("date"));
        colId_maison.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("id_maison"));
        
        tvReservation.setItems(list);
    }
          private void insertRecord(){
        String query = "INSERT INTO ReservationM VALUES (" + tfId_reservation.getText() + ",'" + tfNombre_chambre.getText() + "','" + tfNombre_personne.getText() + "','" + tfDate_reservation.getValue() + "','" + tfId_maison.getText() + "')";
        executeQuery(query);
        showReservation();
    }
          private void updateRecord(){
        String query = "UPDATE  ReservationM SET nb_chambre  = '" + tfNombre_chambre.getText() + "', nb_personne = '" + tfNombre_personne.getText() + "', date = '" + tfDate_reservation.getValue() + "', id_maison = '" + tfId_maison.getText() + "' WHERE id_res = '" + tfId_maison.getText() + "'";
        executeQuery(query);
        showReservation();
    }
              
          
          private void deleteButton(){
        String query = "DELETE FROM ReservationM WHERE id_res =" + tfId_reservation.getText() + "";
        executeQuery(query);
        showReservation();
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
        
        
                  private void Suppression(ActionEvent event){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Maison Supprimée Avec Succés");
     alert.setContentText("");
     alert.setHeaderText("Maison d'hote supprimée");
     alert.showAndWait();
    
    
    }

    
}
