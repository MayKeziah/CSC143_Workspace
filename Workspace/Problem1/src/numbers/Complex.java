package numbers;

/**
 * Complex: a class to represent complex numbers
 * */
public class Complex implements Comparable<Complex>{
	private double im, re;

	/**
	 * Constructor: default, all values set to zero
	 * */
	public Complex() {
		this(0, 0);
	}
	
	/**
	 * Constructor: 
	 * @param re the real part of the complex number,
	 * the imaginary part is set to zero
	 * */
	public Complex(double re) {
		this(re, 0);
	}
	
	/**
	 * Constructor: 
	 * @param re the real part of the complex number
	 * @param im the imaginary part of the complex number
	 * */
	public Complex(double re, double im){
		this.im = im;
		this.re = re;
	}
	
	/**
	 * @return a double representing the distance of the point from the origin
	 * */
	public double abs() {
		return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
	}
	
	@Override
	/**
	 * @param object the object to compare to this Complex number
	 * @return an integer representing whether this number is less than (-1), 
	 * greater than (1), or equal to (0) the given number
	 * */
	public int compareTo(Complex object) {
		if (abs() > object.abs()) {
			return 1;
		}
		else if (abs() < object.abs()) {
			return -1;
		}
		else {
			return 0;
		}
	}

	/**
	 * @param c2 the complex number to divide this complex number by
	 * @return a new complex number representing the quotient of this number divided by the given number
	 * */
	public Complex divide(Complex c2) {
		double aNumer = this.re * c2.re + this.im * c2.im;
		double bNumer = this.im * c2.re - this.re * c2.im;
		double denom  = Math.pow(c2.re, 2) + Math.pow(c2.im, 2);
		if (denom == 0) {
			throw new ArithmeticException("division by Zero");
		}
		return new Complex(aNumer/denom, bNumer/denom);
	}

	/**
	 * @return the imaginary part of the complex number (b)
	 * */
	public double imaginaryPart() {
		return im;
	}

	/**
	 * @param c2 the complex number to subtract from this complex number
	 * @return a new complex number representing the difference between the two numbers
	 * */
	public Complex minus(Complex c2) {
		return new Complex(this.re - c2.re, this.im - c2.im);
	}

	/**
	 * @param c2 the complex number to add to this complex number
	 * @return a new complex number representing the addition of this number and the given number
	 * */
	public Complex plus(Complex c2) {
		return new Complex(this.re + c2.re, this.im + c2.im);
	}
	
	/**
	 * @return the real part of the complex number (a)
	 * */
	public double realPart() {
		return re;
	}

	/**
	 * @param c2 the complex number to multiply with this complex number
	 * @return a new complex number representing the product of this number and the given number
	 * */
	public Complex times(Complex c2) {
		double a = this.re * c2.re - this.im * c2.im;
		double b = this.im * c2.re + this.re * c2.im;
		return new Complex(a, b);
	}

	/**
	 * Method: toString() 
	 * @return a String representation of the complex number stored
	 * */
	public String toString() {
		if (im == 0) {
			return "(" + re + ")";
		}
		else {
			return "(" + re + " + " + im + "i)";
		}
	}

}
