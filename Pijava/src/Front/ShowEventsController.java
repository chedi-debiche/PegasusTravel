/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;



import entities.Evenement;
import entities.ReservationEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.EvenementCRUD;
import services.ReservationEvenementCRUD;

/**
 * FXML Controller class
 *
 * @author rahma
 */
public class ShowEventsController implements Initializable, Comparator<Date> {

    private TableColumn<Evenement, String> cNom;
    private TableColumn<Evenement, Date> cDate;
    private TableView<Evenement> tableView;
    @FXML
    private Button promo;
    private TableColumn<Evenement, Float> cPrix;
    @FXML
    private Button bShow1;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private AnchorPane anchorpane;
    private Evenement e;
    private MyListener myListener;
    @FXML
    private Button reserver;
    @FXML
    private Button annuler;

    private ObservableList<Evenement> getData() {
        EvenementCRUD cp = new EvenementCRUD();
        ObservableList<Evenement> myEvent = cp.AfficherEvenement();
        return myEvent;
    }

//    private Evenement setChosenProd(Evenement Evenement) {
//  
//        return Evenement ;
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Evenement> Evenements = getData();
        if (Evenements.size() > 0) {
            // setChosenProd(Evenements.get(0));
            myListener = new MyListener() {

                @Override
                public void onClickListner(Evenement evenement) {
                    e = evenement;
                }
            };
        }

        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < Evenements.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Event.fxml"));
                anchorpane = fxmlLoader.load();
//              
                EventController EvenementController = fxmlLoader.getController();
                EvenementController.setData(Evenements.get(i), myListener);
                if (column == 3) {
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

    private void showEvents(ActionEvent event) {
        EvenementCRUD service = new EvenementCRUD();

        ObservableList<Evenement> liste = service.AfficherEvenement();

        cNom.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
        cPrix.setCellValueFactory(new PropertyValueFactory<>("prixEvent"));
        cDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableView.setItems(liste);
    }

    @FXML
    private void promotion(ActionEvent event) {

//        Evenement r = tableView.getSelectionModel().getSelectedItem();
        EvenementCRUD re = new EvenementCRUD();
        Float prix = e.getPrixEvent();
        Date date = e.getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        if ((day == 1 && month == 0) || (day == 14 && month == 1) || (day == 30 && month == 9)) {
            prix = (float) (prix - (prix * 0.2));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ALERT Promotion");
            alert.setHeaderText(null);
            alert.setContentText(" Le prix est " + prix);
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("ALERT Promotion");
            alert1.setHeaderText(null);
            alert1.setContentText(" no promotion ");
            Optional<ButtonType> result = alert1.showAndWait();
        }

    }

    private void map(ActionEvent event) {
        Stage stage = new Stage();

        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/Front/googleMaps.html").toString());

        // create scene
        // stage.getIcons().add(new Image("/Images/logo.png"));
        stage.setTitle("localisation");
        Scene scene = new Scene(webView, 1000, 700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.show();

    }

    @Override
    public int compare(Date o1, Date o2) {
        return o1.compareTo(o2);
    }

    @FXML
    private void triParDate(ActionEvent event) throws SQLException {
        grid.getChildren().clear();
//     ObservableList<Evenement> list = FXCollections.observableArrayList();
        EvenementCRUD ecrud = new EvenementCRUD();

        ObservableList<Evenement> list = ecrud.triParDate();

        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < list.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Event.fxml"));
                anchorpane = fxmlLoader.load();
//              
                EventController EvenementController = fxmlLoader.getController();
                EvenementController.setData(list.get(i), myListener);
                if (column == 3) {
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
    private void book(ActionEvent event) {
        ReservationEvenementCRUD rcrud = new ReservationEvenementCRUD();
        Date d = java.sql.Date.valueOf(java.time.LocalDate.now());
        ReservationEvenement R = new ReservationEvenement();
        R.setNomRE(e.getNomEvent());
        //  R.setdateRE((Date) Calendar.getInstance().getTime());
        R.setdateRE(d);
        R.setIdEvent(e.getIdEvent());
        rcrud.AjouterRE(R);
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("ALERT Promotion");
        alert1.setHeaderText(null);
        alert1.setContentText("Votre Réservation est ajoutée  ");
        Optional<ButtonType> result = alert1.showAndWait();
        Notifications notificationBuilder = Notifications.create()
                .title("New reservation !")
                .text("une réservation a été ajoutée ")
                .hideAfter(Duration.seconds(10))
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
    private void cancel(ActionEvent event) {
         EvenementCRUD se = new EvenementCRUD();
        e.setIdEvent(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT suppression");
        alert.setHeaderText(null);
        ReservationEvenement R = new ReservationEvenement();
        ReservationEvenementCRUD rcrud = new ReservationEvenementCRUD();
        alert.setContentText(" Voulez-vous annuler la réservation ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            rcrud.supprimer(R);
            JOptionPane.showMessageDialog(null, " réservation annuler  ");
        } 
        se.AfficherEvenement();
    }

        }
    

