/**
 * 
 */
package Service;

import java.util.Scanner;

import Menu.LibrarianMenu;

/**
 * @author Arbaaz Khan
 *
 */
public abstract class  InputHandler {
	protected static Scanner scan = new Scanner(System.in);
	public static int parseIntegerInput() {
		while(!scan.hasNextInt()) {
			System.out.println("Please enter the correseponding number: ");
			scan.next();
		}
		return scan.nextInt();
	}
	
	public static String parseStringInput() {
		return scan.next();
	}

}
