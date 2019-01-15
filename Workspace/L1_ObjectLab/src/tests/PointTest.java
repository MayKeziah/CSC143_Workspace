/********************************************************
 * This is a test class for Point
 ********************************************************/
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import plane.Point;

class PointTest {

	 private Point point = new Point(0, 0);
	 
	/**********************************************
	 * Test method for {@link plane.Point#Point()}.
	 **********************************************/
	@Test
	void testPoint() {
		
		//test: constructor Point()
		assertEquals(0, point.getX());
		assertEquals(0, point.getY());
		
		//check : contents of Point object
		System.out.println("test point at origin: " + point);
	}

	/**********************************************************
	 * Test method for {@link plane.Point#Point(plane.Point)}.
	 **********************************************************/
	@Test
	void testPointPoint() {
		Point newPoint = new Point(2, 5);
		point = new Point(newPoint);
		
		//test: constructor Point(Point)
		assertEquals(2, point.getX());
		assertEquals(5, point.getY());
		
		//check : contents of Point object
		System.out.println("test new point: " +  point);
	}

	/********************************************************
	 * Test method for {@link plane.Point#Point(int, int)}.
	 ********************************************************/
	@Test
	void testPointIntInt() {
		
		point = new Point(1, 4);
		
		//test: constructor Point(x, y)
		assertEquals(1, point.getX());
		assertEquals(4, point.getY());
		
		//check : contents of Point object
		System.out.println("test point (x,y): " + point);
	}

	/********************************************************
	 * Test method for {@link plane.Point#getX()}.
	 ********************************************************/
	@Test
	void testGetX() {
		point.move(6, 0);
		
		//test: getX method
		assertEquals(6, point.getX());
		
		//check : contents of Point object
		System.out.println("test getX: " + point);
	}

	/********************************************************
	 * Test method for {@link plane.Point#getY()}.
	 ********************************************************/
	@Test
	void testGetY() {
		
		point.move(0, 6);
		
		//test: getY method
		assertEquals(6, point.getY());
		
		//check : contents of Point object
		System.out.println("test getY: " + point);
	}

	/********************************************************
	 * Test method for {@link plane.Point#move(int, int)}.
	 ********************************************************/
	@Test
	void testMove() {
		point.move(3, 8);
		
		//test: move method
		assertEquals(3, point.getX());
		assertEquals(8, point.getY());
		
		//check : contents of Point object
		System.out.println("test move: " + point);
	}

	/****************************************************************
	 * Test method for {@link plane.Point#setLocation(plane.Point)}.
	 ****************************************************************/
	@Test
	void testSetLocationPoint() {
		
		point.setLocation( new Point(1, 3) );
		
		//test: setLocation method
		assertEquals(1, point.getX());
		assertEquals(3, point.getY());
		
		//check : contents of Point object
		System.out.println("test setLocation(p): " + point);
	}

	/************************************************************
	 * Test method for {@link plane.Point#setLocation(int, int)}.
	 ************************************************************/
	@Test
	void testSetLocationIntInt() {
		
		point.setLocation(4, 9);
		
		//test: setLocation method
		assertEquals(4, point.getX());
		assertEquals(9, point.getY());
		
		//check : contents of Point object
		System.out.println("test setLocation(x,y): " + point);
	}

	/****************************************************
	 * Test method for {@link plane.Point#toString()}.
	 ****************************************************/
	@Test
	void testToString() {
		
		point.setLocation(5, 3);
		
		//test: toString method
		assertEquals(5, point.getX());
		assertEquals(3, point.getY());
		
		//check : contents of Point object
		System.out.println("test toString: " + point);
	}

	/***********************************************************
	 * Test method for {@link plane.Point#translate(int, int)}.
	 ***********************************************************/
	@Test
	void testTranslate() {
		point.setLocation(2, 3);
		point.translate(4, 1);
		
		//test: translate method
		assertEquals(6, point.getX());
		assertEquals(4, point.getY());
		
		//check : contents of Point object
		System.out.println("test translate: " + point);
	}

}
