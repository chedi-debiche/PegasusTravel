/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui4;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Entités.Reclamation;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Services.ReclamationCRUD;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class EmployerReclamationController implements Initializable {

    @FXML
    private TableColumn<Reclamation, String> tfNom;
    @FXML
    private TableColumn<Reclamation, String>tfPrenom;
    @FXML
    private TableColumn<Reclamation, String> tfEmail;
    @FXML
    private TableColumn<Reclamation, String> tfComm;
    @FXML
    private TableColumn<Reclamation, Date> tfDate;
    @FXML
    private TableColumn<Reclamation, String> tfType;
    @FXML
    private TableColumn<Reclamation, String>tfId;
    @FXML
    private Button tbAff;
   ObservableList<Reclamation> dateListe;
   
    @FXML
    private Button BtnStat;
    @FXML
    private TableView<Reclamation> tvAfficher;
    @FXML
    private Button tbREp8;
    @FXML
    private TextField tvRech;
    @FXML
    private Button tbRech;
    @FXML
    private TextField FilteredList;
    
   


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
      
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
    @FXML
    private void show(ActionEvent event) {
        ReclamationCRUD service = new ReclamationCRUD();
          Reclamation r= new Reclamation();
       ObservableList<Reclamation> liste =service.afficherReclamation();

 

tfNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
tfPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
tfEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
tfComm.setCellValueFactory(new PropertyValueFactory<>("Commentaire"));
tfDate.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
tfType.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
tfId.setCellValueFactory(new PropertyValueFactory<>("id"));
//dateListe=(ObservableList<Reclamation>) MyConnection.getInstance();
tvAfficher.setItems(liste);


  
        
        
    }




         
       


    

      @FXML
    private void PDF(ActionEvent event) throws SQLException {

       try {
       com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
       PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\CC\\Pictures\\integrationTest1\\src\\reclamation.pdf"));  
       doc.open();
       
     // Image img = Image.getInstance("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf");
       //img.scaleAbsoluteHeight(60);
       //img.scaleAbsoluteWidth(100);
       //img.setAlignment(Image.ALIGN_RIGHT);
       //doc.open();
       //doc.add(img);
   
       doc.add(new Paragraph(" "));
       Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
       Paragraph p = new Paragraph("liste des Reclamation  ", font);
       p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       doc.add(p);
       doc.add(new Paragraph(" "));
       doc.add(new Paragraph(" "));

       PdfPTable tabpdf = new PdfPTable(8);
       tabpdf.setWidthPercentage(100);
       
       PdfPCell cell;
       cell = new PdfPCell(new Phrase("numero", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("nom", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("prenom", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("commantaire ", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("dateReclamation", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       cell = new PdfPCell(new Phrase(" typeReclamation", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       cell = new PdfPCell(new Phrase("id", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
      
       
       Connection conn = getConnection();
        String query = "SELECT * FROM reclamation";
       
          Statement st;
          ResultSet rs;
          st = conn.createStatement();
          rs = st.executeQuery(query);
     // PreparedStatement pst = cnx.prepareStatement(requete);
      // ResultSet rs = pst.executeQuery();
      while (rs.next()) {
           cell = new PdfPCell(new Phrase(rs.getString("numero"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           
           cell = new PdfPCell(new Phrase(rs.getString("nom"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);

           cell = new PdfPCell(new Phrase(rs.getString("prenom"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           cell = new PdfPCell(new Phrase(rs.getString("email"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           
          cell = new PdfPCell(new Phrase(rs.getString("commentaire"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);

           cell = new PdfPCell(new Phrase(rs.getString("dateReclamation"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
             cell = new PdfPCell(new Phrase(rs.getString("typeReclamation"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
       cell = new PdfPCell(new Phrase(rs.getString("id"), FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       }
     
   
          doc.add(tabpdf);
          JOptionPane.showMessageDialog(null, "Success !!");
          doc.close();
          Desktop.getDesktop().open(new File("C:\\Users\\CC\\Pictures\\integrationTest1\\src\\reclamation.pdf"));
       }
 
        catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
          }
 }
    @FXML
    private void Statistique(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PiedStat.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.setTitle("gestion des Reclamation");
        stage.show();
        
    }

   
    @FXML
    private void reponsEmplo(ActionEvent event) {
        ReclamationCRUD sa = new ReclamationCRUD();
        Reclamation M = tvAfficher.getSelectionModel().getSelectedItem();
       
        tfNom.setText(M.getNom());
        tfPrenom.setText(M.getPrenom());
        tfEmail.setText(M.getEmail());
        tfComm.setText(M.getCommentaire());
        tfType.setText(M.getTypeReclamation());
        tfDate.setText(String.valueOf(M.getDateReclamation()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReponse.fxml"));
        try {
            Stage primaryStage = new Stage();

            Parent root = loader.load();
            InterfaceReponseController mc = loader.getController();
            mc.setNomProd(M.getNom());
            mc.setPrenomProd(M.getPrenom());
            mc.setEmailProd(M.getEmail());
            Scene scene = new Scene(root);

            primaryStage.setTitle("Reponse Sur Reclamation");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void RecherchEmplo(ActionEvent event) {
              ReclamationCRUD rs = new ReclamationCRUD();
       
       List<Reclamation> liste = rs.rechercheParNom(tvRech.getText());
       
        tfNom.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nom"));
        tfPrenom.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("prenom"));
        tfEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tfComm.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tfDate.setCellValueFactory(new PropertyValueFactory<>("DateReclamation"));
        tfType.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
         tfId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvAfficher.setItems((ObservableList<Reclamation>) liste);
    }

    @FXML
    private void searchRec() {
                ReclamationCRUD service = new ReclamationCRUD();
          Reclamation r= new Reclamation();
       ObservableList<Reclamation> liste =service.afficherReclamation();

 

tfNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
tfPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
tfEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
tfComm.setCellValueFactory(new PropertyValueFactory<>("Commentaire"));
tfDate.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
tfType.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
tfId.setCellValueFactory(new PropertyValueFactory<>("id"));
dateListe= service.afficherReclamation();
tvAfficher.setItems(dateListe);


  FilteredList <Reclamation> filteredData;
        filteredData = new FilteredList<>(dateListe, b ->true);
        FilteredList.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Reclamation -> {
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               String lowerCaseFilter = newValue.toLowerCase();
               
               if(Reclamation.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                    }else if(Reclamation.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
               }else if(Reclamation.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
                   
              
                   }else if(Reclamation.getCommentaire().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
               }
               else if(String.valueOf(Reclamation.getDateReclamation()).indexOf(lowerCaseFilter) != -1){
                   return true;
               }
               
               else if(Reclamation.getTypeReclamation().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
               }
               else
               
               
                return false;
               
               
                   
            });
            
            
        }));
        SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvAfficher.comparatorProperty());
        tvAfficher.setItems(sortedData);
        
    }

   

  
    
}

