/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesSponsor;

import entities.Sponsor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.SponsorCRUD;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class UpdateSController implements Initializable {

    @FXML
    private AnchorPane anchoMod;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextArea taDes;
    @FXML
    private ImageView ivNew;
    @FXML
    private Button bAff;
    @FXML
    private Button bMod;
    @FXML
    private Button bRetour;
    @FXML
    private Button bIm;
    @FXML
    private TableView<Sponsor> tvMod;
    @FXML
    private TableColumn<Sponsor, Integer> Cnom;
    @FXML
    private TableColumn<Sponsor, String> prenomC;
    @FXML
    private TableColumn<Sponsor, String> Cdes;
    private TableColumn< Sponsor, String> Cimage;
    String path;
    BufferedImage bufferedImage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showM(ActionEvent event) {
        SponsorCRUD service = new SponsorCRUD();
       ObservableList<Sponsor> liste =service.AfficherSponsor();

Cnom.setCellValueFactory(new PropertyValueFactory<>("nomS"));
prenomC.setCellValueFactory(new PropertyValueFactory <>("prenomS"));
Cdes.setCellValueFactory(new PropertyValueFactory <>("descriptionS"));
//Cimage.setCellValueFactory(new PropertyValueFactory <>("imageS"));
tvMod.setItems(liste);
    }

    @FXML
    private void UpdateM(ActionEvent event) throws IOException {
        if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || taDes.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else {
         SponsorCRUD sa = new SponsorCRUD();
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String description = taDes.getText();
//          File outputfile = new File(path);
        //mageIO.write(bufferedImage, "png", outputfile);
       // String image = ivNew.get
        Sponsor s = (Sponsor) tvMod.getSelectionModel().getSelectedItem();   
        
        s.setNomS(nom);
       s.setPrenomS(prenom);
       s.setDescriptionS(description);
       sa.modifierSponsor(s);
        sa.AfficherSponsor();
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succées");
        alert.setHeaderText(null);
        alert.setContentText("la modification a été effectué avec succées");
        alert.showAndWait();
    }
    }
    @FXML
    private void retour(ActionEvent event) throws IOException {
       
        Stage stage = (Stage) bRetour.getScene().getWindow();
    stage.close();
                }
    @FXML
    private void ajouterImage(ActionEvent event) {
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

        Stage satge = (Stage) anchoMod.getScene().getWindow();

        File file = filechooser.showOpenDialog(satge);

        if (file != null) {

            try {
                bufferedImage = ImageIO.read(file);
                //filePath = file.toURI().toURL().toString();
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                ivNew.setImage(image);
                String name = file.getName();
                //changer path
                path = "C:\\Users\\rahma\\Desktop\\java\\Pijava\\Images" + name;
//                File outputfile = new File(path);
//                //save
//                ImageIO.write(bufferedImage,"png" , outputfile);

            } catch (IOException ex) {
                Logger.getLogger(SponsorMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
