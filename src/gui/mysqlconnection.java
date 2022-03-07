/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zoghlami
 */
public class mysqlconnection {
     Connection conn = null;
    public static Connection ConnectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasustravel","root","");
         
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    
     public static ObservableList<employee> getemployeeList(){
         Connection conn = ConnectDB();
          ObservableList<employee> employeeList = FXCollections.observableArrayList();
          
          try {
              PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE role = 'employee'");
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  employeeList.add(new employee(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("pwd"), 
                          rs.getString("poste"), Integer.parseInt(rs.getString("salaire")), rs.getString("role")));
              }
             
             
           
         } catch (Exception e) {
         }
          
         
          return employeeList;
         
     }
     
     public static ObservableList<Client> getclientList(){
         Connection conn = ConnectDB();
          ObservableList<Client> clientList = FXCollections.observableArrayList();
          
          try {
              PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE role = 'client'");
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  clientList.add(new Client(Integer.parseInt(rs.getString("id")),rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("pwd"),rs.getString("role")));
              }
             
             
           
         } catch (Exception e) {
         }
          
         
          return clientList;
         
     }
}
