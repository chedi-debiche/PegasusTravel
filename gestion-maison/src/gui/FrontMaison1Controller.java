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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author CC
 */
public class FrontMaison1Controller implements Initializable {

    @FXML
    private Button btnBack;
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
    private Button btnPasserRes;
    @FXML
    private Button BtnConsulter;
    @FXML
    private Button BtnMaps;

    /**
     * Initializes the controller class.
     */
   /* private void handleButtonAction(ActionEvent event) {        
        
        if(event.getSource() == btnInsert_maison){
            insertRecord();
        }else if (event.getSource() == btnUpdate_maison){
            updateRecord();
        }else if(event.getSource() == btnDelete_maison){
            deleteButton();
        }
            
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showMaison();
    }    
     public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx", "root","");
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
            while(rs.next()){
                maisonH = new maisonH(rs.getInt("id_maison"), rs.getString("nom"), rs.getString("localisation"), rs.getString("description"),rs.getFloat("prix"),rs.getString("image_maison"));
                maisonList.add(maisonH);
            }
                
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
        
        
        //recherche avancée
        
         // Wrap the ObservableList in a FilteredList (initially display all data).
    
        
        
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
    private void MaisonRes(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reserverFront.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("Reserver une maison");
        stage.show();
        
    }
    
    
    @FXML
    private void ListeRes(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConsulterReservations.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("listes des reservations");
        stage.show();
        
    }
    
  
    
   
    
    @FXML
     public void closeFn(){
    Stage stage = (Stage) btnBack.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void Map(ActionEvent event) {
        Stage stage = new Stage ();
         
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/gui/googleMaps.html").toString());
       
        // create scene
     //   stage.getIcons().add(new Image("/Images/logo.png"));
        stage.setTitle("localisation");
        Scene scene = new Scene(webView,1000,700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.show();
    }
    static { // use system proxy settings when standalone application
        System.setProperty("java.net.useSystemProxies", "true");
    }
 
        
        

    
}
