/**
 * 
 */
package JB5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbaaz Khan
 *	In this code we are taking a list of numbers and passing it thru a stream that will double each number in the list
 */
public class Assignment2_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		doubling(nums).stream().forEach(n -> System.out.println(n));

	}
	public static List<Integer> doubling(List<Integer> nums){
		return nums.stream().map(n -> n*2).collect(Collectors.toList());
	}
}
