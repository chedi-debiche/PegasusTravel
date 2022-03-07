/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import org.omg.Dynamic.Parameter;

/**
 *
 * @author Zoghlami
 */
public class FXMLDocumentController implements Initializable {
    
      @FXML
    private Button btn_login;

    @FXML
    private Button btn_reset;

    @FXML
    private Button btn_send;

    @FXML
    private Button btn_sign_up;

    @FXML
    private Button btn_verify;

    @FXML
    private CheckBox cb_showp;

    @FXML
    private HBox panel_footerL;

    @FXML
    private HBox panel_footerR;

    @FXML
    private HBox panel_footerR1;

    @FXML
    private HBox panel_footerS;

    @FXML
    private HBox panel_headerL;

    @FXML
    private HBox panel_headerR;

    @FXML
    private HBox panel_headerR1;

    @FXML
    private HBox panel_headerS;

    @FXML
    private AnchorPane panel_login;

    @FXML
    private AnchorPane panel_recovery;

    @FXML
    private AnchorPane panel_recovery1;

    @FXML
    private AnchorPane panel_sign;

    @FXML
    private Hyperlink ref_log;

    @FXML
    private Hyperlink ref_loginfrom1;

    @FXML
    private Hyperlink ref_loginpage;

    @FXML
    private Hyperlink ref_sign;

    @FXML
    private PasswordField txt_confirmrecoverypas;

    @FXML
    private PasswordField txt_cpwd_up;

    @FXML
    private TextField txt_email_up;

    @FXML
    private TextField txt_firstname_up;

    @FXML
    private TextField txt_lastname_up;

    @FXML
    private TextField txt_passhiden;

    @FXML
    private PasswordField txt_pwd;

    @FXML
    private PasswordField txt_pwd_up;

    @FXML
    private TextField txt_rcovemail;

    @FXML
    private PasswordField txt_recoverypass;

    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_verification;

    
    int randomcode;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    PreparedStatement update;
   
 
    public void Loginpanshow(){
        
        panel_login.setVisible(true);
        panel_footerL.setVisible(true);
        panel_sign.setVisible(false);
        
    }
    public void Signuppanshow(){
        panel_sign.setVisible(true);
        panel_login.setVisible(false);
        panel_footerL.setVisible(false);
        
    }
    
    public void forgotpass(){
        panel_login.setVisible(false);
        panel_footerL.setVisible(false);
        panel_recovery.setVisible(true);
       
    }
    public void LoginpanshowREC(){
        
        panel_login.setVisible(true);
        panel_footerL.setVisible(true);
        panel_recovery.setVisible(false);
        
    }
    public void Loginpanshowrecov2(){
        
        
       panel_recovery.setVisible(true);
        panel_recovery1.setVisible(false);
    }
    
    
    @FXML
    
    private void Login(ActionEvent event)throws Exception{
     conn = mysqlconnection.ConnectDB();
     
        try {
            String sql = "SELECT * FROM users WHERE nom = ? and pwd = ? and role = ? ";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, DigestUtils.sha1Hex(txt_pwd.getText()));
            pst.setString(3, "Client");
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and pssword are correct");
                
                btn_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("PegasusFront.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                }
              
                        
                 String sqll = "SELECT * FROM users WHERE nom = ? and pwd = ? and role = ? ";
                 
                        
            pst = conn.prepareStatement(sqll);
            pst.setString(1, txt_username.getText());
            pst.setString(2, DigestUtils.sha1Hex(txt_pwd.getText()));
            pst.setString(3, "admin");
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and pssword are correct");
                
                btn_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("PegasusBack.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                 }
                 
               
                 String sqlll = "SELECT * FROM users WHERE nom = ? and pwd = ? and role = ? ";
            pst = conn.prepareStatement(sqlll);
            pst.setString(1, txt_username.getText());
            pst.setString(2, DigestUtils.sha1Hex(txt_pwd.getText()));
            pst.setString(3, "employee");
            
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and pssword are correct");
               
                
            
                btn_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("PegasusBack.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            
                
            }   
                
            else if(txt_username.getText().isEmpty() && txt_pwd.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "empty fields");
                
            }
             
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }
      
   
    public void add_user(ActionEvent event)throws Exception{
        
        
        try {
           
            
            
             if (txt_firstname_up.getText() == null || txt_firstname_up.getText().trim().isEmpty()
                     || txt_pwd_up.getText() == null||txt_pwd_up.getText().trim().isEmpty()|| txt_lastname_up.getText() == null || txt_lastname_up.getText().isEmpty()|| 
                       txt_email_up.getText() == null ||txt_email_up.getText().isEmpty() || txt_cpwd_up.getText() == null || txt_cpwd_up.getText().isEmpty() 
                     
                     || (txt_cpwd_up.getText() == null ? txt_pwd_up.getText() != null : !txt_cpwd_up.getText().equals(txt_pwd_up.getText()))) {
      Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something or your confirmation password ");
        fail.showAndWait();
        
        
        
}
             
             Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(txt_email_up.getText());

      if (!mat.matches()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email format wrong", ButtonType.CLOSE);
                alert.show();
            }
            
             else{
                 conn = mysqlconnection.ConnectDB();
        String sql ="INSERT INTO  users (nom,prenom,email,pwd,role)"
+ "VALUES(?,?,?,?,?)";
                  pst = conn.prepareStatement(sql);
            pst.setString(1,txt_firstname_up.getText());
            pst.setString(2,txt_lastname_up.getText());
            pst.setString(3,txt_email_up.getText());
            pst.setString(4,DigestUtils.sha1Hex(txt_pwd_up.getText()));
            pst.setString(5, "Client");
            
           
                  pst.executeUpdate();
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Account succesfully created!");
        alert.showAndWait();
       
            }
             
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      
    }
         
        
    }
    
    public void changevisibility(ActionEvent event){
        
       
            
            if(cb_showp.isSelected()){
                txt_passhiden.setText(txt_pwd.getText());
                txt_passhiden.setVisible(true);
                txt_pwd.setVisible(false);
                return;
                
            }
            txt_pwd.setText(txt_passhiden.getText());
            txt_pwd.setVisible(true);
            txt_passhiden.setVisible(false);
  
    }
    
    
    
    
    
    public void resetpass1(ActionEvent event)throws Exception{
        try {
           
            
            
             if (txt_rcovemail.getText() == null || txt_rcovemail.getText().trim().isEmpty()
                     ) {
      Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("empty fieldes");
        fail.showAndWait();
        
}
              Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(txt_rcovemail.getText());

      if (!mat.matches()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email format wrong", ButtonType.CLOSE);
                alert.show();
            }
            
             
                 
            else {
                 Random rand = new Random();
                 randomcode = rand.nextInt(999999);
                 String host = "smtp.gmail.com";
                 String user = "javafxpegasus@gmail.com";
                 String pass ="oreki1234567";
                 String to = txt_rcovemail.getText();
                 String subject = "Reseting code";
                 String message = "your reset code is "+randomcode;
                 boolean sessionDebug = false;
                 java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                 Properties pros = System.getProperties();
                 pros.put("mail.smtp.starttls.enable", "true");
                 pros.put("mail.smtp.ssl.protocols","TLSv1.2");
                 pros.put("mail.smtp.host", "host");
                 pros.put("mail.smtp.port", "587");
                 pros.put("mail.smtp.auth", "true");
                 pros.put("mail.smtp.starttls.required", "true");
                 
                 Session mailSession = Session.getDefaultInstance(pros,null);
                 mailSession.setDebug(sessionDebug);
                 Message msg = new MimeMessage(mailSession);
                 msg.setFrom(new InternetAddress(user));
                 InternetAddress [] address = {new InternetAddress(to)};
                 msg.setRecipients(Message.RecipientType.TO, address);
                 msg.setSubject(subject);
                 msg.setText(message);
                 Transport transport = mailSession.getTransport("smtp");
                 transport.connect(host, user, pass);
                 transport.sendMessage(msg, msg.getAllRecipients());
                 transport.close();
                 
                 
                 
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Verification code has been sent to the email");
        alert.showAndWait();
       
                
            }
        
        
                 
            }
           catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
              e.printStackTrace();
      
    }
    }  
    public void resetpass2(ActionEvent event)throws Exception{
        try {
           
            
            
             if (txt_verification.getText() == null || txt_verification.getText().trim().isEmpty()
                     ) {
      Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("empty fieldes");
        fail.showAndWait();
        
}        
            else if(Integer.valueOf(txt_verification.getText())== randomcode){
                 panel_recovery1.setVisible(true);
                 panel_recovery.setVisible(false);
                 
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Now you can reset your password");
        alert.showAndWait();
       
                
            }
        
        
                 
            }
           catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      
    }
    }  
    public void resetpass3(ActionEvent event)throws Exception{
        try {
           
            
            
             if (txt_recoverypass.getText() == null || txt_recoverypass.getText().trim().isEmpty() 
                     ||txt_confirmrecoverypas.getText() == null || txt_confirmrecoverypas.getText().trim().isEmpty() || (txt_recoverypass.getText() == null ? txt_confirmrecoverypas.getText() != null : !txt_recoverypass.getText().equals(txt_confirmrecoverypas.getText()))
                     ) {
      Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("empty fieldes");
        fail.showAndWait();
        
}        
            else if(txt_recoverypass.getText() == null ? txt_confirmrecoverypas.getText() == null : txt_recoverypass.getText().equals(txt_confirmrecoverypas.getText())){
                 conn = mysqlconnection.ConnectDB();
                  String value1 = DigestUtils.sha1Hex( txt_recoverypass.getText());
                 String sqlrecov = "update users set  pwd = '"+value1+"' where email='"+txt_rcovemail.getText()+"'";
                 pst = conn.prepareStatement(sqlrecov);
             pst.executeUpdate();
                 
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Succes");
        alert.setContentText("Your password have been updated successfully");
        alert.showAndWait();
       
                
            }
        
        
                 
            }
           catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      
    }
    }  
    
    
     
    
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
