/**
 * 
 */
package JB2;

/**
 * @author Arbaaz Khan
 * This program will be taking multiple command line inputs and outputting  the sum of them. The program will being looking for any integer or float value and adding together. The program will also ignore all non int/float inputs. A key point to note is that this code does not handle overflow issues. 
 *
 */
public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float sum=0;
		for(String s:args) {
//			System.out.println(s);
			if(isNum(s)) {
				sum+= Float.parseFloat(s);
			}
		}
		
		System.out.println(sum);
	}
	
	public static boolean isNum(String val) {
		try {
			Float.parseFloat(val);
			
		}catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}


}
