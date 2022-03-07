/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesReservation;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.ReservationEvenement;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;

import java.sql.Date;

import java.util.Optional;

import javafx.scene.control.ButtonType;

import services.ReservationEvenementCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class InterfacesResController implements Initializable {

    @FXML
    private Button bSupprimer;
    @FXML
    private Button bChercher;
    @FXML
    private TextField tfChercherRes;
    private TextField tfNom;

    @FXML
    private Button bPdf;
    @FXML
    private Button bprint;
    @FXML
    private Button bAfficher1;
    @FXML
    private Button bRefresh;   

    private DatePicker dateRes;
    private TextField id;
    @FXML
    private TableColumn<ReservationEvenement, String> nomCol;
    @FXML
    private TableColumn<ReservationEvenement, Date> dateCol;
    @FXML
    private TableColumn<ReservationEvenement, Integer> idrCol;
    @FXML
    private TableColumn<ReservationEvenement, Integer> ideCol;
    @FXML
    private TableView<ReservationEvenement> tv;
    ObservableList<ReservationEvenement> dateListe;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasustravel", "root", "");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
//    private void addRes(ActionEvent event) {
//        
//        if (tfNom.getText().isEmpty() ) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erreur");
//            alert.setHeaderText(null);
//            alert.setContentText(" vérifier vos informations ");
//            alert.showAndWait();
//        } else if (dateRes.getValue().getYear() < 2022) {
//            Alert al2 = new Alert(Alert.AlertType.ERROR);
//            al2.setHeaderText(null);
//            al2.setContentText("Veuillez choisir une date courante");
//            al2.showAndWait();
//        } else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Succées");
//            alert.setHeaderText(null);
//            alert.setContentText("L'ajout d'un new event a été effectué avec succées");
//            alert.showAndWait();
//            String nom = tfNom.getText();
//        Date date = java.sql.Date.valueOf(dateRes.getValue());
////        Float prix = Float.parseFloat(t fPrix.getText());
//        Integer idEvent1 = Integer.parseInt(id.getText());
//        ReservationEvenement RE = new ReservationEvenement();
//        RE.setdateRE(date);
//        RE.setNomRE(nom);
//      //  RE.setPrixRE(prix);
//       RE.setIdEvent(idEvent1);
//        ReservationEvenementCRUD reservation = new ReservationEvenementCRUD();
//            reservation.AjouterRE(RE);
//
//        }

//        if (reservation.rechercheParIdEvent(RE.getIdEvent()).isEmpty()) {
//            JOptionPane.showMessageDialog(null, " EVENEMENT N'EXIXTE  PAS ");
//        } else {
//            JOptionPane.showMessageDialog(null, " EVENEMENT AJOUTEE   ");
//        }
//
//        reservation.AjouterRE(RE);
//    @FXML
//    private void showRes(ActionEvent event) {
//        ReservationEvenementCRUD service = new ReservationEvenementCRUD();
//        ObservableList<ReservationEvenement> liste = service.AfficherRE();
//
//        nomC.setCellValueFactory(new PropertyValueFactory<>("nomRE"));
//        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));
//        prixC.setCellValueFactory(new PropertyValueFactory<>("prixRE"));
////        IdC.setCellValueFactory(new PropertyValueFactory<>("idRE"));
//        table.setItems(liste);
//
//    }
    private void updateRes(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdaterRes.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
             stage.setTitle(" Interface de modification de réservation ");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
        }
    }

    @FXML
    private void deleteRes(ActionEvent event) {
        ReservationEvenementCRUD se = new ReservationEvenementCRUD();
        ReservationEvenement r = tv.getSelectionModel().getSelectedItem();
        r.setIdEvent(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER L'EVENEMENT ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);

            JOptionPane.showMessageDialog(null, " RESERVATION SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " RESERVATION NON SUPPRIME ");
        }

        se.AfficherRE();

    }

    @FXML
    private void findRes(ActionEvent event) {
//        ReservationEvenementCRUD rs = new ReservationEvenementCRUD();
//        ObservableList<ReservationEvenement> liste = (ObservableList<ReservationEvenement>) rs.rechercheReservationEvenement((tfChercherRes.getText()));
//
//        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomRE"));
//        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateRE"));
////        prix.setCellValueFactory(new PropertyValueFactory<>("prixRE"));
//        ideCol.setCellValueFactory(new PropertyValueFactory<>("idRE"));
//        tv.setItems(liste);
ReservationEvenementCRUD rs = new ReservationEvenementCRUD();
//                ObservableList<Evenement> liste = (ObservableList<Evenement>) rs.rechercheEvenement((tfChercher.getText()));
        ReservationEvenement e = new ReservationEvenement();

                nomCol.setCellValueFactory(new PropertyValueFactory<>("nomRE"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateRE"));
//        prix.setCellValueFactory(new PropertyValueFactory<>("prixRE"));
        ideCol.setCellValueFactory(new PropertyValueFactory<>("idRE"));
        tv.setItems(dateListe);

        dateListe = rs.AfficherRE();
      tv.setItems(dateListe);

        FilteredList<ReservationEvenement> filteredData;
        filteredData = new FilteredList<>(dateListe, b -> true);
        tfChercherRes.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getNomRE().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                
                } else if (String.valueOf(Evenement.getdateRE()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } 
                  else {
                    return false;
                }

            });

        }));
        SortedList<ReservationEvenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tv.comparatorProperty());
        tv.setItems(sortedData);

    }





    @FXML
    private void imprimer(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.tv;

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
    private void getPdf(ActionEvent event) throws SQLException, IOException, DocumentException {
        try {
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\rahma\\Desktop\\java\\Pijava\\Evenement.pdf"));
            doc.open();

            // Image img = Image.getInstance("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf");
            //img.scaleAbsoluteHeight(60);
            //img.scaleAbsoluteWidth(100);
            //img.setAlignment(Image.ALIGN_RIGHT);
            //doc.open();
            //doc.add(img);
            doc.add(new Paragraph(" "));
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
            Paragraph p = new Paragraph("liste des réservations  ", font);
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable tabpdf = new PdfPTable(4);
            tabpdf.setWidthPercentage(100);

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("id", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("nom", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("date", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("id event ", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            Connection conn = getConnection();
            String query = "SELECT * FROM reservationevenement";

            Statement st;

            st = conn.createStatement();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cell = new PdfPCell(new Phrase(rs.getString("idRE"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);
                cell = new PdfPCell(new Phrase(rs.getString("nomRE"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);
                cell = new PdfPCell(new Phrase(rs.getString("dateRE"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

//           cell = new PdfPCell(new Phrase(rs.getString("prixRE"), FontFactory.getFont("Times New Roman", 11)));
//           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//           cell.setBackgroundColor(BaseColor.WHITE);
//           tabpdf.addCell(cell)
                cell = new PdfPCell(new Phrase(rs.getString("idEvent"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);
            }

            doc.add(tabpdf);
            JOptionPane.showMessageDialog(null, "Success !!");
            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\rahma\\Desktop\\java\\Pijava\\Evenement.pdf"));
        } catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void showRes(ActionEvent event) {
        
        ReservationEvenementCRUD service = new ReservationEvenementCRUD();
        ObservableList< ReservationEvenement> liste = service.AfficherRE();
        idrCol.setCellValueFactory(new PropertyValueFactory<>("idRE"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomRE"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateRE"));
        ideCol.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        tv.setItems(liste);
    }
    
    @FXML
    private void refresh(ActionEvent event) {
        
        ReservationEvenementCRUD service = new ReservationEvenementCRUD();
        ObservableList< ReservationEvenement> liste = service.AfficherRE();
        ideCol.setCellValueFactory(new PropertyValueFactory<>("idRE"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomRE"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateRE"));
        ideCol.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        tv.setItems(liste);
    }
}
