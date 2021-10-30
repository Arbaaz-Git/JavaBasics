/**
 * 
 */
package JB5;

/**
 * @author Arbaaz Khan
 *	This program is showing of Recursion. In this code I am calling a method that takes the stating index an array of ints and a target value. The goal is the see if there any group of numbers in the array that add up to the target value. The key is that if there is numbers that are adjacent and identical that they have to be grouped togeather
 */
public class Assignment2_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] group = {2,4,8};
		int[] g1 = {2,4,4,8};
		int index =0;
		int targetSum = 10;
		
		System.out.println(groupSumClump(index,g1,targetSum));
	}
	
	public static boolean groupSumClump(int index, int[] group,int goal) {
		if(index >= group.length) {
			return goal==0;
		}
		int count=index;
		int val=0;
		
		while(count<group.length && group[index]==group[count]) {
			val+= group[count];
			count++;
		}
		if(groupSumClump(count,group,goal-val)) {	//This is the recursive call
			return true;
		}
		if(groupSumClump(count,group,goal)) {
			return true;
		}
		
		return false;
	}

}
