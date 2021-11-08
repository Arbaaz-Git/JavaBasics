/**
 * 
 */
package Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Arbaaz Khan
 *
 */
public class Book implements Serializable{
	private Integer bookId;
	private String title;
	private Integer pubId;	//publisher ID
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPubId() {
		return pubId;
	}
	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}
	
	//Setting Hash Based on bookId
	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookId, other.bookId);
	}
	
	

}
