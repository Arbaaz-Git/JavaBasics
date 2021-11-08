/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Book;
import Domain.BookCopies;

/**
 * @author Arbaaz Khan
 *
 */
public class BookDAO extends BaseDAO<Book>{

	public BookDAO(Connection conn) {
		super(conn);
	}
	public void addBook(Book b) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_book (bookId, title, pubId) VALUES (?, ?, ?)",
				new Object[] {b.getBookId(),b.getTitle(),b.getPubId()});
	}
	public void updateBook(Book b)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book set title=?, pubId=? where bookId=? ",
				new Object[] {b.getTitle(),b.getPubId(),b.getBookId()});
	}
	public void deleteBook(Book b) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_book where branchId=? ",new Object[] {b.getBookId()});
	}
	public List<Book> readBook()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_book", null);
	}

	@Override
	protected List<Book> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Book> book = new ArrayList<>();
		while(rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPubId(rs.getInt("pubId"));
			book.add(b);
		}
		return book;
	}

}
