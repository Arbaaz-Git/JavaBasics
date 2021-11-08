/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DAO.AuthorDAO;
import DAO.BookAuthorsDAO;
import DAO.BookCopiesDAO;
import DAO.BookDAO;
import DAO.LibraryBranchDAO;
import Domain.Author;
import Domain.Book;
import Domain.BookAuthors;
import Domain.BookCopies;
import Domain.LibraryBranch;

/**
 * @author Arbaaz Khan
 *
 */
public class LibrarianService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Book> readAllBooks() throws SQLException{
		Connection conn =null;
		List<Book> book = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookDAO bDAO = new BookDAO(conn);
			book = bDAO.readBook();
			conn.commit();	
			System.out.println("Returned full list of books");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to return list of books");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return book;
	}
	public void updateBookCopies(BookCopies bc) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcDAO = new BookCopiesDAO(conn);
			bcDAO.updateBookCopies(bc);
			conn.commit();	
			System.out.println("BookCopies info updated");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to update BookCopies info");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public List<String> readAllBooksNAuthors() throws SQLException {
		Connection conn =null;
		List<String> bap = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookAuthorsDAO baDAO = new BookAuthorsDAO(conn);
			bap = baDAO.readBookAuthorPair();
			conn.commit();	
			System.out.println("Returned full list of books and Authors");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to return list of books and Authors");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return bap;
	}
	
	public List<BookCopies> copyOfBookInBranch(LibraryBranch branch, Book book) throws SQLException {
		Connection conn =null;
		List<BookCopies> bc = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcDAO = new BookCopiesDAO(conn);
			bc = bcDAO.copiesOfBookFromBranch(branch,book);
			conn.commit();	
			System.out.println("Returned number of bookCopies from library");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to return number of bookCopies from library");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return bc;
	}
	
	
	public void updateLibraryBranch(LibraryBranch branch) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
			lbDAO.updateLibraryBranch(branch);
			conn.commit();	
			System.out.println("Branch info updated");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to update branch info");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}
	
	public List<LibraryBranch> readAllLibrarys() throws SQLException{
		Connection conn =null;
		List<LibraryBranch> branches = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
			branches = lbDAO.readLibraryBranch();
			conn.commit();	
			System.out.println("Returned full list of library branches");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to return list of library branches");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return branches;
	}
	
}
