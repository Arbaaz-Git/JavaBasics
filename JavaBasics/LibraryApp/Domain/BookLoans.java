/**
 * 
 */
package Domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Arbaaz Khan
 *
 */
public class BookLoans implements Serializable{
	private Integer bookId;
	private Integer branchId;
	private Integer cardNo;
	private Timestamp dateOut;
	private Timestamp dueDate;
	private Timestamp dateIn;
	
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
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public Timestamp getDateOut() {
		return dateOut;
	}
	public void setDateOut(Timestamp dateOut) {
		this.dateOut = dateOut;
	}
	public Timestamp getDueDate() {
		return dueDate;
	}
	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}
	public Timestamp getDateIn() {
		return dateIn;
	}
	public void setDateIn(Timestamp dateIn) {
		this.dateIn = dateIn;
	}

	
	//Generate Hash based on bookId, branchId and cardNo
	@Override
	public int hashCode() {
		return Objects.hash(bookId, branchId, cardNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoans other = (BookLoans) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(branchId, other.branchId)
				&& Objects.equals(cardNo, other.cardNo);
	}
}
