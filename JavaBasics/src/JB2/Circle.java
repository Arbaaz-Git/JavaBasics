/**
 * 
 */
package JB2;

import java.util.Random;

/**
 * @author Arbaaz Khan
 *This class will implement Interface Shape and find the area of a circle and display its size
 */
public class Circle implements Shape {

	@Override
	public float calculateArea() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		float radius = (rand.nextFloat()*10)+1;
		return (float) (3.14*(radius*radius));
	}

	@Override
	public void display(float area) {
		System.out.println(area);
	}


}
