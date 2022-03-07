/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui1;


import Entités.JavaMailUtil;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author 21695
 */
public class MailSendController implements Initializable {

    @FXML
    private TextField textTo;
    @FXML
    private TextArea TextC;
    @FXML
    private TextField textEmail;
    @FXML
    private Button bFermer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
        
        String to = textTo.getText();
        String titre = textEmail.getText();
        String msg = TextC.getText();
          Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(titre);

      if (!mat.matches()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email format wrong", ButtonType.CLOSE);
                alert.show();
            }

       JavaMailUtil ml = new JavaMailUtil();
        ml.message(titre, msg);
        Notifications notificationBuilder = Notifications.create()
                .title("Nouveau  Reclamation !")
                .text("une Reclamation a été ajoutée ")
                .hideAfter(javafx.util.Duration.seconds(10))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Notification !");
                 }
        });
        notificationBuilder.darkStyle();
        notificationBuilder.show();

    }

    @FXML
    private void Fermer(ActionEvent event)  {
        Stage stage =(Stage)bFermer.getScene().getWindow();
        stage.close();
        
    }
    
}
