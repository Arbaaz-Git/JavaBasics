/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.AuthorDAO;
import DAO.BookCopiesDAO;
import Domain.Author;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServiceAuthor {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void add(Author auth) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO aDAO = new AuthorDAO(conn);
			aDAO.addAuthor(auth);
			conn.commit();	
			System.out.println("Author added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Author addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public void update(Author auth) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO aDAO = new AuthorDAO(conn);
			aDAO.updateAuthor(auth);
			conn.commit();	
			System.out.println("Author updated sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Author update failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public void delete(Author auth) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO aDAO = new AuthorDAO(conn);
			aDAO.deleteAuthor(auth);
			conn.commit();	
			System.out.println("Succesfully deleted Author");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Failed to delete Author");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		
	}

	public List<Author> readAllAuthors() throws SQLException{
		Connection conn =null;
		List<Author> auth = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			AuthorDAO aDAO = new AuthorDAO(conn);
			auth = aDAO.readAuthors();
			conn.commit();	
			System.out.println("Authors read succesfully ");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Authors read failed ");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return auth;
	}

}
