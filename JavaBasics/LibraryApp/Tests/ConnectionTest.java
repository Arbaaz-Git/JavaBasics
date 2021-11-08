/**
 * 
 */
package Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.BookDAO;
import DAO.GenreDAO;
import Domain.Book;
import Domain.Genre;
import Service.ConnectionUtil;

/**
 * @author Arbaaz Khan
 *
 */
public class ConnectionTest {
	ConnectionUtil connUtil = new ConnectionUtil();
    	
	@Test
	public void readAllBooks() throws SQLException{
		Connection conn =null;
		List<Book> book = new ArrayList<>();
		Book b = new Book();
		try {
			conn = connUtil.getConnection();
			BookDAO bDAO = new BookDAO(conn);
			book = bDAO.readBook();
			
            assertNotNull(book);	//Make sure that readBook actually returns something
            assertSame(book.get(0).getClass(),b.getClass());	//Make sure the returned list objects of type Book
          
			
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
	}
	
    @Test
    public void readGenreTest() throws SQLException {
        Connection conn = null;
        List<Genre> genre = new ArrayList<>();
        Genre g = new Genre();
        try {
            conn = connUtil.getConnection();
            GenreDAO gDAO = new GenreDAO(conn);
            genre = gDAO.readGenre();

            assertNotNull(genre);	//Make sure that readGenre actually returns something
            assertSame(genre.get(0).getClass(),g.getClass());	//Make sure the returned list objects of type Genre
            
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
