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
public class FrontmaisonController implements Initializable {

    @FXML
    private Button ReservationBtn;
    @FXML
    private Label labelDias;
    @FXML
    private TextField prixM;
    @FXML
    private TableView<maisonH> tvMaison;
    @FXML
    private TableColumn<maisonH, Integer> colId_maison;
    @FXML
    private TableColumn<maisonH, String> colNom_maison;
    @FXML
    private TableColumn<maisonH, String> colLocalisation_maison;
    @FXML
    private TableColumn<maisonH, String> colDescription_maison;
    @FXML
    private TableColumn<maisonH, Float> colPrix_maison;
    @FXML
    private TableColumn<maisonH, Float> colPrix_maison1;
    @FXML
    private Label prixlabel;
    @FXML
    private Label nomlabel;
    @FXML
    private Label localisationlabel;
    @FXML
    private Label descriptionlabel;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      showMaison();
    }    
     public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test44", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
         public ObservableList<maisonH> getMaisonList(){
        ObservableList<maisonH> maisonList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM maisonH";
        Statement st;
        ResultSet rs;
        
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            maisonH maisonH;
            
            
             if (rs.next()){
        
         String Nom = rs.getString(2);
         String Localisation = rs.getString(3);
         String Description = rs.getString(4);
         Float Prix = rs.getFloat(5);
         
         nomlabel.setText(Nom);
         localisationlabel.setText(Localisation);
         descriptionlabel.setText(Description);
         prixlabel.setText(Prix+"dt");

         

         
    
    }
            /*while(rs.next()){
                maisonH = new maisonH(rs.getInt("id_maison"), rs.getString("nom"), rs.getString("localisation"), rs.getString("description"),rs.getFloat("prix"));
                maisonList.add(maisonH);
            }*/
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return maisonList;
    }
             public void showMaison(){
        ObservableList<maisonH> list = getMaisonList();
        
        colId_maison.setCellValueFactory(new PropertyValueFactory<maisonH, Integer>("id_maison"));
        colNom_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("nom"));
        colLocalisation_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("localisation"));
        colDescription_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("description"));
        colPrix_maison.setCellValueFactory(new PropertyValueFactory<maisonH, Float>("prix"));
        
        tvMaison.setItems(list);
    }
             
             
               
             
  
   
 
    
    
}


 