/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui3;

import com.stripe.model.issuing.Cardholder.Individual.Verification.Document;
import com.sun.javafx.font.FontFactory;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;
import Entités.Publication;
import Entités.Reclamation;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import Services.PublicationCRUD;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class InPublicationController implements Initializable {

    @FXML
    private DatePicker tfDate;
    @FXML
    private Button tbChoisir;
    @FXML
    private TextArea tfDescrip;
    @FXML
    private TableColumn<Publication, Integer> cid;
    @FXML
    private TableColumn<Publication, String> cdate;
    @FXML
    private TableColumn<Publication, String> cpath;
    @FXML
    private TableColumn<Publication, String> cdesc;
    @FXML
    private Button tbAjouter;
    @FXML
    private AnchorPane anchorpane;
    private String path;
    BufferedImage bufferedImage;
    @FXML
    private ImageView VImage;
    @FXML
    private Button tbAfficherr;
    @FXML
    private TableView<Publication> tvAff;
    @FXML
    private Button tbsupp;
    @FXML
    private Button tbModP;
    @FXML
    private TextField tpRech;
    @FXML
    private Button tvRech;
    @FXML
    private Button imprimer;
    ObservableList<Publication> dateListe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleButtonAction(ActionEvent event) {
           FileChooser filechooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        filechooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        filechooser.setTitle("Open File Dialog");

        Stage satge = (Stage) anchorpane.getScene().getWindow();

        File file = filechooser.showOpenDialog(satge);

        if (file != null) {

            try {
                bufferedImage = ImageIO.read(file);
                //filePath = file.toURI().toURL().toString();
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                VImage.setImage(image);
                String name = file.getName();
                //changer path
                path = "C:\\xampp\\htdocs\\img" + name;
//                File outputfile = new File(path);
//                //save
//                ImageIO.write(bufferedImage,"png" , outputfile);

            } catch (IOException ex) {
                Logger.getLogger(FirstWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AjouterPublic(ActionEvent event) throws IOException {
          if (tfDate.getValue().getYear() > 2022){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("vérifier votre date ");
            alert.showAndWait();
              
          }else{
              if (tfDescrip.getText().toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
          }
              else{
         Date date=java.sql.Date.valueOf(tfDate.getValue());
        String desc =tfDescrip.getText();
        //String image = filePath;
        String image = path;
        File outputfile = new File(path);
        //save
        ImageIO.write(bufferedImage, "png", outputfile);
PublicationCRUD pc = new PublicationCRUD();
       Publication p = new Publication(date,image,desc);
        
        pc.AjoutPub(p);

              }
        
    }
    }
    @FXML
    private void AfficherPub(ActionEvent event) {
        
          PublicationCRUD pc = new PublicationCRUD();
          
       ObservableList<Publication> liste =pc.afficherPub();

 
cid.setCellValueFactory(new PropertyValueFactory<>("idPub"));
cdate.setCellValueFactory(new PropertyValueFactory<>("datePub"));
cpath.setCellValueFactory(new PropertyValueFactory<>("Path"));
cdesc.setCellValueFactory(new PropertyValueFactory<>("description"));

tvAff.setItems(liste);




    }

    @FXML
    private void SupprimerPub(ActionEvent event) {
              PublicationCRUD se = new PublicationCRUD();
        Publication r = tvAff.getSelectionModel().getSelectedItem();
       r.getIdPub();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER UNE Publication ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);

            JOptionPane.showMessageDialog(null, " publication SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " publication NON SUPPRIME ");
        }

//        l_nom.setText("");
//        l_nbr.setText("");
//        l_quan.setText("");

       se.afficherPub();
    }

    @FXML
    private void ModifierPub(ActionEvent event) {
              try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateInM.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
    } catch(IOException e) {
       e.printStackTrace();
      }
    }

    @FXML
    private void RecherchModAp(ActionEvent event) {
        PublicationCRUD rs = new PublicationCRUD();
       
       ObservableList<Publication> liste = (ObservableList<Publication>) rs.rechercheParDescp((tpRech.getText()));
        cid.setCellValueFactory(new PropertyValueFactory<Publication, Integer>("idPub"));
        cdate.setCellValueFactory(new PropertyValueFactory<Publication, String>("datePub"));
        cpath.setCellValueFactory(new PropertyValueFactory<Publication, String>("Path"));
        cdesc.setCellValueFactory(new PropertyValueFactory<Publication, String>("description"));
        
        tvAff.setItems(liste);
        
    }
    private void modifierReclamattion(ActionEvent event) {
         try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateInterface.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
    } catch(Exception e) {
       e.printStackTrace();
      }
    }

//    @FXML
//    private void tvenv(ActionEvent event) {
//        try {
//    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
//            Parent root = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));  
//            stage.show();
//    } catch(IOException e) {
//       e.printStackTrace();
//      }
//    }

    @FXML
    private void OnClickedPrint(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.tvAff;
       
       
     if(job != null){
     job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
     Printer printer = job.getPrinter();
     PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
     }
     }
// try {
//       Document doc = new Document();
//       PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\21695\\Desktop\\PegasusTravel-gestion-contact\\gestion-contact\\Image\\Evenement.pdf"));  
//       doc.open();
//       
//     // Image img = Image.getInstance("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf");
//       //img.scaleAbsoluteHeight(60);
//       //img.scaleAbsoluteWidth(100);
//       //img.setAlignment(Image.ALIGN_RIGHT);
//       //doc.open();
//       //doc.add(img);
//    
//       doc.add(new Paragraph(" "));
//       Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
//       Paragraph p = new Paragraph("Nos evenements ", font);
//       p.setAlignment(Element.ALIGN_CENTER);
//       doc.add(p);
//       doc.add(new Paragraph(" "));
//       doc.add(new Paragraph(" "));
// 
//
//       PdfPTable tabpdf = new PdfPTable(3);
//       tabpdf.setWidthPercentage(100);
//       
//       PdfPCell cell;
//       cell = new PdfPCell(new Phrase("nom", FontFactory.getFont("Times New Roman", 11)));
//       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//       cell.setBackgroundColor(BaseColor.WHITE);
//       tabpdf.addCell(cell);
//       
//       cell = new PdfPCell(new Phrase("type", FontFactory.getFont("Times New Roman", 11)));
//       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//       cell.setBackgroundColor(BaseColor.WHITE);
//       tabpdf.addCell(cell);
//       
//       cell = new PdfPCell(new Phrase("emplacement", FontFactory.getFont("Times New Roman", 11)));
//       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//       cell.setBackgroundColor(BaseColor.WHITE);
//       tabpdf.addCell(cell);
//       
//       
//       Connection conn =  (Connection) MyConnection.getInstance();
//        String query = "SELECT * FROM publication";
//        
//       
//          
//                
//      
//         
//        
//          Statement st;
//          ResultSet rs;
//          st = conn.createStatement();
//          rs = st.executeQuery(query);
//     // PreparedStatement pst = cnx.prepareStatement(requete);
//      // ResultSet rs = pst.executeQuery();
//      while (rs.next()) {
//           cell = new PdfPCell(new Phrase("id_res", FontFactory.getFont("Times New Roman", 11)));
//           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//           cell.setBackgroundColor(BaseColor.WHITE);
//           tabpdf.addCell(cell);
//     
//           cell = new PdfPCell(new Phrase(rs.getString("nb_chambre"), FontFactory.getFont("Times New Roman", 11)));
//           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//           cell.setBackgroundColor(BaseColor.WHITE);
//           tabpdf.addCell(cell);
//           
//           cell = new PdfPCell(new Phrase(rs.getString("nb_personne"), FontFactory.getFont("Times New Roman", 11)));
//           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//           cell.setBackgroundColor(BaseColor.WHITE);
//           tabpdf.addCell(cell);
//       }
//     
//   
//          doc.add(tabpdf);
//          JOptionPane.showMessageDialog(null, "Success !!");
//          doc.close();
//          Desktop.getDesktop().open(new File("C:\\Users\\CC\\3D Objects\\JDBCJAVAFX\\Evenement.pdf"));
//       }
// 
//        catch (DocumentException e) {
//            System.out.println("ERROR PDF");
//            System.out.println(Arrays.toString(e.getStackTrace()));
//            System.out.println(e.getMessage());
//          }
  }

    @FXML
    private void RecherAv(ActionEvent event) {
       PublicationCRUD pc = new PublicationCRUD();
          
       ObservableList<Publication> liste =pc.afficherPub();

 
cid.setCellValueFactory(new PropertyValueFactory<>("idPub"));
cdate.setCellValueFactory(new PropertyValueFactory<>("datePub"));
cpath.setCellValueFactory(new PropertyValueFactory<>("Path"));
cdesc.setCellValueFactory(new PropertyValueFactory<>("description"));

tvAff.setItems(liste);
dateListe= pc.afficherPub();
tvAff.setItems(dateListe);


  FilteredList <Publication> filteredData;
        filteredData = new FilteredList<>(dateListe, b ->true);
        tpRech.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Publication -> {
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               String lowerCaseFilter = newValue.toLowerCase();
               
               if(String.valueOf(Publication.getDatePub()).contains(lowerCaseFilter)){
                   return true;
                    }else if(Publication.getPath().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
               }else if(Publication.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1){
                   return true;
               }
                return false;
                   
            });
            
            
        }));
        SortedList<Publication> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvAff.comparatorProperty());
        tvAff.setItems(sortedData);
        
    }

    }


