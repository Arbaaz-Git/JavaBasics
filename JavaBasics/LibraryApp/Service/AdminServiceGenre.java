/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.GenreDAO;
import Domain.Genre;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServiceGenre {
	ConnectionUtil connUtil = new ConnectionUtil();
	public void add(Genre genre) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			GenreDAO gDAO = new GenreDAO(conn);
			gDAO.addGenre(genre);
			conn.commit();	
			System.out.println("Genre added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Genre addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}		
	}

	public List<Genre> readAllGenres() throws SQLException {
		Connection conn =null;
		List<Genre> genre = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			GenreDAO gDAO = new GenreDAO(conn);
			genre = gDAO.readGenre();
			conn.commit();	
			System.out.println("Genres read succesfully ");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Genres read failed ");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return genre;
	}

	public void update(Genre genre) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			GenreDAO gDAO = new GenreDAO(conn);
			gDAO.updateGenre(genre);
			conn.commit();	
			System.out.println("Genre added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Genre addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}	
		
	}

	public void delete(Genre genre) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			GenreDAO gDAO = new GenreDAO(conn);
			gDAO.deleteGenre(genre);
			conn.commit();	
			System.out.println("Genre added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Genre addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}	
		
	}

}
