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
import static java.time.Clock.system;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class VoyageFrontController implements Initializable {

    @FXML
    private Button ReservationBtn;
    @FXML
    private Label labelDias;
    @FXML
    private TableView<Voyage> tvVoyage;
    @FXML
    private TableColumn<Voyage, Integer> colId;
    @FXML
    private TableColumn<Voyage, String> colNom;
    @FXML
    private TableColumn<Voyage, String> colDestination;
    @FXML
    private TableColumn<Voyage, String> colDescription;
    @FXML
    private TableColumn<Voyage, Integer> colPrix;
    @FXML
    private Label prixlabel;
    @FXML
    private Label nomlabel;
    @FXML
    private Label localisationlabel;
    @FXML
    private Label descriptionlabel;
    @FXML
    private TableColumn<?, ?> colImage;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     showVoyage();
    }    
     public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exx", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
         public ObservableList<Voyage> getVoyageList(){
        ObservableList<Voyage> voyageList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM Voyage";
        Statement st;
        ResultSet rs;
        
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Voyage Voyage;
            
            
             if (rs.next()){
        
         String Nom = rs.getString(2);
         String Localisation = rs.getString(3);
         String Description = rs.getString(4);
         int Prix = rs.getInt(5);
         
         nomlabel.setText(Nom);
         localisationlabel.setText(Localisation);
         descriptionlabel.setText(Description);
         prixlabel.setText(Prix+"DT");

         

         
    
    }
            /*while(rs.next()){
                maisonH = new maisonH(rs.getInt("id_maison"), rs.getString("nom"), rs.getString("localisation"), rs.getString("description"),rs.getFloat("prix"));
                maisonList.add(maisonH);
            }*/
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return voyageList;
    }
          
         public void showVoyage(){
        ObservableList<Voyage> list = getVoyageList();
        
        colId.setCellValueFactory(new PropertyValueFactory<Voyage, Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Voyage, String>("nom"));
        colDestination.setCellValueFactory(new PropertyValueFactory<Voyage, String>("destination"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Voyage, String>("description"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Voyage, Integer>("prix"));
        
        tvVoyage.setItems(list);
    }
            
             
               
             
  
   
 
    
    
}


 