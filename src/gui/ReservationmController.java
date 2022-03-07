/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class ReservationmController implements Initializable {

    @FXML
    private TextField tfId_maison;
    @FXML
    private ImageView logo;
    @FXML
    private TextField tfId_reservation;
    @FXML
    private TextField tfNombre_chambre;
    @FXML
    private TextField tfNombre_personne;
    @FXML
    private DatePicker tfDate_reservation;
    @FXML
    private TableView<ReservationM> tvReservation;
    @FXML
    private TableColumn<ReservationM, Integer> colId_reservation;
    @FXML
    private TableColumn<ReservationM, Integer> colNombre_chambre;
    @FXML
    private TableColumn<ReservationM, Integer> colNombre_personne;
    @FXML
    private TableColumn<ReservationM, String> colDate_reservation;
    @FXML
    private TableColumn<ReservationM, Integer> colId_maison;
    private Button btnInsert_reservation;
    private Button btnUpdate_reservation;
    @FXML
    private Button btnDelete_reservation;
    @FXML
    private Button imprimer;
    @FXML
    private Button BtnStat;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {        
        
        if(event.getSource() == btnInsert_reservation){
            insertRecord();
            ajoutersimple(event);
        }else if (event.getSource() == btnUpdate_reservation){
            updateRecord();
        }else if(event.getSource() == btnDelete_reservation){
            deleteButton();
            Suppression(event);
        }
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReservation();
    }    
     public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasustravel", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
         public ObservableList<ReservationM> getReservationmList(){
        ObservableList<ReservationM> ReservationmList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM ReservationM";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ReservationM ReservationM;
            while(rs.next()){
                ReservationM = new ReservationM(rs.getInt("id_res"), rs.getInt("nb_chambre"), rs.getInt("nb_personne"), rs.getString("date"),rs.getInt("id_maison"));
                ReservationmList.add(ReservationM);
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return ReservationmList;
    }
             public void showReservation(){
        ObservableList<ReservationM> list = getReservationmList();
        
        colId_reservation.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("id_res"));
        colNombre_chambre.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("nb_personne"));
        colNombre_personne.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("nb_chambre"));
        colDate_reservation.setCellValueFactory(new PropertyValueFactory<ReservationM, String>("date"));
        colId_maison.setCellValueFactory(new PropertyValueFactory<ReservationM, Integer>("id_maison"));
        
        tvReservation.setItems(list);
    }
          private void insertRecord(){
        String query = "INSERT INTO ReservationM VALUES (" + tfId_reservation.getText() + ",'" + tfNombre_chambre.getText() + "','" + tfNombre_personne.getText() + "','" + tfDate_reservation.getValue() + "','" + tfId_maison.getText() + "')";
        executeQuery(query);
        showReservation();
    }
          private void updateRecord(){
        String query = "UPDATE  ReservationM SET nb_chambre  = '" + tfNombre_chambre.getText() + "', nb_personne = '" + tfNombre_personne.getText() + "', date = '" + tfDate_reservation.getValue() + "', id_maison = '" + tfId_maison.getText() + "' WHERE id_res = '" + tfId_maison.getText() + "'";
        executeQuery(query);
        showReservation();
    }
          private void deleteButton(){
        String query = "DELETE FROM ReservationM WHERE id_res =" + tfId_reservation.getText() + "";
        executeQuery(query);
        showReservation();
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
        
        
 private void CreatePDF(ActionEvent event) throws SQLException, IOException, DocumentException {
    
     try {
       Document doc = new Document();
       PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf"));  
       doc.open();
       
     // Image img = Image.getInstance("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf");
       //img.scaleAbsoluteHeight(60);
       //img.scaleAbsoluteWidth(100);
       //img.setAlignment(Image.ALIGN_RIGHT);
       //doc.open();
       //doc.add(img);
    
       doc.add(new Paragraph(" "));
       Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
       Paragraph p = new Paragraph("Nos evenements ", font);
       p.setAlignment(Element.ALIGN_CENTER);
       doc.add(p);
       doc.add(new Paragraph(" "));
       doc.add(new Paragraph(" "));
 

       PdfPTable tabpdf = new PdfPTable(3);
       tabpdf.setWidthPercentage(100);
       
       PdfPCell cell;
       cell = new PdfPCell(new Phrase("nom", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("type", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("emplacement", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       
       Connection conn = getConnection();
        String query = "SELECT * FROM maisonH";
        
       
          
                
      
         
        
          Statement st;
          ResultSet rs;
          st = conn.createStatement();
          rs = st.executeQuery(query);
     // PreparedStatement pst = cnx.prepareStatement(requete);
      // ResultSet rs = pst.executeQuery();
      while (rs.next()) {
           cell = new PdfPCell(new Phrase("id_res", FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
     
           cell = new PdfPCell(new Phrase(rs.getString("nb_chambre"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           
           cell = new PdfPCell(new Phrase(rs.getString("nb_personne"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
       }
     
   
          doc.add(tabpdf);
          JOptionPane.showMessageDialog(null, "Success !!");
          doc.close();
          Desktop.getDesktop().open(new File("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf"));
       }
 
        catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
          }
    
 }
 
 
    private void ajoutersimple(ActionEvent event) throws IOException 
    {
        if ( tfId_reservation.getText().isEmpty() | tfNombre_chambre.getText().isEmpty() | tfNombre_personne.getText().isEmpty() | tfId_maison.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
 
         else if (tfDate_reservation.getValue().getYear() < 2022)
        {
            Alert al2 = new Alert(Alert.AlertType.ERROR);
            al2.setHeaderText(null);
            al2.setContentText("Veuillez choisir une date courante");
            al2.showAndWait();
        }

}
    
          private void Suppression(ActionEvent event){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("");
     alert.setContentText("Deleted !");
     alert.setHeaderText("Maison Supprimée Avec Succés");
     alert.showAndWait();
    
    
    }
    @FXML     
    private void OnClickedPrint(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.tvReservation;
       
       
     if(job != null){
     job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
     Printer printer = job.getPrinter();
     PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
        
        
     }
     }
    }
    
    @FXML
    private void Statistique(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StatsMaison.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des reservations maisons d'hotes");
        stage.show();
        
    }     
    
    @FXML
    private void handleMouseClicked(MouseEvent event) {
        ReservationM reservationm = tvReservation.getSelectionModel().getSelectedItem();
        tfId_reservation.setText("" +reservationm.getId_res());
        tfNombre_chambre.setText("" +reservationm.getNb_chambre());
        tfNombre_personne.setText("" +reservationm.getNb_personne());
    //    tfDate_reservation.("" +reservationm.getNb_personne());

       
    }
    
    
      @FXML
    private void Exit(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
        JOptionPane.showMessageDialog(null, "Good bye , have a good day :) ");  
    }

    
}




     