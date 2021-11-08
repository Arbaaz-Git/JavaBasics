/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.LibraryBranchDAO;
import Domain.LibraryBranch;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServiceLibraryBranches {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void add(LibraryBranch lb) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
			lbDAO.addLibraryBranch(lb);
			conn.commit();	
			System.out.println("LibraryBranch added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("LibraryBranch addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}		
	}

	public List<LibraryBranch> readAllLibraryBranches() throws SQLException {
		List<LibraryBranch> lbs = new ArrayList<>();
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
			lbs = lbDAO.readLibraryBranch();
			conn.commit();	
			System.out.println("LibraryBranch added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("LibraryBranch addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return lbs;
	}

	public void update(LibraryBranch lb) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
			lbDAO.updateLibraryBranch(lb);
			conn.commit();	
			System.out.println("LibraryBranch added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("LibraryBranch addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}	
		
	}

	public void delete(LibraryBranch lb) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
			lbDAO.deleteLibraryBranch(lb);
			conn.commit();	
			System.out.println("LibraryBranch added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("LibraryBranch addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}	
		
	}

}
