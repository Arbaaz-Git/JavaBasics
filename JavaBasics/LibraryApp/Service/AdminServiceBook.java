/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.BookDAO;
import Domain.Book;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServiceBook {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void add(Book book) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookDAO bDAO = new BookDAO(conn);
			bDAO.addBook(book);
			conn.commit();	
			System.out.println("Book added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Book addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public List<Book> readAllBooks() throws SQLException {
		List<Book> books = new ArrayList<>();
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookDAO bDAO = new BookDAO(conn);
			books = bDAO.readBook();
			conn.commit();	
			System.out.println("Book added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Book addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return books;
	}

	public void update(Book book) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookDAO bDAO = new BookDAO(conn);
			bDAO.updateBook(book);
			conn.commit();	
			System.out.println("Book added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Book addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public void delete(Book book) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookDAO bDAO = new BookDAO(conn);
			bDAO.deleteBook(book);
			conn.commit();	
			System.out.println("Book added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Book addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

}
