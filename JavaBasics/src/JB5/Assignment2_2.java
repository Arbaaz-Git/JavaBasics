/**
 * 
 */
package JB5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbaaz Khan
 *	In this code I am taking in a list of numbers and passing it thru a stream that will return the right most digit of a given number
 */
public class Assignment2_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(22);
		nums.add(93);
		for(int i :rightDigit(nums)) {
			System.out.println(i);
		}
		
	}
	
	public static List<Integer> rightDigit(List<Integer> vals){
		return vals.stream().map(n -> n % 10).collect(Collectors.toList());
	}

}
