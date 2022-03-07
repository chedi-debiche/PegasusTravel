package gui1;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontFactory;
import Entités.Reclamation;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import static java.time.LocalDate.from;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import Services.ReclamationCRUD;

import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class InAjouterRecController implements Initializable {

    @FXML
    private TextField tfEmail;
    @FXML
    private TextArea tfCommentaire;

    @FXML
    private DatePicker tfDateReclamation;
    @FXML
    private ChoiceBox<String> tfTypeReclamation;
    private String[] TypReclamation = {"Voyage", "Hotel", "Evenement"};
    @FXML
    private Button tfAjouter;
    @FXML
    private Label tfType;
    @FXML
    private Button tbAfiicher;
    @FXML
    private TableView<Reclamation> tvAfficher;

    @FXML
    private TableColumn<Reclamation, String> tfNom1;
    @FXML
    private TableColumn<Reclamation, String> tfPrenom1;
    @FXML
    private TableColumn<Reclamation, String> tfEmail1;
    @FXML
    private TableColumn<Reclamation, String> tfCommentaire1;
    @FXML
    private TableColumn<Reclamation, Date> tfDateReclamation1;
    @FXML
    private TableColumn<Reclamation, String> tfTypeReclamation1;

    @FXML
    private TableColumn<Reclamation, Integer> tfClient;
    @FXML
    private Button Mupdate;
    @FXML
    private TextField TFrecherche;
    @FXML
    private Button Mrecherche;
    @FXML
    private Button Mdelete;
    @FXML
    private TextField tdid1;
    @FXML
    private TextField TxNom;
    @FXML
    private TextField txpre;
    @FXML
    private ScrollPane scronll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
    private Reclamation reclamation;
    private AnchorPane anchorpane;

    private ObservableList<Reclamation> getData() {
        ReclamationCRUD cp = new ReclamationCRUD();
        ObservableList<Reclamation> myProds = cp.afficherReclamation();
        return myProds;
    }

//    private int setChosenProd(Reclamation produit) {
//        try {
//            idquantite.setText(String.valueOf(produit.getQuantite()));
//            idnamelabel.setText(produit.getNom());
//            idpricelabel.setText(String.valueOf(produit.getPrix()));
//            Image image = new Image(new FileInputStream(produit.getImage()));
//            imgV.setImage(image);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MarcherProduitController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return produit.getQuantite();
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfTypeReclamation.getItems().addAll(TypReclamation);
        tfTypeReclamation.getOnAction();

        ObservableList<Reclamation> Produits = getData();
        if (Produits.size() > 0) {
            //setChosenProd(Produits.get(0));
            myListener = new MyListener() {

                @Override
                public void onClickListener(Reclamation rec) {
                    //setChosenProd(Produit);
                    reclamation = rec;

                }

            };
        }

        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < Produits.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mini.fxml"));
                anchorpane = fxmlLoader.load();
//              
                MiniController miniController = fxmlLoader.getController();
                miniController.setData(Produits.get(i), myListener);
                if (column == 1) {
                    column = 0;
                    row++;
                }
                grid.add(anchorpane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public List<Reclamation> afficherReclamation() throws SQLException {
        Connection cnx = null;
        Statement st = null;
        ResultSet rs = null;
        ObservableList<Reclamation> liste = FXCollections.observableArrayList();
        String requette = "SELECT * FROM Reclamation";

        try {
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();
            rs = st.executeQuery(requette);
            Reclamation testajout;
            while (rs.next()) {
                testajout = new Reclamation(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("Commentaire"), rs.getDate("dateReclamation"), rs.getString("typeReclamation"), rs.getInt("id"));
                liste.add(testajout);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    /* Ignored */
                }
            }
            if (st != null) {
                st.close();
                /* Ignored */
            }
        }
        return liste;

    }

    @FXML
    private void savaReclamation(ActionEvent event) {
        if (tdid1.getText().toString().isEmpty() || tfEmail.getText().isEmpty() || tfCommentaire.getText().isEmpty() || tfTypeReclamation.getValue().toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(" vérifier vos informations ");
            alert.showAndWait();
        } else if (tfDateReclamation.getValue().getYear() > 2022) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("vérifier votre date ");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succées");
            alert.setHeaderText(null);
            alert.setContentText("L'ajout d'un new reclamation a été effectué avec succées");
            alert.showAndWait();
            String nom = TxNom.getText();
            String prenom = txpre.getText();
            String email = tfEmail.getText();
            String commentaire = tfCommentaire.getText();
            Date date = java.sql.Date.valueOf(tfDateReclamation.getValue());
            String typeReclamation = tfTypeReclamation.getValue();
            ReclamationCRUD reclamation = new ReclamationCRUD();
            Integer id = Integer.parseInt(tdid1.getText());
            Reclamation R = new Reclamation(nom, prenom, email, commentaire, date, typeReclamation, id);
            reclamation.AjoutReclamation2(R);

        }
    }

    @FXML
    private void getType(MouseEvent event) {
//      String  myType= (String)tfTypeReclamation.getValue();
//      tfType.setText(myType);
    }

    @FXML
    private int showAfficher(ActionEvent event) throws IOException {
        grid.getChildren().clear();
        ReclamationCRUD service = new ReclamationCRUD();
        Reclamation r = new Reclamation();
       // ObservableList<Reclamation> liste = service.afficherReclamation();
        ObservableList<Reclamation> TriList = service.trier();
        

        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < TriList.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mini.fxml"));
                anchorpane = fxmlLoader.load();
//              
                MiniController miniController = fxmlLoader.getController();
                miniController.setData(TriList.get(i), myListener);
                if (column == 1) {
                    column = 0;
                    row++;
                }
                grid.add(anchorpane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
// int priorite = 3;
// Connection cnx = null;
//        String message = "";
//        List<String> haute = Arrays.asList("systeme", "critique", "erreur", "spam", "arnaque", "erreurs", "bug", "crash", "commande", "commandes", "annuler", "paiement");
//        List<String> moyenne = Arrays.asList("Hotel", "Voyage", "Evenement ");
//        haute.replaceAll(String::toUpperCase);
//        moyenne.replaceAll(String::toUpperCase);
//        try {
//            String query = "select * from reclamations where numero=" + r.getNumero();
//
//            Statement st = cnx.createStatement();
//            ResultSet res = st.executeQuery(query);
//
//            while (res.next()) {
//                Reclamation e = new Reclamation();
//                e.setCommentaire(res.getString("commentaire"));
//               
//                message = e.getCommentaire();
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        if (haute.contains(message.toUpperCase())) {
//            priorite = 1;//high
//        } else if (moyenne.contains(message.toUpperCase())) {
//            priorite = 2;//medium
//        } else {
//            priorite = 3;//low
//        }
//        return priorite;
        return 0;
    }

//
//tfNom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
//tfPrenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//tfEmail1.setCellValueFactory(new PropertyValueFactory<>("email"));
//tfCommentaire1.setCellValueFactory(new PropertyValueFactory<>("Commentaire"));
//tfDateReclamation1.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
//tfTypeReclamation1.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
//tfClient.setCellValueFactory(new PropertyValueFactory<>("id"));
//tvAfficher.setItems(liste);
    

//    @FXML
//    private void modifierReclamattion(ActionEvent event) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateInterface.fxml"));
//            Parent root = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
     @FXML
    private void modifierReclamattion(ActionEvent event) {
         ReclamationCRUD  sa = new ReclamationCRUD ();

        String nom = TxNom.getText();
        String prenom = txpre.getText();
        String email=tfEmail.getText();
        String Com=tfCommentaire.getText();
         Date date = java.sql.Date.valueOf(tfDateReclamation.getValue());
         String type=tfTypeReclamation.getValue();
         
        Reclamation re = (Reclamation) tvAfficher.getSelectionModel().getSelectedItem();
        reclamation.setDateReclamation(date);
        reclamation.setNom(nom);
        reclamation.setPrenom(prenom);
         reclamation.setEmail(email);
          reclamation.setCommentaire(Com);
           reclamation.setDateReclamation(date);
            reclamation.setTypeReclamation(type);
        sa.modifier(reclamation);
        sa.afficherReclamation();


    }

    @FXML
    private void rechercherReclamation(ActionEvent event) {
        grid.getChildren().clear();
        ReclamationCRUD rs = new ReclamationCRUD();

        List<Reclamation> liste = rs.rechercheParNom(TFrecherche.getText());

//        tfNom1.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nom"));
//        tfPrenom1.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("prenom"));
//        tfEmail1.setCellValueFactory(new PropertyValueFactory<>("email"));
//        tfCommentaire1.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
//        tfDateReclamation1.setCellValueFactory(new PropertyValueFactory<>("DateReclamation"));
//        tfTypeReclamation1.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
//        tfClient.setCellValueFactory(new PropertyValueFactory<>("id"));
//        tvAfficher.setItems((ObservableList<Reclamation>) liste);

//    
        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < liste.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mini.fxml"));
                anchorpane = fxmlLoader.load();
//              
                MiniController miniController = fxmlLoader.getController();
                miniController.setData(liste.get(i), myListener);
                if (column == 1) {
                    column = 0;
                    row++;
                }
                grid.add(anchorpane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }

    @FXML
    private void supprimerReclamation(ActionEvent event) throws SQLException {
        ReclamationCRUD se = new ReclamationCRUD();
        //  Reclamation r = tvAfficher.getSelectionModel().getSelectedItem();
        reclamation.setNumero(1);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER UNE RECLAMATION ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(reclamation);

            JOptionPane.showMessageDialog(null, " RECLAMATION SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " RECLAMATION NON SUPPRIME ");
        }

//        l_nom.setText("");
//        l_nbr.setText("");
//        l_quan.setText("");
        se.afficherReclamation();
    }

    @FXML
    private void selectReclamation(MouseEvent event) {
        Reclamation M = tvAfficher.getSelectionModel().getSelectedItem();

        tfNom1.setText(M.getNom());
        tfPrenom1.setText(M.getPrenom());
        tfEmail1.setText(M.getEmail());
        tfCommentaire1.setText(String.valueOf(M.getCommentaire()));
        tfTypeReclamation1.setText(String.valueOf(M.getTypeReclamation()));

    }

//    private void reponsEmplo(ActionEvent event) {
////        try {
////    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InEmplo.fxml"));
////            Parent root = (Parent) fxmlLoader.load();
////            Stage stage = new Stage();
////            stage.setScene(new Scene(root));  
////            stage.show();
////    } catch(Exception e) {
////       e.printStackTrace();
////      }
//        ReclamationCRUD sa = new ReclamationCRUD();
//        // Reclamation M = tvAfficher.getSelectionModel().getSelectedItem();
//
////        tfNom1.setText(reclamation.getNom());
////        tfPrenom1.setText(reclamation.getPrenom());
////        tfEmail1.setText(reclamation.getEmail());
////        tfCommentaire1.setText(reclamation.getCommentaire());
////        tfTypeReclamation1.setText(reclamation.getTypeReclamation());
////        tfDateReclamation1.setText(String.valueOf(reclamation.getDateReclamation()));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("InEmplo.fxml"));
//        try {
//            Stage primaryStage = new Stage();
//
//            Parent root = loader.load();
//            InEmploController mc = loader.getController();
//            mc.setNomProd(reclamation.getNom());
//            mc.setPrenomProd(reclamation.getPrenom());
//            Scene scene = new Scene(root);
//
//            primaryStage.setTitle("Reponse Sur Reclamation");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }

//    private void stat(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PieChartVoyage.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//
//        Stage stage = new Stage();
//
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }
//    private void Statistique(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PiedStat.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//
//        Stage stage = new Stage();
//
//        stage.setScene(new Scene(root1));
//        stage.setTitle("gestion des reservations maisons d'hotes");
//        stage.show();
//        
//    }
//    private void SendMl(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MailSend.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//
//        Stage stage = new Stage();
//
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }
    @FXML
    private void Mail(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MailSend.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void RechAv(ActionEvent event) {
    }

}
