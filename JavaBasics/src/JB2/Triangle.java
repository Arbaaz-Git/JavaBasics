/**
 * 
 */
package JB2;

import java.util.Random;

/**
 * @author Arbaaz Khan
 *	This class will implement Interface Shape and find the area of a triangle and display its size
 */
public class Triangle implements Shape {

	@Override
	public float calculateArea() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		float base = (rand.nextFloat()*10)+1;
		float height = (rand.nextFloat()*10)+1;
		return (base*height)/2;
	}

	@Override
	public void display(float area) {
		System.out.println(area);		
	}

}
