/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Domain.Author;

/**
 * @author Arbaaz Khan
 *
 */
public abstract class BaseDAO<T> {
	protected static Connection conn =null;
	
	public BaseDAO(Connection conn) {
		this.conn=conn;
	}

	
	protected void save(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(vals!=null) {
			int count = 1;
			for(Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.execute();
	}
	
	//THis is Thread safe
	protected Integer saveWithPK(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if(vals!=null) {
			int count = 1;
			for(Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.execute();
		ResultSet rs = pstmt.getGeneratedKeys();
		while(rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}
	
	protected List<T> read(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(vals!=null) {
			int count = 1;
			for(Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	protected abstract List<T> extractData(ResultSet rs) throws SQLException, ClassNotFoundException;
}
