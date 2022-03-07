/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author CC
 */
public class WebViewController implements Initializable {

     @FXML
    WebView webView;
    private WebEngine webEngine;
    @FXML
    private Button action;
    @FXML
    private void google(ActionEvent event) {
       webEngine.load("http://google.com");
      //  webView.getEngine().load("https://www.youtube.com/embed/v=1cGmWPI5TaI");
    }
    
     @FXML
    private void Youtube(ActionEvent event) {
       webEngine.load("https://www.youtube.com/");
      //  webView.getEngine().load("https://www.youtube.com/embed/v=1cGmWPI5TaI");
    }
    
    @FXML
    private void Linkedin(ActionEvent event) {
       webEngine.load("http://linkedin.com");
      //  webView.getEngine().load("https://www.youtube.com/embed/v=1cGmWPI5TaI");
    }
    
    @FXML
    public void Reload(ActionEvent event) {
				webEngine.reload();
			}

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        webEngine = webView.getEngine();
        webEngine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               // txtURL.setText(newValue);
            }
        });
        // remove right clicks
        webView.setContextMenuEnabled(false);
       // txtURL.setText("http://www.google.com");
        webEngine.load("https://dijitol.co.uk");
    }
}