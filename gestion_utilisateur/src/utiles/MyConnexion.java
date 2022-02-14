

package utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Zoghlami
 */
public class MyConnexion {
    
    public String url="jdbc:mysql://localhost:3306/pegasustravel";
    public String login="root";
    public String pwd=""; 
    private static Connection cnx ;
    public static MyConnexion instance;
    
    private MyConnexion(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            if (cnx != null) {
                System.out.println("Successfully connected to MySQL database");
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }
        
        
      
}
      public Connection getcnx(){
            return cnx;
        }
      public static MyConnexion getInstance(){
          if(instance == null){
          instance = new MyConnexion();
          }
          return instance;
      }
}
