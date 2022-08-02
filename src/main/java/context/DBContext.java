package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	// String url = "jdbc:mysql://localhost:3306/dbweb1", "root", "Nhat@tu2denchin";
	private final String typeDB = "jdbc:mysql";
	private final String serverName = "localhost";
	private final String portNumber = "3306";
	private final String dbName = "shoppingdb";
	private final String userId = "root";
	private final String password = "Nhat@tu2denchin";

	public Connection getConnection () throws Exception {
		Connection conn = null;
		String url = typeDB + "://" + serverName + ":" + portNumber + "/" + dbName;
		
		//1. Load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Get connection
		conn = DriverManager.getConnection(url, userId, password);
		//3. return connection
		return conn;
	}
	
	
}
