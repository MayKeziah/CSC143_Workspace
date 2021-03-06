/**
 * @tag a class to test the Line class 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import plane.Line;
import plane.Point;

/**
 * @author Unknown
 *
 */
class LineTest {
	private Line myLine;
	private Point p1;
	private Point p2;

	/**
	 * Test method for {@link plane.Line#Line()}.
	 */
	@Test
	void testLine() {
		myLine = new Line();
		assertNotNull(myLine, "New Line object is not Null: ");
		assertEquals(myLine.getP1().getX(), 0);
		assertEquals(myLine.getP1().getY(), 0);
		assertEquals(myLine.getP2().getX(), 1);
		assertEquals(myLine.getP2().getY(), 1);
	}
	
	/**
	 * Test associated with Problem II
	 */
	@Test
	void testLineException() {
		assertThrows(ArithmeticException.class, () -> {int b = 5/0; System.out.println(b);});
//		assertThrows(IllegalArgumentException.class, () -> {int b = 5/0; System.out.println(b);});		
	}

	/**
	 * Test method for {@link plane.Line#Line(int, int, int, int)}.
	 */
	@Test
	void testLineIntIntIntInt() {
		myLine = new Line(1, 2, 3, 4);
		assertNotNull(myLine, "New Line object is not Null: ");
		assertEquals(myLine.getP1().getX(), 1);
		assertEquals(myLine.getP1().getY(), 2);
		assertEquals(myLine.getP2().getX(), 3);
		assertEquals(myLine.getP2().getY(), 4);
	}

	/**
	 * Test method for {@link plane.Line#Line(plane.Point, plane.Point)}.
	 */
	@Test
	void testLinePointPoint() {
		myLine = new Line(new Point(3, 4), new Point(5, 6));
		assertNotNull(myLine, "New Line object is not Null: ");
		assertEquals(myLine.getP1().getX(), 3);
		assertEquals(myLine.getP1().getY(), 4);
		assertEquals(myLine.getP2().getX(), 5);
		assertEquals(myLine.getP2().getY(), 6);
	}

	/**
	 * Test method for {@link plane.Line#getP1()}.
	 */
	@Test
	void testGetP1() {
		p1 = new Point(2, 3);
		Line myLine = new Line(p1, new Point());
		assertSame(myLine.getP1(), p1);
	}

	/**
	 * Test method for {@link plane.Line#getP2()}.
	 */
	@Test
	void testGetP2() {
		p2= new Point(2, 3);
		Line myLine = new Line(new Point(), p2);
		assertSame(myLine.getP2(), p2);	}

	/**
	 * Test method for {@link plane.Line#isCollinear(plane.Point)}.
	 */
	@Test
	void testIsCollinear() {
		myLine = new Line();
		assertTrue(myLine.isCollinear(new Point(2, 2)), "[(0, 0) , (1, 1) , (2, 2)] are Collinear");
		assertFalse(myLine.isCollinear(new Point(2, 4)), "[(0, 0) , (1, 1) , (2, 4)] are NOT Collinear");
	}

	/**
	 * Test method for {@link plane.Line#magnitude()}.
	 */
	@Test
	void testMagnitude() {
		myLine = new Line(0, 0, 0, 3);
		assertEquals(3.0, myLine.magnitude(), "[(0, 0) , (0, 3)] has a length of 3");
	}

	/**
	 * Test method for {@link plane.Line#setEndPoints(plane.Point, plane.Point)}.
	 */
	@Test
	void testSetEndPoints() {
		myLine = new Line();
		myLine.setEndPoints(new Point(2, 3), new Point(4, 5));
		assertEquals(myLine.getP1().getX(), 2);
		assertEquals(myLine.getP1().getY(), 3);
		assertEquals(myLine.getP2().getX(), 4);
		assertEquals(myLine.getP2().getY(), 5);
	}

	/**
	 * Test method for {@link plane.Line#slope()}.
	 */
	@Test
	void testSlope() {
		myLine = new Line();
		assertEquals(1, myLine.slope());
		
		//Test: line to have invalid slope, dx == 0
		myLine = new Line(0, 1, 0, 3);
		
		//Test: invalid slope using inner class
		Executable executable = new Executable() {
			public void execute() throws ArithmeticException{
				myLine.slope();
			}
		};
		assertThrows(ArithmeticException.class, executable);
		
		//Test: Invalid slope using anonymous inner class as parameter
		assertThrows(ArithmeticException.class, new Executable() {
			public void execute() throws ArithmeticException{
				myLine.slope();
			}
		});
		//Test: invalid slope with lambda
		assertThrows(ArithmeticException.class, () -> myLine.slope());

		//Test: invalid slope with no valid test method
		try {
			myLine.slope();
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
	}

	/**
	 * Test method for {@link plane.Line#toString()}.
	 */
	@Test
	void testToString() {
		myLine = new Line();
		assertEquals("[(0, 0) , (1, 1)]", myLine.toString(), "toString() method successful");
	}

	/**
	 * Test method for {@link plane.Line#translate(int, int)}.
	 */
	@Test
	void testTranslate() {
		myLine = new Line();
		myLine.translate(3, 3);
		assertEquals(myLine.getP1().getX(), 3);
		assertEquals(myLine.getP1().getY(), 3);
		assertEquals(myLine.getP2().getX(), 4);
		assertEquals(myLine.getP2().getY(), 4);
	}

}
