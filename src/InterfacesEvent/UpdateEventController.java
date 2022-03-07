/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesEvent;

import Entités.Evenement;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import Services.EvenementCRUD;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class UpdateEventController implements Initializable {

    @FXML
    private TextField NewName;
    @FXML
    private TextField NewPrix;
    @FXML
    private DatePicker NewDate;
    @FXML
    private TableView<Evenement> tableV;
    @FXML
    private TableColumn<Evenement, String> nomC;
    @FXML
    private TableColumn<Evenement, Float> prixC;
    @FXML
    private TableColumn<Evenement, Date> dateC;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private Button bFermer;
    @FXML
    private TableColumn<?, ?> idC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherEvent(ActionEvent event) {
           EvenementCRUD service = new  EvenementCRUD();      
       ObservableList< Evenement> liste =service.AfficherEvenement();
       
idC.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
nomC.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
prixC.setCellValueFactory(new PropertyValueFactory<>("prixEvent"));
tableV.setItems(liste);
    }

    @FXML
    private void updateEvent(ActionEvent event) {
     EvenementCRUD sa = new EvenementCRUD();

        String nom = NewName.getText();
        if (NewName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
         alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else if (NewDate.getValue().getYear() < 2022) {
            Alert al2 = new Alert(Alert.AlertType.ERROR);
            al2.setHeaderText(null);
            al2.setContentText("Veuillez choisir une date courante");
            al2.showAndWait();
        } else {
        Float prix = Float.parseFloat(NewPrix.getText());
        Date date = java.sql.Date.valueOf(NewDate.getValue());
        Evenement re =  tableV.getSelectionModel().getSelectedItem();
        
        re.setDate(date);
        re.setNomEvent(nom);
        sa.modifier(re);
        sa.AfficherEvenement();
         
    }
    }
    @FXML
    private void close(ActionEvent event) {
         Stage stage = (Stage) bFermer.getScene().getWindow();
    stage.close();
    }
    
}
