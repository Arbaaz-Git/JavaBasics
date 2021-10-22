/**
 * 
 */
package JB2;

/**
 * @author Arbaaz Khan
 * This program will be taking multiple command line inputs and outputting  the sum of them. The program will being looking for any integer or float value and adding together. The program will also ignore all non int/float inputs. A key point to note is that this code does not handle overflow issues. 
 * 
 * Important! Must run code with command line arguments. If you are running the code in and IDE then make sure when run the code that the IDE is inputting arguments to run. If running in Eclipse then click the drop-down arrow on the run button and then go to run configurations. In the run configurations window, click on the arguments tab and filling in the program argumets text box with your desired inputs. Then hit apply and run. 
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
