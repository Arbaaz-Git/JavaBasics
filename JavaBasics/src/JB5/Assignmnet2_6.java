/**
 * 
 */
package JB5;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Arbaaz Khan
 *	I am just fixing the Single that was given. 
 */

//This is the code I am fixing 
class SampleSingleton {

	private SampleSingleton() {
		Connection conn = null;
	}

	
	private static volatile SampleSingleton instance = null;
	
	public static SampleSingleton getInstance() {
		if(instance==null) {
			synchronized(SampleSingleton.class) {
				if(instance==null) {
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}
	
}

public class Assignmnet2_6 {
	


}
