/**
 * 
 */
package JB5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Arbaaz Khan
 *	This code is showing off how to use lambda expressions
 */

public class Assignment1_1 implements Comparator<String>  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Assignment1_1 assign = new Assignment1_1();
		String[] fruits = {"Apple","Oragne", "Banana", "Pear", "Strawberry"};
		
		//Sort fruits array from shortest to longest 
		Arrays.sort(fruits, (a, b) -> a.length() - b.length());
		System.out.println(Arrays.toString(fruits));
		
		//Sort fruits array from longest to shortest
		Arrays.sort(fruits, (a, b) -> b.length() - a.length());
		System.out.println(Arrays.toString(fruits));
		
		//Sort fruits array alphabetically 
		Arrays.sort(fruits, (a, b) -> a.charAt(0) - b.charAt(0));
		System.out.println(Arrays.toString(fruits));
		
		//Sort fruits array where words that contain the letter e are first
        Arrays.sort(fruits, (a, b) -> {
            if ((a.contains("e") && (b.contains("e")))) {
                return 0;
            } else if (a.contains("e")) {
                return -1;
            } else {
                return 1;
            }
        });
		System.out.println(Arrays.toString(fruits));
		
		//Sort fruits array where words that contain the letter e are first, but now while using a helper method 
		Arrays.sort(fruits, (a, b) -> assign.compare(a, b));
		System.out.println(Arrays.toString(fruits));
		
	}

	//this is my helper method
	@Override
	public int compare(String a, String b) {
        if ((a.contains("e") && (b.contains("e")))) {
            return 0;
        } else if (a.contains("e")) {
            return -1;
        } else {
            return 1;
        }
	}

}
