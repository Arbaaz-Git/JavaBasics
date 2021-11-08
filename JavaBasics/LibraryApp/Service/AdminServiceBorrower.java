/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.BorrowerDAO;
import Domain.Borrower;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServiceBorrower {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void add(Borrower b) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bDAO = new BorrowerDAO(conn);
			bDAO.addBorrower(b);
			conn.commit();	
			System.out.println("Borrower added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Borrower addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public List<Borrower> readAllBorrowers() throws SQLException {
		List<Borrower> bs = new ArrayList<>();
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bDAO = new BorrowerDAO(conn);
			bs = bDAO.readBorrowers();
			conn.commit();	
			System.out.println("Borrower added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Borrower addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return bs;
	}

	public void update(Borrower b) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bDAO = new BorrowerDAO(conn);
			bDAO.updateBorrower(b);
			conn.commit();	
			System.out.println("Borrower added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Borrower addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public void delete(Borrower b) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bDAO = new BorrowerDAO(conn);
			bDAO.deleteBorrower(b);
			conn.commit();	
			System.out.println("Borrower added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Borrower addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

}
