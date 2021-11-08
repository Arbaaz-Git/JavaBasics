/**
 * 
 */
package Menu;

import java.sql.SQLException;
import java.util.Scanner;
import Domain.BookLoans;
import Service.InputHandler;

/**
 * @author Arbaaz Khan
 *	This class is the main class of the project. It is here that program starts from.
 */
public class Main extends InputHandler{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu(){
		int input=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the SS Library Management System. Which category of a user are you: ");
		System.out.println("1) Librarian");
		System.out.println("2) Administrator");
		System.out.println("3) Borrower");
		System.out.println("4) Exit");
		input = parseIntegerInput();
		
			switch(input){
				case 1:
					LibrarianMenu.lib1();
					break;
				case 2:
					AdministratorMenu.adminMenu();
					break;
				case 3:
					BorrowerMenu.login();
					break;
				case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
				default:
					break;
			};
	}
}
