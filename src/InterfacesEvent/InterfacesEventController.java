/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesEvent;

import Entités.Evenement;
//import Services.EvenementCrud;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Services.EvenementCRUD;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class InterfacesEventController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private DatePicker dpDate;
    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Evenement> table;
    private TableColumn<Evenement, Integer> idC;
    @FXML
    private TableColumn<Evenement, String> nomC;

    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private TextField tfChercher;
    @FXML
    private Button bChercher;
    @FXML
    private Button bAjouter1;

    @FXML
    private TableColumn<Evenement, Float> prixC;
    @FXML
    private TextField tfPrix;
    @FXML
    private TableColumn<Evenement, Date> dateC;
    private ObservableList<Evenement> dateListe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @FXML
    private void getDate(ActionEvent event) {
    }

    @FXML
    private void addEvent(ActionEvent event) {
        String nom = tfNom.getText();
        Float prix = Float.parseFloat(tfPrix.getText());
        Date date = java.sql.Date.valueOf(dpDate.getValue());
        // Evenement E= new Evenement(nom, date);
        EvenementCRUD Evenement = new EvenementCRUD();
        if (tfNom.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
        alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else if (dpDate.getValue().getYear() < 2022) {
            Alert al2 = new Alert(Alert.AlertType.ERROR);
            al2.setHeaderText(null);
            al2.setContentText("Veuillez choisir une date courante");
            al2.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succées");
            alert.setHeaderText(null);
            alert.setContentText("L'ajout d'un new event a été effectué avec succées");
            alert.showAndWait();
            Evenement E = new Evenement(nom, prix, date);
            Evenement.AjouterEvenement(E);

        }
    }

    @FXML
    private void showEvent(ActionEvent event) {
        EvenementCRUD service = new EvenementCRUD();
        ObservableList<Evenement> liste = service.AfficherEvenement();
        nomC.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prixEvent"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(liste);
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateEvent.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            stage.setTitle(" Interface de modification ");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void deleteEvent(ActionEvent event) throws Exception {
        EvenementCRUD se = new EvenementCRUD();
        Evenement r = table.getSelectionModel().getSelectedItem();
        r.setIdEvent(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER L'EVENEMENT ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);

            JOptionPane.showMessageDialog(null, " EVENEMENT SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " EVENEMENT NON SUPPRIME ");
        }
        se.AfficherEvenement();
    }

    @FXML
    private void findEvent(ActionEvent event) {
//        EvenementCRUD rs = new EvenementCRUD();
//        ObservableList<Evenement> liste = (ObservableList<Evenement>) rs.rechercheEvenement((tfChercher.getText()));
//
//        nomC.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
//        prixC.setCellValueFactory(new PropertyValueFactory<>("prixEvent"));
//        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
//        table.setItems(liste);

        EvenementCRUD rs = new EvenementCRUD();
//                ObservableList<Evenement> liste = (ObservableList<Evenement>) rs.rechercheEvenement((tfChercher.getText()));
        Evenement e = new Evenement();

        nomC.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prixEvent"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(dateListe);

        dateListe = rs.AfficherEvenement();
      table.setItems(dateListe);

        FilteredList<Evenement> filteredData;
        filteredData = new FilteredList<>(dateListe, b -> true);
        tfChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getNomEvent().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                
                } else if (String.valueOf(Evenement.getDate()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (String.valueOf(Evenement.getPrixEvent()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }  else {
                    return false;
                }

            });

        }));
        SortedList<Evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);

    }


//    @FXML
//    private void selectEvent(MouseEvent event) {
//         Evenement M= table.getSelectionModel().getSelectedItem();
//     
//
//     tfNom.setText(M.getNom());
//    
//    }
@FXML
        private void selectEvent(MouseEvent event) {
    }

    @FXML
        private void refresh(ActionEvent event) {
        EvenementCRUD service = new EvenementCRUD();

        ObservableList<Evenement> liste = service.AfficherEvenement();

        nomC.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prixEvent"));

        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(liste);
    }

}
