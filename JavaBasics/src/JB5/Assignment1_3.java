/**
 * 
 */
package JB5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbaaz Khan
 *	In this code we are given a list of strings and want to write a method that returns a list of all the strings that start with "a" and has exactly 3 letters in the word
 *The Key to this code is that it is using Streams and lambda expressions to create the filtered list 
 */
public class Assignment1_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("Apple");
		words.add("aaaba");
		words.add("aba");
		words.add("wheel");
		words.add("And");
		words.add("a");
		
		filterAWords(words).forEach(word -> System.out.println(word));
	}
	
	public static List<String> filterAWords(List<String> words){
		List<String> list = words.stream().filter(s -> s.charAt(0)=='a' && s.length()==3).collect(Collectors.toList());
		return list;
	}

}
