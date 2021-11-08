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
public class LibraryBranch implements Serializable{
	private Integer branchId;
	private String branchName;
	private String branchAddress;
	
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	//Generate Hash based on bracnhId
	@Override
	public int hashCode() {
		return Objects.hash(branchId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryBranch other = (LibraryBranch) obj;
		return Objects.equals(branchId, other.branchId);
	}
	
}
