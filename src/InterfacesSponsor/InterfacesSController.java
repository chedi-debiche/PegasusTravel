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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import services.SponsorCRUD;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class InterfacesSController implements Initializable {

    private TableColumn<Sponsor, String> imageS;
    @FXML
    private TextField tfNomS;
    @FXML
    private TextField tfPrenomS;
    @FXML
    private TextArea taDes;
    @FXML
    private Button bAjouter;
    @FXML
    private Button bAfficher;
    @FXML
    private Button bModifier;
    @FXML
    private Button bSupprimer;
    @FXML
    private Button bChercher;
    private TableColumn <Sponsor, Integer> idC;
    @FXML
    private TableColumn<Sponsor, String> nomC;
    @FXML
    private TableColumn<Sponsor, String> prenomC;
    @FXML
    private TableColumn<Sponsor, String> descriptionS;
    String path;
    BufferedImage bufferedImage;
    @FXML
    private Button bImage;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField tfRechercher;
    @FXML
    private ImageView ImageView1;
    @FXML
    private TableView<Sponsor> tvSponsor;
    @FXML
    private Button bModifier1;
    ObservableList<Sponsor> dateListe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addS(ActionEvent event) throws IOException {

        if (tfNomS.getText().isEmpty() || tfPrenomS.getText().isEmpty() || taDes.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succées");
            alert.setHeaderText(null);
            alert.setContentText("La madification a été effectué avec succées");
            alert.showAndWait();
            String nom = tfNomS.getText();
            String prenom = tfPrenomS.getText();
            String description = descriptionS.getText();
            String image = path;
            File outputfile = new File(path);
            ImageIO.write(bufferedImage, "png", outputfile);
            Sponsor RE = new Sponsor();
            RE.setNomS(nom);
            RE.setPrenomS(prenom);
            RE.setDescriptionS(description);
            Sponsor sponsor = new Sponsor(nom , prenom , description ,image);
            SponsorCRUD s = new SponsorCRUD();
            s.AjouterSponsor(sponsor);

        }

    }

    @FXML
    private void showS(ActionEvent event) {
        SponsorCRUD service = new SponsorCRUD();
        ObservableList<Sponsor> liste = service.AfficherSponsor();
        nomC.setCellValueFactory(new PropertyValueFactory<>("nomS"));
        prenomC.setCellValueFactory(new PropertyValueFactory<>("prenomS"));
        descriptionS.setCellValueFactory(new PropertyValueFactory<>("descriptionS"));
        tvSponsor.setItems(liste);
    }

    @FXML
    private void updateS(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateS.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteS(ActionEvent event) {
        SponsorCRUD se = new SponsorCRUD();
        Sponsor r = tvSponsor.getSelectionModel().getSelectedItem();
        r.setIdS(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER CE SPONSOR ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimerSponsor(r);

            JOptionPane.showMessageDialog(null, " SPONSOR SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " SPONSOR NON SUPPRIME ");
        }

        se.AfficherSponsor();

    }

//    private void findS(ActionEvent event) {
//        SponsorCRUD rs = new SponsorCRUD();
//
//        ObservableList<Sponsor> liste = (ObservableList<Sponsor>) rs.rechercheSponsor(tfRechercher.getText());
//
//        idC.setCellValueFactory(new PropertyValueFactory<>("idS"));
//        nomC.setCellValueFactory(new PropertyValueFactory<>("nomS"));
//        prenomC.setCellValueFactory(new PropertyValueFactory<>("prenomS"));
//        descriptionS.setCellValueFactory(new PropertyValueFactory<>("descriptionS"));
//        imageS.setCellValueFactory(new PropertyValueFactory<>("imageS"));
//        tvSponsor.setItems(liste);
//    }

    @FXML
    private void choisirImage(ActionEvent event) {
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
                ImageView1.setImage(image);
                String name = file.getName();
                //changer path
                path = "C:\\xampp\\htdocs\\img" + name;
//                File outputfile = new File(path);
//                //save
//                ImageIO.write(bufferedImage,"png" , outputfile);

            } catch (IOException ex) {
                Logger.getLogger(SponsorMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void refresh(ActionEvent event) {
        SponsorCRUD service = new SponsorCRUD();
        ObservableList<Sponsor> liste = service.AfficherSponsor();
        nomC.setCellValueFactory(new PropertyValueFactory<>("nomS"));
        prenomC.setCellValueFactory(new PropertyValueFactory<>("prenomS"));
        descriptionS.setCellValueFactory(new PropertyValueFactory<>("descriptionS"));
        tvSponsor.setItems(liste);
    }

    @FXML
    private void findSponsor(ActionEvent event) {
//        SponsorCRUD rs = new SponsorCRUD();
//
//        ObservableList<Sponsor> liste = (ObservableList<Sponsor>) rs.rechercheSponsor(tfRechercher.getText());
//
////        idC.setCellValueFactory(new PropertyValueFactory<>("idS"));
//        nomC.setCellValueFactory(new PropertyValueFactory<>("nomS"));
//        prenomC.setCellValueFactory(new PropertyValueFactory<>("prenomS"));
//        descriptionS.setCellValueFactory(new PropertyValueFactory<>("descriptionS"));
////        imageS.setCellValueFactory(new PropertyValueFactory<>("imageS"));
//        tvSponsor.setItems(liste);
//    }

SponsorCRUD rs = new SponsorCRUD();
        Sponsor e = new Sponsor();

//      idC.setCellValueFactory(new PropertyValueFactory<>("idS"));
        nomC.setCellValueFactory(new PropertyValueFactory<>("nomS"));
        prenomC.setCellValueFactory(new PropertyValueFactory<>("prenomS"));
        descriptionS.setCellValueFactory(new PropertyValueFactory<>("descriptionS"));
//        imageS.setCellValueFactory(new PropertyValueFactory<>("imageS"));
        tvSponsor.setItems(dateListe);

        dateListe = rs.AfficherSponsor();
      tvSponsor.setItems(dateListe);

        FilteredList<Sponsor> filteredData;
        filteredData = new FilteredList<>(dateListe, b -> true);
        tfRechercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Sponsor -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Sponsor.getNomS().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                
                } else if  (Sponsor.getPrenomS().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true ;
                   

                } 
                 else if  (Sponsor.getDescriptionS().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true ;
                   

                } 
                  else {
                    return false;
                }

            });

        }));
        SortedList<Sponsor> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvSponsor.comparatorProperty());
        tvSponsor.setItems(sortedData);
    }
}
