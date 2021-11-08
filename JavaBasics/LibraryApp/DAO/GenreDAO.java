/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Domain.Genre;

/**
 * @author Arbaaz Khan
 *
 */
public class GenreDAO extends BaseDAO<Genre>{

	public GenreDAO(Connection conn) {
		super(conn);
	}
	public void addGenre(Genre genre) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_genre (genre_id, genre_name) VALUES (?, ?)",
				new Object[] {genre.getGenreId(),genre.getGenreName()});
	}
	public void updateGenre(Genre genre)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_genre set genre_id=? AND genre_name=? ",
				new Object[] {genre.getGenreId(),genre.getGenreName()});
	}
	public void deleteGenre(Genre genre) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_genre where genre_id=? ",new Object[] {genre.getGenreId()});
	}
	public List<Genre> readGenre()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_genre", null);
	}
	@Override
	protected List<Genre> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Genre> gen = new ArrayList<>();
		while(rs.next()) {
			Genre genre = new Genre();
			genre.setGenreId(rs.getInt("genre_id"));
			genre.setGenreName(rs.getString("genre_name"));
			gen.add(genre);
		}
		return gen;
	}

}
