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
	
	private static volatile Assignment1_Singleton instance;	//Instance variable to create singleton
	
	public static  Assignment1_Singleton getInstance() {
		//First check
		if(instance == null) {
			//To reduce the cost of synchronization, only synchronize the critical section of the code
			synchronized(Assignment1_Singleton.class) {	
				//Second check
				if(instance == null) {
					instance = new Assignment1_Singleton();
				}
			}
		}
		return instance;
	}
	
	private Assignment1_Singleton() {}

}
