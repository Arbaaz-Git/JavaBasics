/**
 * 
 */
package JB5Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import JB5.Assignment1_3;

/**
 * @author Arbaaz Khan
 *
 */
public class Assignmnet1Test {
	Assignment1_3 a13 = new Assignment1_3();
	List<String> actual = Arrays.asList("aaa", "bb", "abc");
	List<String> expected = Arrays.asList("aaa", "abc");
	
	@Test
	public void filterAWordsTest() {
		assertEquals(expected,a13.filterAWords(actual));	//This is see if the test passes
		
		assertNotEquals(actual,a13.filterAWords(actual));	//THis is to see if i get the same list back as the one I inputed
		
	}
}
