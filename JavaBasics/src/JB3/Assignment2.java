/**
 * 
 */
package JB3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Arbaaz Khan
 * The goal of this assignment is to append text to an existing file. The file that is going to be append is called File_to_Append.txt
 *
 */
public class Assignment2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Assignment2 assign =  new Assignment2();
		//The user can enter whatever they want into the file 
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter text to append to the file: ");
		String s = scan.nextLine();
		
		assign.appendFile(s);

	}
	
	public void appendFile(String s) {
		String file = "resources/File_to_Append.txt";
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true))){	//Create a buffered writer to write to the file
		    buffer.write(s+"\n");   
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	


}
