/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.BookAuthorsDAO;
import DAO.BookCopiesDAO;
import DAO.BookDAO;
import DAO.BookLoansDAO;
import DAO.LibraryBranchDAO;
import Domain.Book;
import Domain.BookCopies;
import Domain.BookLoans;
import Domain.LibraryBranch;

/**
 * @author Arbaaz Khan
 *
 */
public class BorrowerService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void updateBookLoans(BookLoans bl) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO blDAO = new BookLoansDAO(conn);
			blDAO.updateBookLoans(bl);
			conn.commit();	
			System.out.println("BookLoans info updated");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to update BookLoans info");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}
	
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
	
	public List<String> readAllBooksNAuthors(LibraryBranch lb) throws SQLException {
		Connection conn =null;
		List<String> bap = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookAuthorsDAO baDAO = new BookAuthorsDAO(conn);
			bap = baDAO.readBookAuthorFromBranch(lb);
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
