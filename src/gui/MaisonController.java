/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import com.gembox.spreadsheet.CellValueType;
//import com.gembox.spreadsheet.ExcelCell;
//import com.gembox.spreadsheet.ExcelColumnCollection;
//import com.gembox.spreadsheet.ExcelFile;
//import com.gembox.spreadsheet.ExcelWorksheet;
//import com.qoppa.pdfViewerFX.PDFViewer;
import com.itextpdf.text.Font;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import javafx.application.Application;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Pagination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Database;

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
    @FXML
    private Button imprimer;
 

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == btnInsert_maison) {
            insertRecord();
            ajoutersimple(event);
        } else if (event.getSource() == btnUpdate_maison) {
            updateRecord();
            ajoutersimple(event);

        } else if (event.getSource() == btnDelete_maison) {
            deleteButton();
            Suppression(event);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showMaison();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasustravel", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public ObservableList<maisonH> getMaisonList() {
        ObservableList<maisonH> maisonList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM maisonH";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            maisonH maisonH;
            while (rs.next()) {
                maisonH = new maisonH(rs.getInt("id_maison"), rs.getString("nom"), rs.getString("localisation"), rs.getString("description"), rs.getFloat("prix"), rs.getString("image_maison"));
                maisonList.add(maisonH);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maisonList;
    }

    public void showMaison() {
        ObservableList<maisonH> list = getMaisonList();

        colId_maison.setCellValueFactory(new PropertyValueFactory<maisonH, Integer>("id_maison"));
        colNom_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("nom"));
        colLocalisation_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("localisation"));
        colDescription_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("description"));
        colPrix_maison.setCellValueFactory(new PropertyValueFactory<maisonH, Float>("prix"));
        colimage_maison.setCellValueFactory(new PropertyValueFactory<maisonH, String>("image_maison"));
      
        
        tvMaison.setItems(list);

        //recherche avanc??e
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

                if (maisonh.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (maisonh.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(maisonh.getDescription()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(maisonh.getPrix()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(maisonh.getId_maison()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
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

    private void insertRecord() {
        String query = "INSERT INTO maisonH VALUES (" + tfId_maison.getText() + ",'" + tfNom_maison.getText() + "','" + tfLocalisation_maison.getText() + "','" + tfDescription_maison.getText() + "','" + tfPrix_maison.getText() + "','" + file_path.getText() + "')";
        executeQuery(query);
        showMaison();
        //    file_path
    }

    private void updateRecord() {
        String query = "UPDATE  maisonH SET nom  = '" + tfNom_maison.getText() + "', localisation = '" + tfLocalisation_maison.getText() + "', description = '" + tfDescription_maison.getText() + "',prix = '" + tfPrix_maison.getText() + "', image_maison = '" + file_path.getText() + "' WHERE id_maison = '" + tfId_maison.getText() + "'";
        executeQuery(query);
        showMaison();
    }

    private void deleteButton() {
        String query = "DELETE FROM maisonH WHERE id_maison =" + tfId_maison.getText() + "";
        executeQuery(query);
        showMaison();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void insertImage() {

        FileChooser open = new FileChooser();

        Stage stage = (Stage) imageInsertView.getScene().getWindow();

        File file = open.showOpenDialog(stage);

        if (file != null) {

            String path = file.getAbsolutePath();

            // path = path.replace("\\", "\\\\");
            path = path.replace("\\", "\\\\");

            file_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);

            imageInsertView.setImage(image);

        } else {

            System.out.println("NO DATA EXIST!");

        }

    }

    private void ajoutersimple(ActionEvent event) throws IOException {
        if (tfId_maison.getText().isEmpty() | tfNom_maison.getText().isEmpty() | tfLocalisation_maison.getText().isEmpty() | tfDescription_maison.getText().isEmpty() | tfPrix_maison.getText().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }

    }

    private void Suppression(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Maison Supprim??e Avec Succ??s");
        alert.setContentText("");
        alert.setHeaderText("Maison d'hote supprim??e");
        alert.showAndWait();

    }

    @FXML
    private void OnClickedPrint(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.tvMaison;

        if (job != null) {
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
            }
        }
    }

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        maisonH maisonh = tvMaison.getSelectionModel().getSelectedItem();
        tfId_maison.setText("" + maisonh.getId_maison());
        tfNom_maison.setText("" + maisonh.getNom());
        tfLocalisation_maison.setText("" + maisonh.getLocalisation());
        tfDescription_maison.setText("" + maisonh.getDescription());
        tfPrix_maison.setText("" + maisonh.getPrix());

    }

    
    
}

