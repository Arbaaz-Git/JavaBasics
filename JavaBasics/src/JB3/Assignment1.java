/**
 * 
 */
package JB3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Arbaaz Khan
 *	This program will look through a given directory and print out all the files and subdirectories within it. The given directory that this program will be looking through will the src directory, which contains the directories JB1-3. 
 */
public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try (Stream<Path> paths = Files.walk(Paths.get("src/"))) {	//Here we are setting the starting point of a file tree as the relative path of src. 
	        paths.forEach(path -> System.out.println(path));	//now we are itterating thru that file tree and for every path we find we print it
	      } catch (IOException e) {
	        e.printStackTrace();
	      }

	}

}
