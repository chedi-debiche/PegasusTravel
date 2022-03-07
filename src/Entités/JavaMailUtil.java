/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 21695
 */
public class JavaMailUtil {

    public static void message() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void message(String mail,String contenu){
    String to = mail;

      // Sender's email ID needs to be mentioned
      String from = "pegasustravels10@gmail.com";
      final String username = "pegasustravels10@gmail.com";//change accordingly
      final String password = "pegasustravels";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "relay.jangosmtp.net";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                 props.put("mail.smtp.ssl.protocols","TLSv1.2");
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
  }
         });
      
      

      try {
  // Create a default MimeMessage object.
  Message message = new MimeMessage(session);

  // Set From: header field of the header.
  message.setFrom(new InternetAddress(from));

  // Set To: header field of the header.
  message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));

  // Set Subject: header field
  message.setSubject("Retour sur réclamation");

  // Now set the actual message
  message.setText(contenu);

  // Send message
  Transport.send(message, message.getAllRecipients());

  System.out.println("Email envoyé avec succées....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
       
       
    }
     private Message loginnotifaction(Session session, String myAccountEmail, String recepient) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Notification de connexion");
            String htmlCode = "<p>Bonjour, votre compte vient d'être connecté. Était-ce vous?.</p>";
            message.setContent(htmlCode, "text/html");
            return message;
        }catch (Exception ex) {
           
        }
        return null;
    }

    private Message passchangenotification(Session session, String myAccountEmail, String recepient) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Notification de changement de pass");
            String htmlCode = "<p>Bonjour, votre mot de passe vient d'être changé. si ce n'est pas vous, veuillez vous connecter à votre compte et le sécuriser.</p>";
            message.setContent(htmlCode, "text/html");
            return message;
        }catch (Exception ex) {
           
        }
        return null;
    }
}
