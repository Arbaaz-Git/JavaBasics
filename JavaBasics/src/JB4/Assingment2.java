/**
 * 
 */
package JB4;

/**
 * @author Arbaaz Khan
 *	This program will be showing off a piece of code that is deadlocked between 2 thread. 
 */
public class Assingment2 {
	/**
	 * @param args
	 *  I am creating 2 global variables for simplicity's sake to represent locks that 2 threads might want to access.
	 *  The reason for the deadlocking is because 2 threads are requiring an object that the other thread has.
	 */
	private static String str1 = "Object1";
	private static String str2 = "Object2";

	private static class Thread1 extends Thread{
		public void run() {
			synchronized(str1) {
				System.out.println("Got "+str1);
				synchronized(str2) {
					System.out.println("Waiting for "+str2);
				}
			}
		}
	}
	
	private static class Thread2 extends Thread{
		public void run() {
			synchronized(str2) {
				System.out.println("Got "+str2);
				synchronized(str1) {
					System.out.println("Waiting for "+str1);
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}

}
