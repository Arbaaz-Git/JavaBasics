/**
 * 
 */
package JB5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbaaz Khan
 *	THis code will be using java8 features
 *	The code will take in list of Integers and append either an "o" or "e" to a number given if the number is even or odd. 
 */
public class Assignment1_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(3);
		nums.add(5);
		nums.add(6);
		nums.add(8);
		nums.add(1);

		//Will be using streams and lambda expressions  
		String uNums = nums.stream().map(n ->{
			if(n%2==0) {
				return "e"+n;
			}
			else {
				return n+"o";
			}
		}).collect(Collectors.joining(", "));
		
		System.out.println(uNums);
		
		
		
		
	}
	

}
