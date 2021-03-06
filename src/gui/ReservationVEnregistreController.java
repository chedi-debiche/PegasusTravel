/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReservationVEnregistreController implements Initializable {

    @FXML
    private TableView<ReservationV> tvReservationV;
    @FXML
    private TableColumn<ReservationV, Integer> colid_res;
    @FXML
    private TableColumn<ReservationV, Integer> colNbr;
    @FXML
    private TableColumn<ReservationV, String> colDate;
    @FXML
    private TableColumn<ReservationV, Integer> colID;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfId_resv;
    @FXML
    private TextField tfNbr;
    @FXML
    private TextField tfId;
    @FXML
    private DatePicker tfDate;

    /**
     * Initializes the controller class.
     */
@FXML
    private void handleButtonAction(ActionEvent event) {        
        
       
         if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReservationV();
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
         public ObservableList<ReservationV> getReservationList(){
        ObservableList<ReservationV> reservationvList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM reservationv";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ReservationV reservationv;
            while(rs.next()){
               // voyage = new Voyage(rs.getInt("id"), rs.getString("nom"), rs.getString("destination"), rs.getString("description"),rs.getInt("prix"));
                reservationv = new ReservationV(rs.getInt("idr"), rs.getInt("nb_personnes"), rs.getString("date"), rs.getInt("Id"));
                reservationvList.add(reservationv);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return reservationvList;
    }
             public void showReservationV(){
        ObservableList<ReservationV> list = getReservationList();
        
        colid_res.setCellValueFactory(new PropertyValueFactory<ReservationV, Integer>("idr"));
        colNbr.setCellValueFactory(new PropertyValueFactory<ReservationV, Integer>("nb_personnes"));
        colDate.setCellValueFactory(new PropertyValueFactory<ReservationV, String>("date"));
        colID.setCellValueFactory(new PropertyValueFactory<ReservationV, Integer>("id"));

        
        tvReservationV.setItems(list);
    }
             
    
             
  
          private void updateRecord(){
       // String query = "UPDATE  voyage SET nom  = '" + tfNom.getText() + "', destination = '" + tfDestination.getText() + "', description = '" + tfDescription.getText() + "', prix = '" + tfPrix.getText() + "' WHERE id = '" + tfId.getText() + "'";
        String query = "UPDATE  ReservationV SET nb_personnes  = '" + tfNbr.getText() + "', date = '" + tfDate.getValue() + "' WHERE idr = '" + tfId_resv.getText() + "'";
        executeQuery(query);
        showReservationV();
    }
          private void deleteButton(){
        String query = "DELETE FROM ReservationV WHERE idr =" + tfId_resv.getText() + "";
        executeQuery(query);
        showReservationV();
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
    private void handleMouseClicked(MouseEvent event) {
        ReservationV reservationv = tvReservationV.getSelectionModel().getSelectedItem();
        tfId_resv.setText("" +reservationv.getIdr());
        tfNbr.setText("" +reservationv.getNb_personnes());
        tfId.setText("" +reservationv.getId());
       
    }

}

