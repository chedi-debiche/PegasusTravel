/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Zoghlami
 */
public class EmployeepageController implements Initializable {

    @FXML
    private Button btn_delc;
    
    @FXML
    private Button btn_logoute;

    @FXML
    private TableColumn<Client,String> col_ec;

    @FXML
    private TableColumn<Client, Integer> col_idc;

    @FXML
    private TableColumn<Client, String> col_nc;

    @FXML
    private TableColumn<Client, String> col_pc;

    @FXML
    private TableColumn<Client, String> col_pwdc;

    @FXML
    private TableView<Client> tab_c;

    @FXML
    private TextField txt_ec;

    @FXML
    private TextField txt_idc;

    @FXML
    private TextField txt_nc;

    @FXML
    private TextField txt_pc;

    @FXML
    private TextField txt_pwdc;

    @FXML
    private TextField txt_searc;
    
    int index = -1;
    
    ObservableList<Client> clieList;
     ObservableList<Client> datacList;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    @FXML
    public void UpdateTableC(){
         col_idc.setCellValueFactory(new PropertyValueFactory<Client , Integer>("id"));
          col_nc.setCellValueFactory(new PropertyValueFactory<Client , String>("nom"));
          col_pc.setCellValueFactory(new PropertyValueFactory<Client , String>("prenom"));
          col_ec.setCellValueFactory(new PropertyValueFactory<Client , String>("email"));
          col_pwdc.setCellValueFactory(new PropertyValueFactory<Client , String>("pwd"));
         
         clieList = mysqlconnection.getclientList();
         tab_c.setItems(clieList);
         
         
    }
    
    @FXML
     public void Delete(){
         conn = mysqlconnection.ConnectDB();
         String sqld = "delete from users where id = ?";
         try {
             pst = conn.prepareStatement(sqld);
             pst.setString(1, txt_idc.getText());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Deleted");
             UpdateTableC();
            searchcli();
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
         
         
     }
     
     @FXML
 void getSelected (javafx.scene.input.MouseEvent event){
         index = tab_c.getSelectionModel().getSelectedIndex();
         if(index <= -1){
             
             return;
         } 
         txt_idc.setText(col_idc.getCellData(index).toString());
         txt_nc.setText(col_nc.getCellData(index));
         txt_pc.setText(col_pc.getCellData(index));
         txt_ec.setText(col_ec.getCellData(index));
         txt_pwdc.setText(col_pwdc.getCellData(index));
         
         
     }
 
 void searchcli(){
        col_idc.setCellValueFactory(new PropertyValueFactory<Client , Integer>("id"));
          col_nc.setCellValueFactory(new PropertyValueFactory<Client , String>("nom"));
          col_pc.setCellValueFactory(new PropertyValueFactory<Client , String>("prenom"));
          col_ec.setCellValueFactory(new PropertyValueFactory<Client , String>("email"));
          col_pwdc.setCellValueFactory(new PropertyValueFactory<Client , String>("pwd"));
         datacList = mysqlconnection.getclientList();
         tab_c.setItems(datacList);
         
        FilteredList<Client> filteredData = new FilteredList<>(datacList, b ->true);
        txt_searc.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Client -> {
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               String lowerCaseFilter = newValue.toLowerCase();
               
               if(Client.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
               }else if(Client.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
               }else if(Client.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
               } else if(String.valueOf(Client.getId()).indexOf(lowerCaseFilter) != -1){
                   return true;
               }
               else
               
                return false;
               
            });
            
            
        }));
        SortedList<Client> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tab_c.comparatorProperty());
        tab_c.setItems(sortedData);
        
    }
    @FXML
     public void logout(ActionEvent event) throws Exception{
         btn_logoute.getScene().getWindow().hide();
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
 
       
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTableC();
        searchcli();
    }    
    
}
