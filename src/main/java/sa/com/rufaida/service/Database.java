package sa.com.rufaida.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	
    public Connection getConnection() {
    	Connection connection = null;
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@100.43.0.18:1521:HISP", "gchksmc","gchksmc");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@100.43.0.18:1521:hisp", "medisys","medisys");
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@weblogic-pc:1521:HIS", "sysdev","medisys");
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@100.43.0.1:1521:hist", "rms","rms"); //LIVE
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return connection;
    	/*if (connection != null) {
    		System.out.println("You made it, take control your database now!");
    		return connection;
		} else {
			System.out.println("Failed to make connection!");
			return null;
		}*/
    }
}
