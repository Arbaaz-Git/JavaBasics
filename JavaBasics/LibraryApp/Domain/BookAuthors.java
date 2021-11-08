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
public class BookAuthors implements Serializable{
	private Integer bookId;
	private Integer authorId;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	//Generate Hash Based on both author and book ID
	@Override
	public int hashCode() {
		return Objects.hash(authorId, bookId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthors other = (BookAuthors) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(bookId, other.bookId);
	}
	
	
}
