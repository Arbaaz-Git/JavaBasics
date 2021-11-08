/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.BookGenres;

/**
 * @author Arbaaz Khan
 *
 */
public class BookGenresDAO extends BaseDAO<BookGenres>{

	public BookGenresDAO(Connection conn) {
		super(conn);
	}

	public void addBookGenres(BookGenres bg) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_book_genres (genre_id, bookId) VALUES (?, ?)",
				new Object[] {bg.getGenreId(),bg.getBookId()});
	}
	public void updateBookGenres(BookGenres bg)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book_genres set genre_id=? AND bookId=? ",
				new Object[] {bg.getGenreId(),bg.getBookId()});
	}
	public void deleteBookGenres(BookGenres bg) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_book_genres where bookId=? ",new Object[] {bg.getBookId()});
	}
	public List<BookGenres> readBookGenres()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_book_genres", null);
	}
	@Override
	protected List<BookGenres> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<BookGenres> bookGenre = new ArrayList<>();
		while(rs.next()) {
			BookGenres bg = new BookGenres();
			bg.setBookId(rs.getInt("bookId"));
			bg.setGenreId(rs.getInt("genre_id"));
			bookGenre.add(bg);
		}
		return bookGenre;
	}

}
