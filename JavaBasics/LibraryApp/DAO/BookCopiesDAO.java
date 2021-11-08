/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Book;
import Domain.BookCopies;
import Domain.LibraryBranch;

/**
 * @author Arbaaz Khan
 *
 */
public class BookCopiesDAO extends BaseDAO<BookCopies>{

	public BookCopiesDAO(Connection conn) {
		super(conn);
	}
	public void addBookCopies(BookCopies bc) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_book_copies (bookId, branchId, noOfCopies) VALUES (?, ?, ?)",
				new Object[] {bc.getBookId(),bc.getBranchId(),bc.getNoOfCopies()});
	}
	public void updateBookCopies(BookCopies bc)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book_copies set noOfCopies=?, branchId=? where bookId=? ",
				new Object[] {bc.getNoOfCopies(),bc.getBranchId(),bc.getBookId()});
	}
	public void deleteBookCopies(BookCopies bc) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_book_copies where branchId=? ",new Object[] {bc.getBranchId()});
	}
	public List<BookCopies> readBookCopies()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_book_copies", null);
	}

	@Override
	protected List<BookCopies> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<BookCopies> bookCopies = new ArrayList<>();
		while(rs.next()) {
			BookCopies bc = new BookCopies();
			bc.setBranchId(rs.getInt("branchId"));
			bc.setBookId(rs.getInt("bookId"));
			bc.setNoOfCopies(rs.getInt("noOfCopies"));
			bookCopies.add(bc);
		}
		return bookCopies;
	}

	public List<BookCopies> copiesOfBookFromBranch(LibraryBranch branch, Book book) throws SQLException, ClassNotFoundException {
		return read("Select tbl_book_copies.*\r\n"
				+ "FROM  tbl_book\r\n"
				+ "right join tbl_book_copies on tbl_book.bookId = tbl_book_copies.bookId\r\n"
				+ "right join tbl_library_branch on tbl_book_copies.branchId= tbl_library_branch.branchId\r\n"
				+ "where tbl_library_branch.branchId=? and\r\n"
				+ "tbl_book.title=?", new Object[] {branch.getBranchId(),book.getTitle()});

	}
}
