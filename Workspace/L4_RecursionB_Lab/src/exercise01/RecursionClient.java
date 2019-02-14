package exercise01;

/***************************************************************************
 * <p> This program demonstrates the technique of recursion and includes 
 *     recursive methods that are defined for a variety of mathematical
 *     functions. 
 *         
 * <br>A recursive method is one that directly or indirectly calls itself 
 *     and must include:
 * <br>(1) end case:  stopping condition
 *                    which terminates/ends recursion
 * <br>(2) reduction: reduces the problem into a subproblem, which is a
 *                 	  smaller or simpler version of the original problem.
 *                 
 * <br> The recursive call is a call of the method with a smaller or 
 *      different argument. Normally, a recursive call reduces the original 
 *      problem by bringing it increasingly closer to an end case, until it 
 *      becomes the end case.
 ***************************************************************************/
public class RecursionClient {
	
	/***********************************************************
	 * returns the result of an real value x to the nth power.
	 * @param n the integer n 
	 * @throws IllegalArgumentException for negative exponents.
	 * *********************************************************/
	public static double exp(double x, int n) {
		
		return 0;
	}
	
	/************************************************************
	 * returns the result of a factorial down to zero factorial
	 * @param n  positive integer and zero
	 * @throws IllegalArgumentException for negative numbers.
	 * **********************************************************/
	public static int factorial(int n) {
		
		return 0;
	}
	
	/***********************************************************
	 * returns the result of the fibonacci sequence of numbers.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * *********************************************************/
	public static int fibonacci(int n) {
		
		return 0;
	}
	
	/***********************************************************
	 * returns the result of an integer x to the nth power.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative exponents.
	 * *********************************************************/
	public static int pow(int x, int n) {
		
		return 0;
	}
	
	/***********************************************************
	 * returns the result of the sum of n integers.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * *********************************************************/
	public static int sum(int n) {
		
		return 0;
	}
	
	/***********************************************************
	 * returns the result of the sum of n integers.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * *********************************************************/
	public static int sumOdd(int n) {
		
		return 0;
	}
	
	/***********************************************************
	 * runs the program
	 * @param args program arguments
	 * *********************************************************/
	public static void main(String[] args) {
		
		int n = 10;
		
		//value for nth factorial 
		for (int i = 1; i < n; i++ ) {
			System.out.print(factorial(i) + " ");
		}
		
		n = 12;
		System.out.println();
		
		//nth value in fibonacci series
		for (int i = 0; i < n; i++ ) {
			System.out.print(fibonacci(i) + " ");
		}
		System.out.println();
		
		
		
		//two to the power of  n
		n = 16;
		double two$n = Math.pow(2, n);
		System.out.println();
		System.out.println("pow(2, n): " + n + two$n);
		System.out.println("pow(2, n): " + n + pow(2, n));
		
		//e to the power of  n
		n = 8;
		double e$n = Math.pow(Math.E, n);
		System.out.println();
		System.out.println("e(n): " + n + e$n);
		System.out.println("exp(e, n) " + n + exp(Math.E, n));
		
		n = 10;
		System.out.println();
		
		//summation of n integers
		int sum = n * (n + 1) / 2;
		System.out.println("sum of " + n + " integers: " + sum);
		System.out.println("sum of " + n + " integers: " + sum(n));
		
		n = 5;
		System.out.println();
		
		//summation of first n odd integers
		int sumOdd = 0;
		for (int i = 1; i < n + 1; i++ ) {
			sumOdd = sumOdd + 2 * i - 1;
			System.out.print(sumOdd + " ");
		}
		
		System.out.println();
		System.out.println("first " + n + " odd integers: " + sumOdd);
		System.out.println("first " + n + " odd integers: " + sumOdd(n));
	}

}
