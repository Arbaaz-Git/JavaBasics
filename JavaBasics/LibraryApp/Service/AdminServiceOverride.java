/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.AuthorDAO;
import DAO.BookLoansDAO;
import Domain.BookLoans;
import Domain.BookLoans;
import Domain.Borrower;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServiceOverride {
	ConnectionUtil connUtil = new ConnectionUtil();

	public List<BookLoans> getBorrowerLoans(Borrower b) throws SQLException {
		Connection conn =null;
		List<BookLoans> bl = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookLoansDAO blDAO = new BookLoansDAO(conn);
			bl = blDAO.readBorrowedLoans(b);
			conn.commit();	
			System.out.println("BorrowedLoans read succesfully ");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("BorrowedLoans read failed ");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return bl;
	}

	public void override(BookLoans bl) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO blDAO = new BookLoansDAO(conn);
			blDAO.updateBookLoans(bl);
			conn.commit();	
			System.out.println("DueDate override Succesful ");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("DueDate override failed ");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		
	}
	
}
