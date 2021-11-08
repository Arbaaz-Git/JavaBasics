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

/**
 * @author Arbaaz Khan
 *
 */
public class AuthorDAO extends BaseDAO<Author>{
	
	public AuthorDAO(Connection conn) {
		super(conn);
	}
	
	public void addAuthor(Author auth) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_author (authorId, authorName) VALUES (?, ?)",
				new Object[] {auth.getAuthorId(),auth.getAuthorName()});
	}
	public void updateAuthor(Author auth)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_author set authorId=? AND authorName=? ",
				new Object[] {auth.getAuthorId(),auth.getAuthorName()});
	}
	public void deleteAuthor(Author auth) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_author where authorId=? ",new Object[] {auth.getAuthorId()});
	}
	public List<Author> readAuthors()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_author", null);
	}
	@Override
	protected List<Author> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Author> authors = new ArrayList<>();
		while(rs.next()) {
			Author auth = new Author();
			auth.setAuthorId(rs.getInt("authorId"));
			auth.setAuthorName(rs.getString("authorName"));
			authors.add(auth);
		}
		return authors;
	}
}
