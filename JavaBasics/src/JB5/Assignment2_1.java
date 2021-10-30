/**
 * 
 */
package JB5;

import java.util.Scanner;

/**
 * @author Arbaaz Khan
 * THis code has 3 methods that are lambda expressions that return a value. The program will take 2 values from the user. The first value denotes which opperation they want done. The second value is the number they want the operation done on.
 */
class checkNum{
	public static boolean check(PerformOperation p, int val) {
		return p.check(val);
	}
	
    PerformOperation isOdd() {
        return n -> n % 2 == 0 ? false : true;
    }

    PerformOperation isPrime() {
        return n -> {
            if (n == 1)
                return true;
            else {
                for (int i = 2; i < Math.sqrt(n); i++)
                    if (n % i == 0)
                        return false;
                return true;
            }
        };
    }

    PerformOperation isPalindrome() {
        return n -> {
            String string = String.valueOf(n);
            String reverseString = new StringBuffer(string).reverse().toString();
            return string.equals(reverseString);
        };
    }
}

public class Assignment2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkNum cNum = new checkNum(); 
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int val = scan.nextInt();
		System.out.println("The number you choose is: "+val);
		System.out.println("Please choose on opperation you wish done on your number:\n1 for isOdd()\n2 for isPrime()\n3 for isPalindrome()");
		int op = scan.nextInt();
		switch(op) {
		case 1: 
			if(cNum.check(cNum.isOdd(), val)) {
				System.out.println("Odd");
			}
			else {
				System.out.println("Even");
			}
			break;
		
		case 2:
			if(cNum.check(cNum.isPrime(), val)) {
				System.out.println("PRIME");
			}
			else {
				System.out.println("COMPOSITE");
			}
			break;
		case 3:
			if(cNum.check(cNum.isPalindrome(), val)) {
				System.out.println("PALINDROME");
			}
			else {
				System.out.println("Not PALINDROME");
			}
			break;
			default:
				break;
		}
	}
}
