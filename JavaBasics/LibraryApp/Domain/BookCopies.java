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
public class BookCopies implements Serializable{
	private Integer bookId;
	private Integer branchId;
	private Integer noOfCopies;	//Number of Book copies
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	//Generate Hash based on book and branch ID
	@Override
	public int hashCode() {
		return Objects.hash(bookId, branchId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCopies other = (BookCopies) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(branchId, other.branchId);
	}
	
	

}
