import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbCon {
     public void getConnection() {
    	 try {
    		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
				Statement stmt = conn.createStatement();
				
    	 }catch(Exception E) {
    		 E.printStackTrace();
    	 }
         
     }

}
