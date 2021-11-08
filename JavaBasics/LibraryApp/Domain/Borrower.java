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
public class Borrower implements Serializable{
	private Integer cardNo;
	private String name;
	private String address;
	private String phone;
	
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//Generate Hash based on cardNo
	@Override
	public int hashCode() {
		return Objects.hash(cardNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Borrower other = (Borrower) obj;
		return Objects.equals(cardNo, other.cardNo);
	}
	
}
