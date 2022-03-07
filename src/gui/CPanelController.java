
package login2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zoghlami
 */
public class CPanelController implements Initializable {

     @FXML
    private Button btn_logout;
   
     
     public void logout(ActionEvent event) throws Exception{
         btn_logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Successfully log out");
        alert.showAndWait();
         
     }
    
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
