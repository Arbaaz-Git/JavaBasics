/**
 * 
 */
package JB4;

/**
 * @author Arbaaz Khan
 *  THis program is creating a Singleton design pattern with double checked locking
 *
 */
public class Assignment1_Singleton {
	
	//The Key to the double locking in the signleton is making sure instance is volatile. This makes instance thread safe
	private static volatile Assignment1_Singleton instance;	//Instance variable to create singleton
	
	public static  Assignment1_Singleton getInstance() {
		if(instance == null) {
			synchronized(Assignment1_Singleton.class) {	//Second part to the double checked locking is insuring you synchronize getInstance()
				instance = new Assignment1_Singleton();
			}
		}
		return instance;
	}
	
	private Assignment1_Singleton() {}

}
