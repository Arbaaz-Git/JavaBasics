/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Arbaaz Khan
 *
 */
public class ConnectionUtil {

	/**
	 * @param args
	 */
	
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/library";
	public static final String username = "root";
	public static final String password = "root";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		conn.setAutoCommit(Boolean.FALSE);
		return conn;
	}
}
