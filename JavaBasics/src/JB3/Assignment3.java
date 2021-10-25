/**
 * 
 */
package JB3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Arbaaz Khan
 *	This program will read through the file called Alice.txt. This file is the book Alice in wonderland. The program will read thru it and return number of time a specific character appears in the text. THe character is determined by user input.
 */
public class Assignment3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Assignment3 assign =  new Assignment3();
		//Scanner will ask user for the character to count
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a character to search: ");
		String s = scan.nextLine();

		System.out.printf("There are %d instances of the character: %c",assign.countChar(assign.parseText(),s.charAt(0)),s.charAt(0));

	}
	
	//parseText will read thru alice and create a string of the file
	public String parseText() {
		String fullText = "";
		try(BufferedReader reader = new BufferedReader(new FileReader("resources/Alice.txt"))){	//Reads in alice
			String line;
			StringBuilder sb= new StringBuilder();
			while((line = reader.readLine()) !=null) {	//While there is a next line in the file keep reading
	            sb.append(line);
	            sb.append(System.lineSeparator());	//will create a new line in the string
			}
			fullText = sb.toString();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return fullText;
	}
	
	//Will count the number of time the char is seen in the text
	public int countChar(String s,char c) {
		int count = 0;
		
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == c) {
	            count++;
	        }
	    }
		
		return count;
	}

}
