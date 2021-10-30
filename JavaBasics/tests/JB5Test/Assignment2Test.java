/**
 * 
 */
package JB5Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import JB5.Assignment2_1;
import JB5.Assignment2_2;
import JB5.Assignment2_3;
import JB5.Assignment2_4;

/**
 * @author Arbaaz Khan
 *
 */
public class Assignment2Test {
	Assignment2_2 a22 = new Assignment2_2();
	Assignment2_3 a23 = new Assignment2_3();
	Assignment2_4 a24 = new Assignment2_4();
	
	List<String> actualString = Arrays.asList("xxa", "bxb", "abc");
	List<String> expectedString = Arrays.asList("a", "bb","abc");
	List<Integer> actualInts = Arrays.asList(16,6,888,12,2);
	List<Integer> expectedInts = Arrays.asList(6,6,8,2,2);
	
	@Test
	public void A22Test() {
		//Test to Make sure rightDigit is working correctly
		assertEquals(expectedInts,a22.rightDigit(actualInts));
		
		//Test to see if methods fail
		assertNotEquals(actualInts,a22.rightDigit(actualInts));
		
	}
	
	@Test
	public void A23Test() {
		actualInts = Arrays.asList(6,8,12,3);
		expectedInts = Arrays.asList(12,16,24,6);
		//Test to Make sure rightDigit is working correctly
		assertEquals(expectedInts,a23.doubling(actualInts));
		
		//Test to see if methods fail
		assertNotEquals(actualInts,a23.doubling(actualInts));
		
	}
	
	@Test
	public void A24Test() {
		//Test to Make sure rightDigit is working correctly
		assertEquals(expectedString,a24.noX(actualString));
		
		//Test to see if methods fail
		assertNotEquals(actualString,a24.noX(expectedString));
		
	}
	
	

}
