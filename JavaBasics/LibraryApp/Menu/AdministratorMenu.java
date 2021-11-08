/**
 * 
 */
package Menu;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Domain.Author;
import Domain.Book;
import Domain.BookLoans;
import Domain.Borrower;
import Domain.Genre;
import Domain.LibraryBranch;
import Domain.Publisher;
import Service.AdminServiceAuthor;
import Service.AdminServiceBook;
import Service.AdminServiceBorrower;
import Service.AdminServiceGenre;
import Service.AdminServiceLibraryBranches;
import Service.AdminServiceOverride;
import Service.AdminServicePublisher;
import Service.InputHandler;

/**
 * @author Arbaaz Khan
 *
 */
public class AdministratorMenu extends InputHandler {
	
	public static void adminMenu() {
		System.out.println("----------------------------------------");
		System.out.println("Administrator Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add/Update/Delete/Read Book");
		System.out.println("2) Add/Update/Delete/Read Author");
		System.out.println("3) Add/Update/Delete/Read Genres");
		System.out.println("4) Add/Update/Delete/Read Publishers");
		System.out.println("5) Add/Update/Delete/Read Library Branches");
		System.out.println("5) Add/Update/Delete/Read Borrowers");
		System.out.println("7) Override Due Date for a Book Loan");
		System.out.println("8) Return to main menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				crudBook();
				break;
			case 2:
				crudAuthor();
				break;
			case 3:
				crudGenres();
				break;
			case 4:
				crudPublisher();
				break;
			case 5:
				crudLibraryBranches();
				break;
			case 6:
				crudBorrowers();
				break;
			case 7:
				crudOverride();
				break;
			case 8:
				Main.mainMenu();
			default:
				Main.mainMenu();
				break;
					
		};
	}
	private static void crudOverride() {
		AdminServiceOverride ov = new AdminServiceOverride();
		AdminServiceBorrower service = new AdminServiceBorrower();
		List<Borrower> bs = new ArrayList<>();
		List<BookLoans> bls = new ArrayList<>();
		HashMap<Integer, Borrower> map = new HashMap<>();
		HashMap<Integer, BookLoans> blMap = new HashMap<>();
		Borrower b = new Borrower();
		BookLoans bl = new BookLoans();
		System.out.println("----------------------------------------");
		System.out.println("Crud Override Menu:");
		System.out.println("To override a due date. Please select the borrower's card number: ");
		try {
			//First show all the borrowers in the database
			bs = service.readAllBorrowers();
			for(Borrower bor : bs) {
				System.out.printf("%d %s\n",bor.getCardNo(), bor.getName());
				map.put(bor.getCardNo(), bor);
			}
			int input = parseIntegerInput();
			b = map.get(input);	// store the desired borrower who's due date we want to change
			
			//Now we want to pull in all the book loans that our borrower currently has and display them
			bls = ov.getBorrowerLoans(b);
			for(BookLoans bookLoan : bls) {
				System.out.printf("BookId: %d, BranchId: %d, current dueDate: %s\n",bookLoan.getBookId(), bookLoan.getBranchId(), bookLoan.getDueDate().toString());
				blMap.put(bookLoan.getBookId(),bookLoan);
			}
			System.out.println("Please select the Book Id whos due date you wish to change: ");
			input =  parseIntegerInput();
			bl = blMap.get(input);
			
			System.out.println("Please enter in the new due date: yyyy-MM-dd");
			String day = parseStringInput();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(day);
			Timestamp dueDate = new Timestamp(date.getTime());
			bl.setDueDate(dueDate);
			ov.override(bl);
		} catch (SQLException | ParseException e) {
			System.out.println("curdPublisher readAllPublishers: Error failed read all publishers");
		}
		adminMenu();
	}
	
	private static void crudBook() {
		AdminServiceBook service = new AdminServiceBook();
		Book book = new Book();
		List<Book> books = new ArrayList<>();
		HashMap<Integer, Book> map = new HashMap<>();
		System.out.println("----------------------------------------");
		System.out.println("Crud Book Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add Book");
		System.out.println("2) Update Book");
		System.out.println("3) Delete Book");
		System.out.println("4) Read all Book");
		System.out.println("5) Return to Admin menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				System.out.println("Please enter new Book id: ");
				book.setBookId(parseIntegerInput());
				System.out.println("Please enter new Book title: ");
				book.setTitle(parseStringInput());
				System.out.println("Please enter new Book publisher id: ");
				book.setPubId(parseIntegerInput());
			try {
				service.add(book);
			} catch (SQLException e1) {
				System.out.println("curdBook Add: Error failed to add Book");
			}
				break;
			case 2:
			try {
				//List all Book for user to choose to update from
				books = service.readAllBooks();
				for(Book b : books) {
					System.out.printf("%d %s, %d\n",b.getBookId(),b.getTitle(),b.getPubId());
					map.put(b.getBookId(), b);
				}
				System.out.println("Please enter the Id of the Book you wish to update: ");
				input = parseIntegerInput();
				book = map.get(input);
				System.out.println("Enter new Book title (N/A for no change): ");
				String s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					book.setTitle(s);
				}
				System.out.println("Enter new Publisher Id (N/A for no change): ");
				int n = parseIntegerInput();
				if(!s.toLowerCase().equals("n/a")) {
					book.setPubId(n);
				}
				service.update(book);
				map.clear();
			} catch (SQLException e) {
				System.out.println("curdBook Update: Error failed in updateing Book");
			}
				break;
			case 3:
				try {
					books = service.readAllBooks();
					for(Book b : books) {
						System.out.printf("%d %s, %d\n",b.getBookId(),b.getTitle(),b.getPubId());
						map.put(b.getBookId(), b);
					}
					System.out.println("Please enter the Id of the Book you wish to delete: ");
					input = parseIntegerInput();
					book = map.get(input);
					service.delete(book);
					map.clear();
				} catch (SQLException e) {
					System.out.println("curdBook Update: Error failed in updateing Book");
				}

				break;
			case 4:
			try {
				books = service.readAllBooks();
				for(Book b : books) {
					System.out.printf("%d %s, %d\n",b.getBookId(),b.getTitle(),b.getPubId());
				}
			} catch (SQLException e) {
				System.out.println("curdBook readAllBooks: Error failed read all Book");
			}
				break;
			case 5:
				adminMenu();
				break;
			default:
				adminMenu();
				break;
		}
		adminMenu();
	}

	

	private static void crudBorrowers() {
		AdminServiceBorrower service = new AdminServiceBorrower();
		Borrower b = new Borrower();
		List<Borrower> bs = new ArrayList<>();
		HashMap<Integer, Borrower> map = new HashMap<>();
		System.out.println("----------------------------------------");
		System.out.println("Crud Borrower Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add Borrower");
		System.out.println("2) Update Borrower");
		System.out.println("3) Delete Borrower");
		System.out.println("4) Read all Borrower");
		System.out.println("5) Return to Admin menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				System.out.println("Please enter new Borrower cardNo: ");
				b.setCardNo(parseIntegerInput());
				System.out.println("Please enter new Borrower's name: ");
				b.setName(parseStringInput());
				System.out.println("Please enter new Borrower's address: ");
				b.setAddress(parseStringInput());
				System.out.println("Please enter new Borrower's phone: ");
				b.setPhone(parseStringInput());
			try {
				service.add(b);
			} catch (SQLException e1) {
				System.out.println("curdBorrower Add: Error failed to add Borrower");
			}
				break;
			case 2:
			try {
				//List all Borrower for user to choose to update from
				bs = service.readAllBorrowers();
				for(Borrower bor : bs) {
					System.out.printf("%d %s, %s, %s\n",bor.getCardNo(), bor.getName(), bor.getPhone(), bor.getAddress());
					map.put(bor.getCardNo(), bor);
				}
				System.out.println("Please enter the Id of the Borrower you wish to update: ");
				input = parseIntegerInput();
				b = map.get(input);
				System.out.println("Enter new Borrower name (N/A for no change): ");
				String s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					b.setName(s);
				}
				System.out.println("Enter new Borrower phone (N/A for no change): ");
				s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					b.setPhone(s);
				}
				System.out.println("Enter new Borrower address (N/A for no change): ");
				s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					b.setAddress(s);
				}
				service.update(b);
				map.clear();
			} catch (SQLException e) {
				System.out.println("curdBorrower Update: Error failed in updateing Borrower");
			}
				break;
			case 3:
				try {
					bs = service.readAllBorrowers();
					for(Borrower bor : bs) {
						System.out.printf("%d %s, %s, %s\n",bor.getCardNo(), bor.getName(), bor.getPhone(), bor.getAddress());
						map.put(bor.getCardNo(), bor);
					}
					System.out.println("Please enter the Id of the Borrower you wish to delete: ");
					input = parseIntegerInput();
					b = map.get(input);
					service.delete(b);
					map.clear();
				} catch (SQLException e) {
					System.out.println("curdBorrower Update: Error failed in updateing Borrower");
				}

				break;
			case 4:
			try {
				bs = service.readAllBorrowers();
				for(Borrower bor : bs) {
					System.out.printf("%d %s, %s, %s\n",bor.getCardNo(), bor.getName(), bor.getPhone(), bor.getAddress());
				}
			} catch (SQLException e) {
				System.out.println("curdBorrower readAllBorrowers: Error failed read all Borrowers");
			}
				break;
			case 5:
				adminMenu();
				break;
			default:
				adminMenu();
				break;
		}		
		adminMenu();
	}

	private static void crudLibraryBranches() {
		AdminServiceLibraryBranches service = new AdminServiceLibraryBranches();
		LibraryBranch lb = new LibraryBranch();
		List<LibraryBranch> lbs = new ArrayList<>();
		HashMap<Integer, LibraryBranch> map = new HashMap<>();
		System.out.println("----------------------------------------");
		System.out.println("Crud LibraryBranch Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add LibraryBranch");
		System.out.println("2) Update LibraryBranch");
		System.out.println("3) Delete LibraryBranch");
		System.out.println("4) Read all LibraryBranch");
		System.out.println("5) Return to Admin menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				System.out.println("Please enter new LibraryBranch id: ");
				lb.setBranchId(parseIntegerInput());
				System.out.println("Please enter new LibraryBranch's name: ");
				lb.setBranchName(parseStringInput());
				System.out.println("Please enter new LibraryBranch's address: ");
				lb.setBranchAddress(parseStringInput());
			try {
				service.add(lb);
			} catch (SQLException e1) {
				System.out.println("curdLibraryBranch Add: Error failed to add LibraryBranch");
			}
				break;
			case 2:
			try {
				//List all LibraryBranch for user to choose to update from
				lbs = service.readAllLibraryBranches();
				for(LibraryBranch l : lbs) {
					System.out.printf("%d %s, %s\n",l.getBranchId(), l.getBranchName(), l.getBranchAddress());
					map.put(l.getBranchId(), l);
				}
				System.out.println("Please enter the Id of the LibraryBranch you wish to update: ");
				input = parseIntegerInput();
				lb = map.get(input);
				System.out.println("Enter new LibraryBranch name (N/A for no change): ");
				String s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					lb.setBranchName(s);
				}
				System.out.println("Enter new LibraryBranch address (N/A for no change): ");
				s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					lb.setBranchAddress(s);
				}
				service.update(lb);
				map.clear();
			} catch (SQLException e) {
				System.out.println("curdLibraryBranch Update: Error failed in updateing LibraryBranch");
			}
				break;
			case 3:
				try {
					lbs = service.readAllLibraryBranches();
					for(LibraryBranch l : lbs) {
						System.out.printf("%d %s, %s\n",l.getBranchId(), l.getBranchName(), l.getBranchAddress());
						map.put(l.getBranchId(), l);
					}
					System.out.println("Please enter the Id of the LibraryBranch you wish to delete: ");
					input = parseIntegerInput();
					lb = map.get(input);
					service.delete(lb);
					map.clear();
				} catch (SQLException e) {
					System.out.println("curdLibraryBranch Update: Error failed in updateing LibraryBranch");
				}

				break;
			case 4:
			try {
				lbs = service.readAllLibraryBranches();
				for(LibraryBranch l : lbs) {
					System.out.printf("%d %s, %s\n",l.getBranchId(), l.getBranchName(), l.getBranchAddress());
				}
			} catch (SQLException e) {
				System.out.println("curdLibraryBranch readAllLibraryBranches: Error failed read all LibraryBranches");
			}
				break;
			case 5:
				adminMenu();
				break;
			default:
				adminMenu();
				break;
		}
		adminMenu();
	}

	private static void crudPublisher() {
		AdminServicePublisher service = new AdminServicePublisher();
		Publisher pub = new Publisher();
		List<Publisher> pubs = new ArrayList<>();
		HashMap<Integer, Publisher> map = new HashMap<>();
		System.out.println("----------------------------------------");
		System.out.println("Crud Publisher Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add Publisher");
		System.out.println("2) Update Publisher");
		System.out.println("3) Delete Publisher");
		System.out.println("4) Read all Publisher");
		System.out.println("5) Return to Admin menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				System.out.println("Please enter new Publisher id: ");
				pub.setPublisherId(parseIntegerInput());
				System.out.println("Please enter new Publisher's name: ");
				pub.setPublisherName(parseStringInput());
				System.out.println("Please enter new Publisher's address: ");
				pub.setPublisherAddress(parseStringInput());
				System.out.println("Please enter new Publisher's phone: ");
				pub.setPublisherPhone(parseStringInput());
			try {
				service.add(pub);
			} catch (SQLException e1) {
				System.out.println("curdPublisher Add: Error failed to add Publisher");
			}
				break;
			case 2:
			try {
				//List all Publisher for user to choose to update from
				pubs = service.readAllPublishers();
				for(Publisher p : pubs) {
					System.out.printf("%d %s, %s, %s\n",p.getPublisherId(), p.getPublisherName(),p.getPublisherPhone(), p.getPublisherAddress());
					map.put(p.getPublisherId(), p);
				}
				System.out.println("Please enter the Id of the publisher you wish to update: ");
				input = parseIntegerInput();
				pub = map.get(input);
				System.out.println("Enter new publisher name (N/A for no change): ");
				String s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					pub.setPublisherName(s);
				}
				System.out.println("Enter new publisher phone (N/A for no change): ");
				s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					pub.setPublisherPhone(s);
				}
				System.out.println("Enter new publisher address (N/A for no change): ");
				s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					pub.setPublisherAddress(s);
				}
				service.update(pub);
				map.clear();
			} catch (SQLException e) {
				System.out.println("curdPublisher Update: Error failed in updateing publisher");
			}
				break;
			case 3:
				try {
					pubs = service.readAllPublishers();
					for(Publisher p : pubs) {
						System.out.printf("%d %s, %s, %s\n",p.getPublisherId(), p.getPublisherName(),p.getPublisherPhone(), p.getPublisherAddress());
						map.put(p.getPublisherId(), p);
					}
					System.out.println("Please enter the Id of the publisher you wish to delete: ");
					input = parseIntegerInput();
					pub = map.get(input);
					service.delete(pub);
					map.clear();
				} catch (SQLException e) {
					System.out.println("curdPublisher Update: Error failed in updateing publisher");
				}

				break;
			case 4:
			try {
				pubs = service.readAllPublishers();
				for(Publisher p : pubs) {
					System.out.printf("%d %s, %s, %s\n",p.getPublisherId(), p.getPublisherName(),p.getPublisherPhone(), p.getPublisherAddress());
				}
			} catch (SQLException e) {
				System.out.println("curdPublisher readAllPublishers: Error failed read all publishers");
			}
				break;
			case 5:
				adminMenu();
				break;
			default:
				adminMenu();
				break;
		}		
		adminMenu();
	}

	private static void crudGenres() {
		AdminServiceGenre service = new AdminServiceGenre();
		Genre genre = new Genre();
		List<Genre> genres = new ArrayList<>();
		HashMap<Integer, Genre> map = new HashMap<>();
		System.out.println("----------------------------------------");
		System.out.println("Crud Genre Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add Genre");
		System.out.println("2) Update Genre");
		System.out.println("3) Delete Genre");
		System.out.println("4) Read all Genre");
		System.out.println("5) Return to Admin menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				System.out.println("Please enter new Genre id: ");
				genre.setGenreId(parseIntegerInput());
				System.out.println("Please enter new Genre's name: ");
				genre.setGenreName(parseStringInput());
			try {
				service.add(genre);
			} catch (SQLException e1) {
				System.out.println("curdGenre Add: Error failed to add genre");
			}
				break;
			case 2:
			try {
				//List all authors for user to choose to update from
				genres = service.readAllGenres();
				for(Genre g : genres) {
					System.out.printf("%d %s\n",g.getGenreId(), g.getGenreName());
					map.put(g.getGenreId(), g);
				}
				System.out.println("Please enter the Id of the genre you wish to update: ");
				input = parseIntegerInput();
				genre = map.get(input);
				System.out.println("Enter new genre name (N/A for no change): ");
				String s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					genre.setGenreName(s);
				}
				service.update(genre);
				map.clear();
			} catch (SQLException e) {
				System.out.println("curdGenre Update: Error failed in updateing genre");
			}
				break;
			case 3:
				try {
					genres = service.readAllGenres();
					for(Genre g : genres) {
						System.out.printf("%d %s\n",g.getGenreId(), g.getGenreName());
						map.put(g.getGenreId(), g);
					}
					System.out.println("Please enter the Id of the genre you wish to delete: ");
					input = parseIntegerInput();
					genre = map.get(input);
					service.delete(genre);
					map.clear();
				} catch (SQLException e) {
					System.out.println("curdGenre Update: Error failed in updateing genre");
				}

				break;
			case 4:
			try {
				genres = service.readAllGenres();
				for(Genre g : genres) {
					System.out.printf("%d %s\n",g.getGenreId(), g.getGenreName());
				}
			} catch (SQLException e) {
				System.out.println("curdGenre readAllGenres: Error failed read all genres");
			}
				break;
			case 5:
				adminMenu();
				break;
			default:
				adminMenu();
				break;
		}
		adminMenu();
	}

	private static void crudAuthor() {
		AdminServiceAuthor service = new AdminServiceAuthor();
		Author auth = new Author();
		List<Author> auths = new ArrayList<>();
		HashMap<Integer, Author> aMap = new HashMap<>();
		System.out.println("----------------------------------------");
		System.out.println("Crud Author Menu:");
		System.out.println("Please select an option");
		System.out.println("1) Add Author");
		System.out.println("2) Update Author");
		System.out.println("3) Delete Author");
		System.out.println("4) Read all Authors");
		System.out.println("5) Return to Admin menu");
		int input = parseIntegerInput();
		switch(input) {
			case 1:
				System.out.println("Please enter new Author id: ");
				auth.setAuthorId( parseIntegerInput());
				System.out.println("Please enter new Author's name: ");
				auth.setAuthorName(parseStringInput());
			try {
				service.add(auth);
			} catch (SQLException e1) {
				System.out.println("curdAuthor Add: Error failed to add author");
			}
				break;
			case 2:
			try {
				//List all authors for user to choose to update from
				auths = service.readAllAuthors();
				for(Author a : auths) {
					System.out.printf("%d %s\n",a.getAuthorId(),a.getAuthorName());
					aMap.put(a.getAuthorId(), a);
				}
				System.out.println("Please enter the Id of the author you wish to update: ");
				input = parseIntegerInput();
				auth = aMap.get(input);
				System.out.println("Enter new author name (N/A for no change): ");
				String s = parseStringInput();
				if(!s.toLowerCase().equals("n/a")) {
					auth.setAuthorName(s);
				}
				service.update(auth);
				aMap.clear();
			} catch (SQLException e) {
				System.out.println("curdAuthor Update: Error failed in updateing author");
			}
				break;
			case 3:
				try {
					auths = service.readAllAuthors();
					for(Author a : auths) {
						System.out.printf("%d %s\n",a.getAuthorId(),a.getAuthorName());
						aMap.put(a.getAuthorId(), a);
					}
					System.out.println("Please enter the Id of the author you wish to delete: ");
					input = parseIntegerInput();
					auth = aMap.get(input);
					service.delete(auth);
					aMap.clear();
				} catch (SQLException e) {
					System.out.println("curdAuthor Update: Error failed in updateing author");
				}

				break;
			case 4:
			try {
				auths = service.readAllAuthors();
				for(Author a : auths) {
					System.out.printf("%d %s\n",a.getAuthorId(),a.getAuthorName());
				}
			} catch (SQLException e) {
				System.out.println("curdAuthor readAllAuthors: Error failed read all authors");
			}
				break;
			case 5:
				adminMenu();
				break;
			default:
				adminMenu();
				break;
		}
		adminMenu();
	}

	

}
