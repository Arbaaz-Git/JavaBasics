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
public class Publisher implements Serializable{
	private Integer publisherId;
	private String publisherName;
	private String publisherAddress;
	private String publisherPhone;
	
	public String getPublisherPhone() {
		return publisherPhone;
	}
	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}
	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	
	//Generate Hash based on publisherId
	@Override
	public int hashCode() {
		return Objects.hash(publisherId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return Objects.equals(publisherId, other.publisherId);
	}
	
	
}
