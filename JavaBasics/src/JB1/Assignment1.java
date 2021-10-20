/**
 * 
 */
package JB1;

/**
 * @author Arbaaz Khan
 * 	This is Assignment 1 of Java Basics 1. There are 4 outputs for this assignment, where each output is a pattern containing : "*" and "." .
 * 
 */
public class Assignment1 {

	/**
	 * @param args
	 * The main method will call 4 functions, each function will output a string 
	 */
	public static void main(String[] args) {
		printHalfPyramid();
		printHalfInvertedPyramid();
		printPyramid();
		printInvertedPyramid();
	}
	//This will print a half Pyramid 
	public static void printHalfPyramid() {
		System.out.println("1)");
		for(int i=0; i<4;i++) {	//This loop is creating the 4 rows
			for(int k=0;k<=i;k++) {	//This loop printing the number of "*" needed for each row
				System.out.print("*");
				
			}
			System.out.println();
		}
		System.out.println("..........");
	}
	
	//This will print a half inverted Pyramid 
	public static void printHalfInvertedPyramid() {
		System.out.println("2)");
		System.out.println("..........");
		for(int i=4; i>0;i--) {	//since the pyramid is inverted, the top row should be the largest, thus i starts at 4 and then goes down
			for(int k=0;k<i;k++) {	//will populate each row with the need "*"
				System.out.print("*");
			}
			System.out.println();
		}

		
	}
	
	//This will print a Pyramid 
	public static void printPyramid() {
		System.out.println("3)");
		for(int i=1; i<=4;i++) {
			for(int k=i;k<4;k++) {	//This loop is creating the initial spacing need to center the pyramid
				System.out.print(" ");
			}
			System.out.print("  ");	//Need this extra spacing so the whole pyramid is centered on the row of "."
			for(int j=1;j<(i*2);j++) {	//This is making it so that each row has an odd number of "*"
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("...........");
		
	}
	
	//This will print an inverted Pyramid 
	//This function uses the same principles as printPyramid() but we are now inverting it, Thus we start at i=4 and decrement 
	public static void printInvertedPyramid() {
		System.out.println("4)");
		System.out.println("...........");
		for(int i=4; i>=1;i--) {
			for(int k=i;k<4;k++) {
				System.out.print(" ");
			}
			System.out.print("  ");
			for(int j=1;j<(i*2);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
