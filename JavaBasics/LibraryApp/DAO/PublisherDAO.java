/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Publisher;
import Domain.Publisher;

/**
 * @author Arbaaz Khan
 *
 */
public class PublisherDAO extends BaseDAO<Publisher>{

	public PublisherDAO(Connection conn) {
		super(conn);
	}
	public void addPublisher(Publisher pub) throws SQLException, ClassNotFoundException {
		save("INSERT INTO tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?, ?, ?, ?)",
				new Object[] {pub.getPublisherId(), pub.getPublisherName(), pub.getPublisherAddress(), pub.getPublisherPhone()});
	}
	public void updatePublisher(Publisher pub)  throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_publisher set publisherName=?, publisherAddress=?, publisherPhone=? where publisherId=?  ",
				new Object[] {pub.getPublisherName(), pub.getPublisherAddress(), pub.getPublisherPhone(),pub.getPublisherId()});
	}
	public void deletePublisher(Publisher pub) throws SQLException, ClassNotFoundException {
		save("Delete from tbl_publisher where publisherId=? ",new Object[] {pub.getPublisherId()});
	}
	public List<Publisher> readPublishers()  throws SQLException, ClassNotFoundException{
		return read("select * from tbl_publisher", null);
	}
	@Override
	protected List<Publisher> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Publisher> publish = new ArrayList<>();
		while(rs.next()) {
			Publisher pub = new Publisher();
			pub.setPublisherId(rs.getInt("publisherId"));
			pub.setPublisherName(rs.getString("publisherName"));
			pub.setPublisherAddress(rs.getString("publisherAddress"));
			pub.setPublisherPhone(rs.getString("publisherPhone"));
			publish.add(pub);
		}
		return publish;
	}

}
