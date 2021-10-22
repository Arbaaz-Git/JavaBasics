/**
 * 
 */
package JB2;

import java.util.Random;

/**
 * @author Arbaaz Khan
 *This class will implement Interface Shape and find the area of a rectangle and display its size
 */
public class Rectangle implements Shape {

	@Override
	public float calculateArea() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		float len = (rand.nextFloat()*10)+1;
		return len*len;
	}

	@Override
	public void display(float area) {
		System.out.println(area);		
	}

}
