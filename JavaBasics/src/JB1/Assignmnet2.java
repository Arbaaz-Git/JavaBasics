/**
 * 
 */
package JB1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Arbaaz Khan
 *	Assignment 2 asks for the user to guess a number 1-100. If the user guess within +/- 10 of the correct answer then the code will print the answer. If the user does not guess the number within +/- 10 of the correct answer, then the code will ask the user to guess again. After the user has tried to guess the number 5 times, then the code will display "Sorry" and then print the correct number. 
 */

public class Assignmnet2 {

	/**
	 * @param args
	 * The main method will start by randomly generating a number the user has to guess. 
	 * The main method will use the scanner object to take in the users Guess. 
	 */
	public static void main(String[] args) {
		int gCount=1;	//This will track how many times the user has guessed the answer
		
		//These 3 lines are used to generate the number to guess
		Random rand = new Random();
		int answer = rand.nextInt(100);
		answer+=1;	//We add 1 because Random is setting the range from 0-99, and we want it to be 1-100
		
		
		//These 3 lines will request and store the users guess
		Scanner scan = new Scanner(System.in);
		System.out.println("Guess a number 1-100: ");
		while(!scan.hasNextInt()) {
			System.out.println("Guess a number 1-100: ");
		    scan.next();
		}
		int input = scan.nextInt();
		
		if(input<=answer+10 && input>=answer-10) {	//THis will check if the users first answer is correct or not
			System.out.println(answer);
			gCount=5;
		}
				
		//While the guess Count is less then 5 the code will continue to prompt the user to guess a number. IF the user guesses a number within the correct bounds the code will print the answer end 
		while(gCount<5) {	
			System.out.println("Wrong answer. Please guess again.");
			while(!scan.hasNextInt()) {
				System.out.println("Guess a number 1-100: ");
			    scan.next();
			}
			input = scan.nextInt();
			if(input<=answer+10 && input>=answer-10) {
				System.out.println(answer);
				break;
			}
			gCount++;
			if(gCount==5) {
				System.out.println("Sorry. The correct answer was: "+answer);
			}
		}
		scan.close();
	}

}
