/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.PublisherDAO;
import Domain.Publisher;

/**
 * @author Arbaaz Khan
 *
 */
public class AdminServicePublisher {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void add(Publisher pub) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDAO = new PublisherDAO(conn);
			pDAO.addPublisher(pub);
			conn.commit();	
			System.out.println("Publisher added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Publisher addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public List<Publisher> readAllPublishers() throws SQLException {
		Connection conn =null;
		List<Publisher> pubs = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDAO = new PublisherDAO(conn);
			pubs = pDAO.readPublishers();
			conn.commit();	
			System.out.println("Publisher added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Publisher addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
		return pubs;
	}

	public void update(Publisher pub) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDAO = new PublisherDAO(conn);
			pDAO.updatePublisher(pub);
			conn.commit();	
			System.out.println("Publisher added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Publisher addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

	public void delete(Publisher pub) throws SQLException {
		Connection conn =null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDAO = new PublisherDAO(conn);
			pDAO.deletePublisher(pub);
			conn.commit();	
			System.out.println("Publisher added sucessfully");
		}catch(Exception e) {
			if(conn!=null) {
				conn.rollback();
			}
			System.out.println("Publisher addition failed");
		}finally {
			if(conn!=null) {
				conn.rollback();
			}
		}
	}

}
