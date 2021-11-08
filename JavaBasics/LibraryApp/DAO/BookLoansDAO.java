/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.BookLoans;
import Domain.Borrower;
import Domain.BookLoans;

/**
 * @author Arbaaz Khan
 *
 */
public class BookLoansDAO extends BaseDAO<BookLoans>{

	public BookLoansDAO(Connection conn) {
		super(conn);
	}
	public void addBookLoans(BookLoans bookloan) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate, dateIn) VALUES (?, ?, ?, ?, ?, ?)",
				new Object[] {bookloan.getBookId(), bookloan.getBranchId(), bookloan.getCardNo(), bookloan.getDateOut(), bookloan.getDueDate(), bookloan.getDateIn()});
	}
	public void updateBookLoans(BookLoans bookloan)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book_loans set dateOut=?, dateIn=?, dueDate=?, branchId=?, cardNo=? where bookId=? ",
				new Object[] {bookloan.getDateOut(), bookloan.getDateIn(),bookloan.getDueDate(),bookloan.getBranchId(),bookloan.getCardNo(), bookloan.getBookId()});
	}
	public void deleteBookLoans(BookLoans bookloan) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_book_loans where cardNo=? ",new Object[] {bookloan.getCardNo()});
	}
	public List<BookLoans> readBookLoans()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_book_loans", null);
	}
	@Override
	protected List<BookLoans> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<BookLoans> bookloan = new ArrayList<>();
		while(rs.next()) {
			BookLoans bl = new BookLoans();
			bl.setCardNo(rs.getInt("cardNo"));
			bl.setBookId(rs.getInt("bookId"));
			bl.setBranchId(rs.getInt("branchId"));
			bl.setDateIn(rs.getTimestamp("dateIn"));
			bl.setDateOut(rs.getTimestamp("dateOut"));
			bl.setDueDate(rs.getTimestamp("dueDate"));
			bookloan.add(bl);
		}
		return bookloan;
	}
	public List<BookLoans> readBorrowedLoans(Borrower b) throws ClassNotFoundException, SQLException {
		return read("Select tbl_book_loans.*\r\n"
				+ "From tbl_book_loans\r\n"
				+ "left join tbl_borrower on tbl_book_loans.cardNo = tbl_borrower.cardNo\r\n"
				+ "where tbl_borrower.cardNo=?", new Object[] {b.getCardNo()});
	}

}
