/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entités.Evenement;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author rahma
 */
public class EvenementCRUD implements EvenementInterface , Comparator<Evenement>{

    Connection cnx2;

    public EvenementCRUD() {
        cnx2 = MyConnection.getInstance().getCnx();
    }

    @Override
    public void AjouterEvenement(Evenement E) {
        try {
            String requete2 = "INSERT INTO evenement( nomEvent , prixEvent ,date) VALUES (?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, E.getNomEvent());
             pst.setFloat(2, E.getPrixEvent());
            pst.setDate(3, E.getDate());
            pst.executeUpdate();
            System.out.println("l'événement est ajouter !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Evenement> AfficherEvenement() {
        ObservableList<Evenement> myList1 = FXCollections.observableArrayList();
        try {

            String requete3 = " SELECT * FROM evenement";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setIdEvent(rs.getInt("idEvent"));
                e.setNomEvent(rs.getString("nomEvent"));
                e.setPrixEvent(rs.getFloat("prixEvent"));
                e.setDate(rs.getDate("date"));
                myList1.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return myList1;
    }

    @Override
//public void supprimer(Evenement E) {
//        try {
//            String req = "DELETE FROM evenement where idEvent=" + E.getIdEvent();
//            Statement st = cnx2.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Personne supprimée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//   }

    public void supprimer(Evenement E) {

        try {
            String requete3 = "DELETE FROM evenement where nomEvent=? ";
            PreparedStatement pst = cnx2.prepareStatement(requete3);
            pst.setString(1, E.getNomEvent());
            int ok = pst.executeUpdate();

            if (ok == -1) {
                System.out.println("suppression Evenement failed");
            } else {
                System.out.println("suppression Evenementt succes ! ");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
//@Override
//public boolean modifier(Evenement E){
//        Connection cnx =null;
//        Statement st = null;
//        
//        
//        String requette = "UPDATE evenement SET nom='"+ E.getNomEvent()+"',date='"+E.getDate()+" WHERE id="+E.getDate()+"";
//        try {
//     
//  st = cnx.createStatement();
//   st.executeUpdate(requette);
//            return true;
//            
//           
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }finally {
//    
//    if (st != null) {
//        try {
//            st.close();
//        } catch (SQLException e) { /* Ignored */}
//    }
//    }

    @Override
    public void modifier(Evenement E) {
        try {
            String requete4 = "update evenement set nomEvent=? ,prixEvent=? ,date=? where idEvent=? ";

            PreparedStatement pst = cnx2.prepareStatement(requete4);
            pst.setString(1, E.getNomEvent());
              pst.setFloat(2, E.getPrixEvent());
            pst.setDate(3, E.getDate());
            pst.setInt(4, E.getIdEvent());

            int ok = pst.executeUpdate();

            if (ok == -1) {
                System.out.println("Insertion événement failed");
            } else {
                System.out.println("Insertion événement succes ! ");
            }
            System.out.println("Evenement modifiée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList <Evenement>  rechercheEvenement(String nom) {
         ObservableList<Evenement> list = FXCollections.observableArrayList();
        try {
            String requete3 = "SELECT  * FROM evenement WHERE nomEvent=?";
            PreparedStatement pst = cnx2.prepareStatement(requete3);
            pst.setString(1, nom );
            ResultSet rs = pst.executeQuery();
            Evenement p = new Evenement();
            rs.first();
             p.setIdEvent(rs.getInt(1));
            p.setNomEvent(rs.getString("nomEvent"));
             p.setPrixEvent(rs.getFloat("prixEvent"));
            p.setDate(rs.getDate("date"));
           list.add(p);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;


    }

    @Override
    public int compare(Evenement o1, Evenement o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     class MyComparatorEvenement implements Comparator<Evenement>{


    @Override
    public int compare(Evenement o1, Evenement o2) {
         return o1.getDate().compareTo(o2.getDate());
          
        
     
    }
     }
    public ObservableList <Evenement> triParDate() throws SQLException{
   ObservableList<Evenement> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM Evenement ";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Evenement(rs.getString("nomEvent"), rs.getFloat("prixEvent"),rs.getDate("date")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        //TRI
        Collections.sort(list, new MyComparatorEvenement());

       return list ;
    }

//  public String QR (String A){
//        
//       
//              
//             try {
//            String qrCodeData = "Event "+A+"";
//            String filePath = "C:\\Users\\rahma\\Desktop\\java\\Pijava\\QR\\"+A+".png";
//            
//            String charset = "UTF-8"; // or "ISO-8859-1"
//            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
//            
//            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//            BitMatrix matrix = new MultiFormatWriter().encode(
//                new String(qrCodeData.getBytes(charset), charset),
//                BarcodeFormat.QR_CODE, 200, 200, hintMap);
//            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
//                .lastIndexOf('.') + 1), new File(filePath));
//            System.out.println("QR Code image created successfully!");
//            return filePath;
//        } catch (Exception e) {
//            System.err.println(e);
//           return "";
//        }
//               
//       }

}
          

   

