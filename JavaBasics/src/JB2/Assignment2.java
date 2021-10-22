/**
 * 
 */
package JB2;

import java.util.Random;

/**
 * @author Arbaaz Khan
 *	This program is creating a 2D array and then returning the max value an its index from the array.
 */
public class Assignment2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = genrateArray();
		findMaxVal(arr);
	}
	
	//As the method name suggests this generates a array of random size and random values
	private static int[][] genrateArray(){
		Random rand = new Random();
		int col = rand.nextInt(10)+1;
		int row = rand.nextInt(10)+1;
		int[][] arr =  new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int k=0;k<col;k++) {
				arr[i][k] = rand.nextInt(10)+1;
			}
		}
		return arr;
	}
	
	//This method itterates thru the array and looks for the largest value
	private static void findMaxVal(int[][] arr) {
		int[] max = new int[3];
		int mVal = 0;
		for(int i=0;i<arr.length;i++) {
			for(int k=0;k<arr[0].length;k++) {
				if(arr[i][k]>mVal) {
					mVal=arr[i][k];
					max[0]=i;
					max[1]=k;
					max[2]=arr[i][k];
				}
			}
		}
		System.out.printf("The max value is: %d, at index: (%d,%d)", max[2],max[0],max[1]);
	}

}
