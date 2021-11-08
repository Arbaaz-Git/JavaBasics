/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Author;
import Domain.LibraryBranch;

/**
 * @author Arbaaz Khan
 *
 */
public class LibraryBranchDAO extends BaseDAO<LibraryBranch> {

	public LibraryBranchDAO(Connection conn) {
		super(conn);
	}
	
	public void addLibraryBranch(LibraryBranch lb) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_library_branch (branchId, branchName, branchAddress) VALUES (?, ?, ?)",
				new Object[] {lb.getBranchId(),lb.getBranchName(),lb.getBranchAddress()});
	}
	public void updateLibraryBranch(LibraryBranch lb)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_library_branch set branchName=?, branchAddress=? where branchId=? ",
				new Object[] {lb.getBranchName(),lb.getBranchAddress(),lb.getBranchId()});
	}
	public void deleteLibraryBranch(LibraryBranch lb) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_library_branch where branchId=? ",new Object[] {lb.getBranchId()});
	}
	public List<LibraryBranch> readLibraryBranch()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_library_branch", null);
	}

	@Override
	protected List<LibraryBranch> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<LibraryBranch> libraryBranch = new ArrayList<>();
		while(rs.next()) {
			LibraryBranch lb = new LibraryBranch();
			lb.setBranchId(rs.getInt("branchId"));
			lb.setBranchName(rs.getString("branchName"));
			lb.setBranchAddress(rs.getString("branchAddress"));
			libraryBranch.add(lb);
		}
		return libraryBranch;
	}

}
