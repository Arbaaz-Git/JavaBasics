/**
 * 
 */
package JB4Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import JB4.Line;

/**
 * @author Arbaaz Khan
 *
 */
public class LineTest {
	
	Line l1 = new Line(1, 2, 3, 4);	//If X0<Y0 and X1<Y1
	
	Line l2 = new Line(2, 1, 3, 4);	//If X0>Y0
	
	Line l3 = new Line(1, 2, 4, 3);//If X1>Y1
	
	Line l4 = new Line(2, 1, 4, 3);//If X0>Y0 and X1>Y1
	
	
	
	@Test
	public void getSlopeTest() {
		double val = 0;
		assertEquals(1,val = l1.getSlope(),.0001);
		assertEquals(3,val = l2.getSlope(),.0001);
		assertEquals(.3333,val = l3.getSlope(),.0001);
		assertEquals(1,val = l4.getSlope(),.0001);		
	}
	
	@Test
	public void getDistanceTest() {
		double val = 0;
		assertEquals(2.8284,val = l1.getDistance(),.0001);
		assertEquals(3.1622,val = l2.getDistance(),.0001);
		assertEquals(2.2360,val = l3.getDistance(),0001);
		assertEquals(2.8284,val = l4.getDistance(),.0001);	
	}
	
	@Test
	public void parallelTo_True_Test() {
		//Make sure that the line is parallel to itself
		assertTrue(l1.parallelTo(l1));
		assertTrue(l2.parallelTo(l2));
		assertTrue(l3.parallelTo(l3));
		assertTrue(l4.parallelTo(l4));
		assertTrue(l4.parallelTo(l1));
		
	}
	
	@Test
	public void parallelTo_False_Test() {
		assertFalse(l1.parallelTo(l2));
		assertFalse(l2.parallelTo(l3));
		assertFalse(l3.parallelTo(l4));
	}

}
