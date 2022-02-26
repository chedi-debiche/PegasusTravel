/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author CC
 */
public class MaisonController implements Initializable {

    @FXML
    private TextField tfId_maison;
    @FXML
    private TextField tfNom_maison;
    @FXML
    private TextField tfLocalisation_maison;
    @FXML
    private TextField tfDescription_maison;
    @FXML
    private TextField tfPrix_maison;
    @FXML
    private Button btnInsert_maison;
    @FXML
    private Button btnUpdate_maison;
    @FXML
    private Button btnDelete_maison;
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
    private ImageView logo;
    @FXML
    private TextField filterField;
    @FXML
    private ImageView imageInsertView;
    @FXML
    private Button InsertimgBtn;
    @FXML
    private Label file_path;
    @FXML
    private TableColumn<maisonH, String> colimage_maison;
    

    /**
     * Initializes the controller class.
     */
     @FXML
    private void handleButtonAction(ActionEvent event) {        
        
        if(event.getSource() == btnInsert_maison){
            insertRecord();
        }else if (event.getSource() == btnUpdate_maison){
            updateRecord();
        }else if(event.getSource() == btnDelete_maison){
            deleteButton();
        }
            
    }
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
        colimage_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("image_maison"));

        
        tvMaison.setItems(list);
        
        
        //recherche avancée
        
         // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<maisonH> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(maisonh -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (maisonh.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (maisonh.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(maisonh.getDescription()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                                
                                else if (String.valueOf(maisonh.getPrix()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                                
                                 else if (String.valueOf(maisonh.getId_maison()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                
                                
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<maisonH> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvMaison.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvMaison.setItems(sortedData);
        
        
        
    }
          private void insertRecord(){
        String query = "INSERT INTO maisonH VALUES (" + tfId_maison.getText() + ",'" + tfNom_maison.getText() + "','" + tfLocalisation_maison.getText() + "','" + tfDescription_maison.getText() + "','" + tfPrix_maison.getText() + "','" + file_path.getText() + "')";
        executeQuery(query);
        showMaison();
    //    file_path
    }
          private void updateRecord(){
        String query = "UPDATE  maisonH SET nom  = '" + tfNom_maison.getText() + "', localisation = '" + tfLocalisation_maison.getText() + "', description = '" + tfDescription_maison.getText() + "',prix = '" + tfPrix_maison.getText() + "', image_maison = '" + file_path.getText() + "' WHERE id_maison = '" + tfId_maison.getText() + "'";
        executeQuery(query);
        showMaison();
    }
          private void deleteButton(){
        String query = "DELETE FROM maisonH WHERE id_maison =" + tfId_maison.getText() + "";
        executeQuery(query);
        showMaison();
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
        public void insertImage(){
        
        FileChooser open = new FileChooser();
        
        Stage stage = (Stage)imageInsertView.getScene().getWindow();
        
        File file = open.showOpenDialog(stage);
        
        if(file != null){
            
            String path = file.getAbsolutePath();
            
           // path = path.replace("\\", "\\\\");
            path = path.replace("\\", "\\\\");
            
            file_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);
            
            imageInsertView.setImage(image);
            
        }else{
            
            System.out.println("NO DATA EXIST!");
            
        }
    }
        
    /* public Boolean rechercheMaison(maisonH m , String nom , String localisation) {
       
     
         if (m.getNom().equals(nom) || m.getLocalisation().equals(localisation) )
         { 
             return true;
         } 
     
     return false;
    }*/

}
