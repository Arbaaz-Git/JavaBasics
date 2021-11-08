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
public class BookGenres implements Serializable{
	private Integer genreId;
	private Integer bookId;
	
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	//Generate Hash based on book and genre ID
	@Override
	public int hashCode() {
		return Objects.hash(bookId, genreId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookGenres other = (BookGenres) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(genreId, other.genreId);
	}
	
}
