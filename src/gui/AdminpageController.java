/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import org.apache.commons.codec.digest.DigestUtils;

/**
 * FXML Controller class
 *
 * @author Zoghlami
 */
public class AdminpageController implements Initializable {

      @FXML
    private Button add_emp;
      
      @FXML
    private Button btn_logouta;
     
       @FXML
    private TableView<employee> emp_tab;

    @FXML
    private TableColumn<employee, String> call_email;

    @FXML
    private TableColumn<employee, String> call_lastn;

    @FXML
    private TableColumn<employee, String> call_pos;

    @FXML
    private TableColumn<employee, String> call_pwd;

    @FXML
    private TableColumn<employee, Integer> call_sal;

    @FXML
    private TableColumn<employee, Integer> coll_id;

    @FXML
    private TableColumn<employee, String> coll_name;
    
    @FXML
    private TextField emp_id;
    
    @FXML
    private TextField emp_rech;


    @FXML
    private Button del_emp;

    @FXML
    private TextField emp_e;

    @FXML
    private TextField emp_fn;

    @FXML
    private TextField emp_ln;

    @FXML
    private TextField emp_pos;

    @FXML
    private TextField emp_pwd;

    @FXML
    private TextField emp_sal;

    @FXML
    private Button upd_emp;
    
    ObservableList<employee> empList;
     ObservableList<employee> dataList;
    
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @FXML
 void getSelected (javafx.scene.input.MouseEvent event){
         index = emp_tab.getSelectionModel().getSelectedIndex();
         if(index <= -1){
             
             return;
         } 
         emp_id.setText(coll_id.getCellData(index).toString());
         emp_fn.setText(coll_name.getCellData(index));
         emp_ln.setText(call_lastn.getCellData(index));
         emp_e.setText(call_email.getCellData(index));
         emp_pwd.setText(call_pwd.getCellData(index));
          emp_pos.setText(call_pos.getCellData(index));
          emp_sal.setText(call_sal.getCellData(index).toString());
         
     }
    
    
    
    
     public void add_emp(ActionEvent event)throws Exception{
        
        try {
          
             if (emp_fn.getText() == null || emp_fn.getText().trim().isEmpty()
                     || emp_ln.getText() == null||emp_ln.getText().trim().isEmpty()|| emp_e.getText() == null || emp_e.getText().isEmpty()|| 
                       emp_pwd.getText() == null ||emp_pwd.getText().isEmpty()|| emp_pos.getText() == null||emp_pos.getText().trim().isEmpty()
                     || emp_sal.getText() == null||emp_sal.getText().trim().isEmpty()) {
                 
      Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
        
}
             else{
                 conn = mysqlconnection.ConnectDB();
        String sql ="INSERT INTO  users (nom,prenom,email,pwd,poste,salaire,role)"
+ "VALUES(?,?,?,?,?,?,?)";
                  pst = conn.prepareStatement(sql);
            pst.setString(1,emp_fn.getText());
            pst.setString(2,emp_ln.getText());
            pst.setString(3,emp_e.getText());
            pst.setString(4,DigestUtils.sha1Hex(emp_pwd.getText()));
            pst.setString(5,emp_pos.getText());
            pst.setString(6,emp_sal.getText());
            pst.setString(7, "employee");
            
           
                  pst.executeUpdate();
                  
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Account succesfully created!");
        alert.showAndWait();
        UpdateTable();
        searchemp();
       
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      
    }         
    }
     
     public void Edit (ActionEvent event){
         try {
             
             if (emp_fn.getText() == null || emp_fn.getText().trim().isEmpty()
                     && emp_ln.getText() == null||emp_ln.getText().trim().isEmpty()&& emp_e.getText() == null || emp_e.getText().isEmpty()&& 
                       emp_pwd.getText() == null ||emp_pwd.getText().isEmpty()&& emp_pos.getText() == null||emp_pos.getText().trim().isEmpty()
                     && emp_sal.getText() == null||emp_sal.getText().trim().isEmpty()) {
                 
      Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
             }
             
             conn = mysqlconnection.ConnectDB();
             String value1 = emp_id.getText();
             String value2 = emp_fn.getText();
             String value3 = emp_ln.getText();
             String value4 = emp_e.getText();
             String value5 = DigestUtils.sha1Hex( emp_pwd.getText());
             String value6 = emp_pos.getText();
             String value7 = emp_sal.getText();
             
             String sqledit = "update users set id = '"+value1+"' , nom = '"+value2+"' , prenom = '"+value3+"' "
                     + ",  email = '"+value4+"' ,  pwd = '"+value5+"' ,poste= '"+value6+"' ,salaire = '"+value7+"'where id= '"+value1+"'";
             pst = conn.prepareStatement(sqledit);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Updated");
             UpdateTable();
             searchemp();
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
         
     }
     
     public void Delete(){
         conn = mysqlconnection.ConnectDB();
         String sqld = "delete from users where id = ?";
         try {
             pst = conn.prepareStatement(sqld);
             pst.setString(1, emp_id.getText());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Deleted");
             UpdateTable();
             searchemp();
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
         
         
     }
     
     
     public void UpdateTable(){
         coll_id.setCellValueFactory(new PropertyValueFactory<employee , Integer>("id"));
         coll_name.setCellValueFactory(new PropertyValueFactory<employee , String>("nom"));
         call_lastn.setCellValueFactory(new PropertyValueFactory<employee , String>("prenom"));
         call_email.setCellValueFactory(new PropertyValueFactory<employee , String>("email"));
         call_pwd.setCellValueFactory(new PropertyValueFactory<employee , String>("pwd"));
         call_pos.setCellValueFactory(new PropertyValueFactory<employee , String>("poste"));
         call_sal.setCellValueFactory(new PropertyValueFactory<employee , Integer>("salaire"));
         empList = mysqlconnection.getemployeeList();
         emp_tab.setItems(empList);
     }
   @FXML
    void searchemp(){
        coll_id.setCellValueFactory(new PropertyValueFactory<employee , Integer>("id"));
         coll_name.setCellValueFactory(new PropertyValueFactory<employee , String>("nom"));
         call_lastn.setCellValueFactory(new PropertyValueFactory<employee , String>("prenom"));
         call_email.setCellValueFactory(new PropertyValueFactory<employee , String>("email"));
         call_pwd.setCellValueFactory(new PropertyValueFactory<employee , String>("pwd"));
         call_pos.setCellValueFactory(new PropertyValueFactory<employee , String>("poste"));
         call_sal.setCellValueFactory(new PropertyValueFactory<employee , Integer>("salaire"));
         dataList = mysqlconnection.getemployeeList();
         emp_tab.setItems(dataList);
         
        FilteredList<employee> filteredData = new FilteredList<>(dataList, b ->true);
        emp_rech.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               String lowerCaseFilter = newValue.toLowerCase();
               
               if(employee.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
               }else if(employee.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
               }else if(employee.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
               }
               else if(String.valueOf(employee.getPoste()).indexOf(lowerCaseFilter) != -1){
                   return true;
               }
                else if(String.valueOf(employee.getSalaire()).indexOf(lowerCaseFilter) != -1){
                   return true;
               }
                 else if(String.valueOf(employee.getId()).indexOf(lowerCaseFilter) != -1){
                   return true;
               }
               
               
               else
               
               
                return false;
               
               
                   
            });
            
            
        }));
        SortedList<employee> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(emp_tab.comparatorProperty());
        emp_tab.setItems(sortedData);
        
        
        
        
    }
    
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UpdateTable();
        searchemp();
        
     
    }    
    

   
    
}
