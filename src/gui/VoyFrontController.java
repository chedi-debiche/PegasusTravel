/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import services.ServiceVoyage;
//import Entités.Voyage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class VoyFrontController implements Initializable {
    private List<Voyage> Voyage = new ArrayList();
    private ServiceVoyage sp = new ServiceVoyage();
    @FXML
    private ScrollPane scrollId;
    @FXML
    private GridPane gridId;
    @FXML
    private Button ReservationVoyage;
    @FXML
    private Pane paneMain;
   
    private List<Voyage> read() {
        ArrayList<Voyage> datas = new ArrayList();   
    try {
     
       datas.addAll(sp.read()) ;
  } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("err aff");
    }
    return datas;
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
       
    /*  public ObservableList<Voyage> getVoyageList(){
        ObservableList<Voyage> voyageList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM voyage";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Voyage voyage;
            while(rs.next()){
               // voyage = new Voyage(rs.getInt("id"), rs.getString("nom"), rs.getString("destination"), rs.getString("description"),rs.getInt("prix"));
                voyage = new Voyage(rs.getInt("id"), rs.getString("nom"), rs.getString("destination"), rs.getString("description"),rs.getInt("prix"),rs.getString("image"));
                voyageList.add(voyage);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return voyageList;
    }*/
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              ToggleSwitch button = new ToggleSwitch();
         SimpleBooleanProperty isOn = button.switchOnProperty();
         isOn.addListener((observable, oldvalue, newValue) -> {
         if(newValue){
             button.getScene().getRoot().getStylesheets().add(getClass().getResource("styles.css").toString());
             System.out.println("adding");
         }else{
             button.getScene().getRoot().getStylesheets().remove(getClass().getResource("styles.css").toString());
             System.out.println("removing");
         }
         });
                 paneMain.getChildren().add(button);
           // ServiceProduit sp = new ServiceProduit();
                 Voyage.addAll(read());
              //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        int ligne =0;
        int colone = 1;
              
              for(int i=0;i<Voyage.size();i++){
                  
           
                  try {
                       
            if(colone == 3){
                
                ligne++;
                colone=0;
            }
            
            FXMLLoader fxmlLoader= new FXMLLoader();
           
            fxmlLoader.setLocation(getClass().getResource("FrontV.fxml"));//recuperer le fichier fxml
             AnchorPane    col = fxmlLoader.load();//recuperer le block du produit
        
            FrontVController frontvController = fxmlLoader.getController();//recuperer le controller du ficher fxml
          frontvController.setData(Voyage.get(i));//faire le block pour chaque produit de la liste
            //prodController.setProduit(produits.get(i));//prodController.clickProd(event);
                     
                      gridId.add(col, colone++, ligne);//ajouter le block dans le grid
                      GridPane.setMargin(col, new Insets(10));
                  } catch (IOException ex) {
                System.out.println(ex.getMessage());
    // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
       
             

    }   

   
        @FXML
    private void ReservationVoyage(ActionEvent event) throws IOException{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservationFront.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();

    }
    
       @FXML
    private void tictac(ActionEvent event) throws IOException{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TicTacToe.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();

    }
}



 