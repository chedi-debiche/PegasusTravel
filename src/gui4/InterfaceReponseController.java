/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui4;

import Entités.JavaMailUtil;
import Entités.ReponseReclamation;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import Services.ReclamationCRUD;
import Services.ReponseCRUD;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class InterfaceReponseController implements Initializable {

    @FXML
    private TableView<ReponseReclamation> tvRep;
    @FXML
    private TableColumn<ReponseReclamation, Integer> repc;
    @FXML
    private TableColumn<ReponseReclamation,Integer> repnumero;
    @FXML
    private TableColumn<ReponseReclamation,String> repC;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;
    @FXML
    private TextArea textReponse;
    @FXML
    private Button Affog;
    @FXML
    private Button ajouter;
    @FXML
    private Button mod;
    @FXML
    private Button supp;
    @FXML
    private Button bs;
    @FXML
    private TextField textEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Afficher(ActionEvent event) {
        ReponseCRUD service = new ReponseCRUD();
          
       ObservableList<ReponseReclamation> liste =service.afficherReponse();
 
repc.setCellValueFactory(new PropertyValueFactory<>("IdRep"));
repnumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
repC.setCellValueFactory(new PropertyValueFactory<>("Reponse"));

tvRep.setItems(liste);
    }

    @FXML
    private void ajouterr(ActionEvent event) {
         String Rep = textReponse.getText();
        String nom= textNom.getText();
        String prenom= textPrenom.getText();
       ReclamationCRUD R1= new ReclamationCRUD();
        int numero=R1.rechercheParRE(nom, prenom);
        JavaMailUtil ml = new JavaMailUtil();
         
                
        ReponseReclamation R= new ReponseReclamation(numero,Rep);

        ReponseCRUD reclamation = new ReponseCRUD();
        reclamation.AjoutReponse2(R);
    }
      public void setNomProd(String idp) {
        this.textNom.setText(String.valueOf(idp));
    }

 public void setPrenomProd(String idp) {
        this.textPrenom.setText(String.valueOf(idp));
    }
  public void setEmailProd(String idp){
     this.textEmail.setText(String.valueOf(idp));
 }

    @FXML
    private void Modifier(ActionEvent event) {
    ReponseCRUD  sa = new ReponseCRUD ();
String desp = textReponse.getText();
ReponseReclamation r = new ReponseReclamation();
ReponseReclamation re = (ReponseReclamation) tvRep.getSelectionModel().getSelectedItem();
        r.setReponse(desp);
        r.setIdRep(re.getIdRep());
       
        sa.modifier(r);
        sa.afficherReponse();
    }

    @FXML
    private void Supprimer(ActionEvent event) {
         ReponseCRUD se = new ReponseCRUD();
        ReponseReclamation r = tvRep.getSelectionModel().getSelectedItem();
        //r.setIdRep(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        alert.setContentText(" VOULEZ VOUS SUPPRIMER LE Reponse?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            se.supprimer(r);

            JOptionPane.showMessageDialog(null, " Reponse SUPPRIME ");
        } else {
            JOptionPane.showMessageDialog(null, " Reponse NON SUPPRIME ");
        }

        se.afficherReponse();

    }

    @FXML
    private void end(ActionEvent event) {
        //String to = textTo.getText();
        String titre = textEmail.getText();
        String msg = textReponse.getText();
      JavaMailUtil ml = new JavaMailUtil();
        ml.message(titre, msg);

    }
}
