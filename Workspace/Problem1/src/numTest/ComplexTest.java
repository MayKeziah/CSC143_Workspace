/**
 * 
 */
package numTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import numbers.Complex;

/**
 * @author Unknown
 *
 */
class ComplexTest {
	private Complex testNum;
	private Complex temp;

	/**
	 * Test method for {@link numbers.Complex#Complex()}.
	 */
	@Test
	void testComplex() {
		testNum = new Complex();
		assertEquals(0.0, testNum.realPart(), "The real part equals zero with a default constructor");
		assertEquals(0.0, testNum.imaginaryPart(), "The imaginary part equals zero with a default constructor");
	}

	/**
	 * Test method for {@link numbers.Complex#Complex(double)}.
	 */
	@Test
	void testComplexDouble() {
		testNum = new Complex(1);
		assertEquals(1.0, testNum.realPart(), "The real part equals one with a single parameter constructor");
		assertEquals(0.0, testNum.imaginaryPart(), "The imaginary part equals zero with a single parameter constructor");	}

	/**
	 * Test method for {@link numbers.Complex#Complex(double, double)}.
	 */
	@Test
	void testComplexDoubleDouble() {
		testNum = new Complex(2, 3);
		assertEquals(2.0, testNum.realPart(), "The real part equals 2 with a two parameter constructor");
		assertEquals(3.0, testNum.imaginaryPart(), "The imaginary part equals 3 with a two parameter constructor");	
	}

	/**
	 * Test method for {@link numbers.Complex#abs()}.
	 */
	@Test
	void testAbs() {
		testNum = new Complex(4, 2);
		assertEquals(Math.sqrt(20), testNum.abs(), "The abs equals sqrt(20) when re == 4, im == 2");
		}

	/**
	 * Test method for {@link numbers.Complex#compareTo(java.lang.Double)}.
	 */
	@Test
	void testCompareTo() {
		testNum = new Complex(1, 1);
		assertEquals(1, testNum.compareTo(new Complex()), "Compare sqrt(2) == 1.414... to 1.0");
		assertEquals(-1, testNum.compareTo(new Complex(2, 2)), "Compare sqrt(2) == 1.414... to 2.0");
		assertEquals(0, testNum.compareTo(testNum), "Compare sqrt(2) == 1.414... to 1.0");

		}

	/**
	 * Test method for {@link numbers.Complex#divide(numbers.Complex)}.
	 */
	@Test
	void testDivide() {
		testNum 		 = new Complex(2, 4);
		temp 			 = new Complex(1, 2);
		Complex division = testNum.divide(temp);
		assertEquals(2.0, division.realPart(), "The real part equals 2 for: "
								  			 + testNum.toString() + " divided by "
								  			 + temp.toString());
		assertEquals(0.0, division.imaginaryPart(), "The imaginary part equals 0 for: "
											 + testNum.toString() + " divided by "
											 + temp.toString());
		//division by zero
		testNum  = new Complex(2, 4);
		temp 	 = new Complex();
		assertThrows(ArithmeticException.class, () -> testNum.divide(temp));
		try {
		division = testNum.divide(temp);
		}
		catch (ArithmeticException Z) {
			System.out.println("Test /0.0 throw success:\n\t" + Z);
		}
		}
	/**
	 * Test method for {@link numbers.Complex#imaginaryPart(numbers.Complex)}.
	 */
	@Test
	void testimaginaryPart() {
		testNum = new Complex(1, 1);
		assertEquals(1.0, testNum.imaginaryPart(), "The imaginary part equals zero with a default constructor");
	}
	
	/**
	 * Test method for {@link numbers.Complex#minus(numbers.Complex)}.
	 */
	@Test
	void testMinus() {
		testNum 			= new Complex(2, 1);
		temp		 		= new Complex(0, 3);
		Complex subtraction = testNum.minus(temp);
		assertEquals(2.0, subtraction.realPart(), "The real part equals 2 for: "
												+ testNum.toString() + " minus "
												+ temp.toString());
		assertEquals(-2.0, subtraction.imaginaryPart(), "The imaginary part equals -2 for: "
													  + testNum.toString() + " minus "
													  + temp.toString());			
		}

	/**
	 * Test method for {@link numbers.Complex#plus(numbers.Complex)}.
	 */
	@Test
	void testPlus() {
		testNum 	 	 = new Complex(1, 0);
		temp		 	 = new Complex(4, 2);
		Complex addition = testNum.plus(temp);
		assertEquals(5.0, addition.realPart(), "The real part equals 5 for: "
											 + testNum.toString() + " plus "
											 + temp.toString());
		assertEquals(2.0, addition.imaginaryPart(), "The imaginary part equals 2 for: "
												  + testNum.toString() + " plus "
												  + temp.toString());				
		}

	/**
	 * Test method for {@link numbers.Complex#realPart(numbers.Complex)}.
	 */
	@Test
	void testrealPart() {
		testNum = new Complex(1, 1);
		assertEquals(1.0, testNum.realPart(), "The real part equals zero with a default constructor");
	}

	/**
	 * Test method for {@link numbers.Complex#times(numbers.Complex)}.
	 */
	@Test
	void testTimes() {
		testNum 			   = new Complex(0, 5);
		temp		 		   = new Complex(4, 3);
		Complex multiplication = testNum.times(temp);
		assertEquals(-15.0, multiplication.realPart(), "The real part equals -15 for: "
											 		 + testNum.toString() + " times "
											 		 + temp.toString());
		assertEquals(20.0, multiplication.imaginaryPart(), "The imaginary part equals 20 for: "
														 + testNum.toString() + " times "
														 + temp.toString());		
		}

	/**
	 * Test method for {@link numbers.Complex#toString()}.
	 */
	@Test
	void testToString() {
	testNum = new Complex(10, 5);
	assertEquals("(10.0 + 5.0i)", testNum.toString(), "toString() value of complex(10, 5) equals " + testNum.toString());
	//imaginaryPart() == zero
	testNum = new Complex();
	assertEquals("(0.0)", testNum.toString(), "toString() value of complex() equals " + testNum.toString());

	
	}

}
