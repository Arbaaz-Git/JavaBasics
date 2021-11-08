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

import Domain.Author;
import Domain.BookAuthors;
import Domain.LibraryBranch;
import Domain.BookAuthors;

/**
 * @BookAuthors Arbaaz Khan
 *
 */
public class BookAuthorsDAO extends BaseDAO<BookAuthors>{

	public BookAuthorsDAO(Connection conn) {
		super(conn);
	}
	
	public void addBookAuthors(BookAuthors bAuth) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_book_authors (authorId, bookId) VALUES (?, ?)",
				new Object[] {bAuth.getAuthorId(),bAuth.getBookId()});
	}
	public void updateBookAuthors(BookAuthors bAuth)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book_authors set authorId=? AND bookId=? ",
				new Object[] {bAuth.getAuthorId(),bAuth.getBookId()});
	}
	public void deleteBookAuthors(BookAuthors bAuth) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_book_authors where authorId=? and bookId=? ",new Object[] {bAuth.getAuthorId(),bAuth.getBookId()});
	}
	public List<BookAuthors> readBookAuthors()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_book_authors", null);
	}

	@Override
	protected List<BookAuthors> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<BookAuthors> bAuthor = new ArrayList<>();
		while(rs.next()) {
			BookAuthors ba = new BookAuthors();
			ba.setAuthorId(rs.getInt("authorId"));
			ba.setBookId(rs.getInt("bookId"));
			bAuthor.add(ba);
		}
		return bAuthor;
	}
	
	//This method will return all the book titles with their corresponding author
	public List<String> readBookAuthorPair() throws SQLException {
		List<String> bap = new ArrayList<>();
		String sql = "Select title, authorName\r\n"
				+ "From tbl_book\r\n"
				+ "left join tbl_book_authors on tbl_book.bookId = tbl_book_authors.bookId\r\n"
				+ "left join tbl_author on tbl_book_authors.authorId = tbl_author.authorId";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			bap.add(rs.getString(1)+" by "+rs.getString(2));
		}
		return bap;
	}

	
	//This method will return all the book titles with their corresponding author from a specific branch
	public List<String> readBookAuthorFromBranch(LibraryBranch lb) throws SQLException {
		List<String> bap = new ArrayList<>();
		String sql = "Select title, authorName\r\n"
				+ "From tbl_book\r\n"
				+ "left join tbl_book_authors on tbl_book.bookId = tbl_book_authors.bookId\r\n"
				+ "left join tbl_author on tbl_book_authors.authorId = tbl_author.authorId\r\n"
				+ "right join tbl_book_copies on tbl_book.bookId = tbl_book_copies.bookId\r\n"
				+ "right join tbl_library_branch on tbl_book_copies.branchId= tbl_library_branch.branchId\r\n"
				+ "where tbl_library_branch.branchId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, lb.getBranchId());

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			bap.add(rs.getString(1)+" by "+rs.getString(2));
		}
		return bap;
	}
}
