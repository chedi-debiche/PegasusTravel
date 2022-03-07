/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui3;

import Entités.Publication;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
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
import Services.PublicationCRUD;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class UpdateInMController implements Initializable {

    @FXML
    private TableColumn<Publication, Integer> idc;
    @FXML
    private TableColumn<Publication, String> datec;
    @FXML
    private TableColumn<Publication, String> pathc;
    @FXML
    private TableColumn<Publication, String> descpC;
    @FXML
    private TextField tfNp;
    @FXML
    private DatePicker dppub;
    @FXML
    private Button tbaff;
    @FXML
    private Button tbModpub;
    @FXML
    private TableView<Publication> tvMod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AffMod1(ActionEvent event) {
        PublicationCRUD pc = new PublicationCRUD();
          
       ObservableList<Publication> liste =pc.afficherPub();

 
idc.setCellValueFactory(new PropertyValueFactory<>("idPub"));
datec.setCellValueFactory(new PropertyValueFactory<>("datePub"));
pathc.setCellValueFactory(new PropertyValueFactory<>("Path"));
descpC.setCellValueFactory(new PropertyValueFactory<>("description"));

tvMod.setItems(liste);
    }

    @FXML
    private void Modifpub(ActionEvent event) {
        if (tfNp.getText().toString().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();}
         
           else if (dppub.getValue().getYear() > 2022) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("vérifier votre date ");
            alert.showAndWait();
            }else{
             
            
            
      
        PublicationCRUD  sa = new PublicationCRUD ();

        String desp = tfNp.getText();
        Date date = java.sql.Date.valueOf(dppub.getValue());
        Publication re = (Publication) tvMod.getSelectionModel().getSelectedItem();
        re.setDatePub(date);
        re.setDescription(desp);
        sa.modifier(re);
        sa.afficherPub();
    }
    
}}
