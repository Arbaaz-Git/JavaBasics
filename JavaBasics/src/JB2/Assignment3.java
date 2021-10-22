/**
 * 
 */
package JB2;

import java.util.Random;

/**
 * @author Arbaaz Khan
 *	In this code I am creating objects of circle, rectangle and triangle and calling the functions that each of these objects inherited. 
 */
public class Assignment3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float area=0;
		
		Circle cir = new Circle();
		area = cir.calculateArea();
		cir.display(area);
		
		Rectangle rec= new Rectangle();
		area = rec.calculateArea();
		rec.display(area);
		
		Triangle tri = new Triangle();
		area = tri.calculateArea();
		tri.display(area);
	}

}
