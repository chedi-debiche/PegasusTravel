/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import services.ServiceMaison;
import Entités.maisonH;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Database;
/**
 * FXML Controller class
 *
 * @author CC
 */
public class FrontmaisonController implements Initializable {

    @FXML
    private ScrollPane scrollId;
    
    /**
     * Initializes the controller class.
     */
    private List<maisonH> maisonH = new ArrayList();
    private ServiceMaison sm = new ServiceMaison();
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField marque;
 
   
    private List<maisonH> getMaison() {
        ArrayList<maisonH> datas = new ArrayList();
        //try{
       // datas.addAll(sm.getAll());
        //}catch (SQLException ex) {
     //   System.out.println(ex.getMessage());
        // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       // System.out.println("err aff");
   // }
    return datas;
    }
    
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
             maisonH.addAll(getMaison());
              //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        int ligne =0;
        int colone = 1;
              
              for(int i=0;i<maisonH.size();i++){
                  
           
                  try {
                       
            if(colone == 5){
                
                ligne++;
                colone=0;
            }
            
            FXMLLoader fxmlLoader= new FXMLLoader();
           
            fxmlLoader.setLocation(getClass().getResource("MaisonItem.fxml"));//recuperer le fichier fxml
             AnchorPane    col = fxmlLoader.load();//recuperer le block du produit
        
            MaisonController maisonController = fxmlLoader.getController();//recuperer le controller du ficher fxml
      //      maisonController.setData(maisonH.get(i));//faire le block pour chaque produit de la liste
            //prodController.setProduit(produits.get(i));//prodController.clickProd(event);
                     
                      gridPane.add(col, colone++, ligne);//ajouter le block dans le grid
                      GridPane.setMargin(col, new Insets(10));
                  } catch (IOException ex) {
                System.out.println(ex.getMessage());
    // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               
         
            
        }
             
        
        // TODO
    }

}
