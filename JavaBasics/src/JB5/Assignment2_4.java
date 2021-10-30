/**
 * 
 */
package JB5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbaaz Khan
 *	This code takes in a list of words and passes it thru a stream that removes the letter "x" from the word
 */
public class Assignment2_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Assignment2_4 assign = new Assignment2_4();
		List<String> words = new ArrayList<>();
		words.add("ax");
		words.add("bb");
		words.add("cx");
		assign.noX(words).stream().forEach(s -> System.out.println(s));

	}
	
	public List<String> noX(List<String> words){
		return words.stream().map(s -> s.replace("x", "")).collect(Collectors.toList());
	}

}
