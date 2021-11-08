/**
 * 
 */
package Menu;

import java.security.Provider.Service;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Domain.Book;
import Domain.BookLoans;
import Domain.LibraryBranch;
import Service.BorrowerService;
import Service.InputHandler;

/**
 * @author Arbaaz Khan
 *
 */
public class BorrowerMenu extends InputHandler {
	private static BorrowerService service = new BorrowerService();
	
	public static void login() {
		System.out.println("----------------------------------------");
		System.out.println("BORROWER LOGIN");
		System.out.println("Enter the your Card Number:");	//Just enter in a number from 1-10
		int cardNo = parseIntegerInput();
		borr1(cardNo);
	}
	
	protected static void borr1(int cardNo) {
		System.out.println("----------------------------------------");
		System.out.println("BORROWER");
		System.out.println("1) Check out a book");
		System.out.println("2) Return a Book");
		System.out.println("3) Quit to Previous ");
		switch(parseIntegerInput()) {
			case 1:
				listLibBranches(cardNo, 1);
				break;
			case 2:
				listLibBranches(cardNo, 2);
				break;
			case 3:
				Main.mainMenu();
				break;
			default:
				Main.mainMenu();
				break;
		}
	}
	
	//Borrower has the same functionality for both checking out a book and returning a book. THe Key difference is updating the field DateIn when you are returning a book
	private static void listLibBranches(int cardNo, int option) {
		List<LibraryBranch> branches = new ArrayList<>();
		HashMap<Integer, LibraryBranch> map = new HashMap<Integer, LibraryBranch>();
		try {
			branches = service.readAllLibrarys();
		} catch (SQLException e) {
			System.out.println("bookCheckOut: Error loading SQL from table tbl_library_branch");
		}
		System.out.println("----------------------------------------");
		System.out.println("Pick the Branch you want to check out from:");
		int count = 1;
		for(LibraryBranch lb : branches) {
			map.put(count, lb);
			System.out.printf("%d) %s library, %s\n",count,lb.getBranchName(),lb.getBranchAddress());
			count++;
		}
		System.out.printf("%d) Quit to previous\n",count);
		System.out.println("Please enter the corresponding number to your branch");
		int in = parseIntegerInput();
		if(in==count) {
			borr1(cardNo);
		}
		LibraryBranch lb = map.get(in);
		updateBookLoans(lb,cardNo,option);
	}
	
	private static void updateBookLoans(LibraryBranch lb,int cardNo, int option) {
		List<String> bap = new ArrayList<>();
		List<Book> book = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();
		Book myBook = new Book();
		BookLoans myLoan = new BookLoans();
		final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		Timestamp today = new Timestamp(date.getTime());
		Timestamp nextWeek = new Timestamp(date.getTime()+(MILLIS_IN_A_DAY*7));
		try {
			bap = service.readAllBooksNAuthors(lb);
			book = service.readAllBooks();
		} catch (SQLException e) {
			System.out.printf("updateBookCopies: failed to load all books from branch: %d\n",lb.getBranchName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Pick the Book you want to check out:");
		int count=1;
		for(String s : bap) {
			map.put(count, s);
			System.out.printf("%d) %s\n",count,s);
			count++;
		}
		System.out.printf("%d) Quit to cancel opperation\n", count);
		int input = parseIntegerInput();	//holds which book to increase number of copies of
		//exit back to previous window
		if(input==count) {
			borr1(cardNo);
		}
		//String manipulation to find corresponding book object to the book chosen
		String s = map.get(input);
		String[] parts = s.split(" by");
		for(Book b : book) {
			if(b.getTitle().equals(parts[0])) {
				myBook=b;
			}
		}
		//Creating the bookloan object to update table
		myLoan.setCardNo(cardNo);
		myLoan.setBookId(myBook.getBookId());
		myLoan.setBranchId(lb.getBranchId());
		myLoan.setDateOut(today);
		myLoan.setDueDate(nextWeek);
		if(option==2) {	//Option
			myLoan.setDateIn(today);
		}
		myLoan.getDateIn();
		try {
			service.updateBookLoans(myLoan);
		} catch (SQLException e) {
			System.out.println("myLoan: Error failed to update book loans");
		}
		borr1(cardNo);
	}
}
