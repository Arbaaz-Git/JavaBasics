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
import Domain.Borrower;
import Domain.Borrower;

/**
 * @Borrower Arbaaz Khan
 *
 */
public class BorrowerDAO extends BaseDAO<Borrower>{

	public BorrowerDAO(Connection conn) {
		super(conn);
	}
	public void addBorrower(Borrower borrow) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_borrower (cardNo, name, address, phone) VALUES (?, ?, ?, ?)",
				new Object[] {borrow.getCardNo(),borrow.getName(),borrow.getAddress(),borrow.getPhone()});
	}
	public void updateBorrower(Borrower borrow)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_borrower set name=?, address=?, phone=? where cardNo=? ",
				new Object[] {borrow.getName(), borrow.getAddress(), borrow.getPhone(), borrow.getCardNo()});
	}
	public void deleteBorrower(Borrower borrow) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_borrower where cardNo=? ",new Object[] {borrow.getCardNo()});
	}
	public List<Borrower> readBorrowers()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_borrower", null);
	}

	@Override
	protected List<Borrower> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Borrower> borrower = new ArrayList<>();
		while(rs.next()) {
			Borrower borr = new Borrower();
			borr.setCardNo(rs.getInt("cardNo"));
			borr.setName(rs.getString("name"));
			borr.setAddress(rs.getString("address"));
			borr.setPhone(rs.getString("phone"));
			borrower.add(borr);
		}
		return borrower;
	}

}
