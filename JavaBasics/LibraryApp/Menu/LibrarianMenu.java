/**
 * 
 */
package Menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Domain.Author;
import Domain.Book;
import Domain.BookAuthors;
import Domain.BookCopies;
import Domain.LibraryBranch;
import Service.InputHandler;
import Service.LibrarianService;

/**
 * @author Arbaaz Khan
 *
 */
public class LibrarianMenu extends InputHandler {
	private static LibrarianService service = new LibrarianService();
	public static void lib1() {
		System.out.println("----------------------------------------");
		System.out.println("Librarian Menu:");
		System.out.println();
		System.out.println("1) Enter Branch you manage ");
		System.out.println("2) Quite to pervious ");
		int input=parseIntegerInput();
		switch(input) {
		case 1:
			lib2();
			break;
		case 2:
			Main.mainMenu();
			System.out.println("Returning to Main menu");
			break;
		default:
			break;
		};
	}
	
	protected static void lib2() {
		List<LibraryBranch> branches = new ArrayList<>();
		HashMap<Integer, LibraryBranch> map = new HashMap<Integer, LibraryBranch>();
		try {
			branches = service.readAllLibrarys();
		} catch (SQLException e) {
			System.out.println("lib2: Error loading SQL from table tbl_library_branch");
		}
		System.out.println("----------------------------------------");
		System.out.println("Library Branches: ");
		int count = 1;
		for(LibraryBranch lb : branches) {
			map.put(count, lb);
			System.out.printf("%d) %s\n",count,lb.getBranchName());
			count++;
		}
		System.out.printf("%d) Quit to previous\n",count);
		System.out.println("Please enter the corresponding number to your branch");
		int in = parseIntegerInput();
		if(in==count) {
			lib1();
		}
		LibraryBranch lib = map.get(in);
		lib3(lib);
	}
	
	protected static void lib3(LibraryBranch lb) {
		System.out.println("----------------------------------------");
		System.out.println("1) Update the details of the Library ");
		System.out.println("2) Add copies of Book to the Branch");
		System.out.println("3) Quit to previous ");
		int input = parseIntegerInput();
		switch(input){
			case 1:
				updateBranch(lb);
				break;
			case 2:
				updateBookCopies(lb);
				break;
			case 3:
				lib2();
				break;
			default:
				break;
		};
	}
	
	private static void updateBookCopies(LibraryBranch lb) {
		Book myBook = new Book();
		BookCopies bookcopies = new BookCopies();
		bookcopies.setNoOfCopies(0);//init number of copies to 0 
		List<String> bap = new ArrayList<>();
		List<Book> book = new ArrayList<>();
		List<BookCopies> bc = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<Integer, Book> mapBook = new HashMap<>();
		try {
			bap = service.readAllBooksNAuthors();
			book = service.readAllBooks();
		} catch (SQLException e) {
			System.out.printf("updateBookCopies: failed to load all books from branch: %d\n",lb.getBranchName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Pick the Book you want to add copies of, to your branch:");
		//Loop to print book title and author
		int count=1;
		for(String s : bap) {
			map.put(count, s);
			System.out.printf("%d) %s\n",count,s);
			count++;
		}
		System.out.printf("%d) Quit to cancel opperation\n", count);
		int input = parseIntegerInput();	//holds which book to increase number of copies of
		
		//String manipulation to find corresponding book object to the book chosen
		String s = map.get(input);
		String[] parts = s.split(" by");
		for(Book b : book) {
			if(b.getTitle().equals(parts[0])) {
				myBook=b;
			}
		}
		//exit back to previous window
		if(input==count) {
			lib3(lb);
		}
		
		try {
			bc = service.copyOfBookInBranch(lb,myBook);
		}catch(SQLException e) {
			System.out.printf("updateBookCopies: failed to load nCopies from branch: %d\n",lb.getBranchName());
			
		}
		System.out.printf("Branch: %s\n",lb.getBranchName());
		//init the rest of bookcopies just in case the query returns a null
		bookcopies.setBookId(myBook.getBookId());
		bookcopies.setBranchId(lb.getBranchId());
		if(bc.size()>0) {	//if query does not return null then set bookCopies to return value
			bookcopies = bc.get(0);
		}
		System.out.printf("Existing number of copies: %d\n",bookcopies.getNoOfCopies());
		System.out.println("Enter new number of copies: ");
//		input = parseIntegerInput();	//Holds the number of copies to be added to the library branch

		bookcopies.setNoOfCopies(parseIntegerInput());
		try {
			service.updateBookCopies(bookcopies);
		} catch (SQLException e) {
			System.out.println("updateBookCopies: Failed to update bookCopies");
		}
		lib3(lb);
	}
	
	private static void updateBranch(LibraryBranch lb) {
		System.out.printf("You have chosen to update the Branch with Branch Id: %d and Branch Name: %s.\n",lb.getBranchId(),lb.getBranchName());
		System.out.println("Enter ‘quit’ at any prompt to cancel operation.");
		System.out.println("Please enter new branch name or enter N/A for no change:");
		String newName = parseStringInput();
		if(newName.toLowerCase().equals("quit")) {
			lib3(lb);
		}
		System.out.println("Please enter new branch address or enter N/A for no change:");
		String newAdd = parseStringInput();
		if(newAdd.toLowerCase().equals("quit")) {
			lib3(lb);
		}
		if(!newName.toLowerCase().equals("n/a")) {
			lb.setBranchName(newName);
		}
		if(!newAdd.toLowerCase().equals("n/a")) {
			lb.setBranchAddress(newAdd);
		}
		try {
			service.updateLibraryBranch(lb);
		} catch (SQLException e) {
			System.out.printf("lib3: Error updating info from branchId: %d",lb.getBranchId());
		}
		lib3(lb);
	}

}
