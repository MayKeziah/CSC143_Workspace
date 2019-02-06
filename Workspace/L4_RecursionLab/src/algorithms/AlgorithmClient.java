package algorithms;
/**
 * AlgorithmClient Objective: To understand recursion and recursive algorithms. 
 * 
 * @author E
 * */

public class AlgorithmClient {

	public static void main(String[] args) {
		/**
		 * @test for AlgorithmClient.factorial(int n)
		 */
		System.out.print("---------------------------------------------------------------"
				+ "\nTesting factorial(n):"
				+ "\n   Input: n = 5"
				+ "\n  Output: ");
		System.out.print(factorial(5)
				+ "\nExpected: 120");
		System.out.println("\n---------------------------------------------------------------");
		
		/**
		 * @test for AlgorithmClient.fibonacci(int n)
		 */
		System.out.print("---------------------------------------------------------------"
				+ "\nTesting fibonacci(n):"
				+ "\n   Input: n = 9"
				+ "\n  Output: ");
		System.out.print(fibonacci(9)
				+ "\nExpected: 34");
		System.out.println("\n---------------------------------------------------------------");
		
		/**
		 * @test for AlgorithmClient.sum(int n)
		 */
		System.out.print("---------------------------------------------------------------"
				+ "\nTesting sum(n):"
				+ "\n   Input: n = 5"
				+ "\n  Output: ");
		System.out.print(sum(5)
				+ "\nExpected: 15");
		System.out.println("\n---------------------------------------------------------------");
		
		/**
		 * @test for AlgorithmClient.oddSum(int n)
		 */
		System.out.print("---------------------------------------------------------------"
				+ "\nTesting oddSum(n):"
				+ "\n   Input: n = 5"
				+ "\n  Output: ");
		System.out.print(oddSum(5)
				+ "\nExpected: 25");
		System.out.println("\n---------------------------------------------------------------");
		
		
		// TODO Auto-generated method stub

	}
	
	/**
	 * factorial: a recursive algorithm for calculating a given integer's factorial product.
	 * 
	 * @param n the positive integer to initialize the factorial product calculation with
	 * @return the product of the given integer multiplied by every integer of lesser value.
	 * */
	public static int factorial(int n) {
		if(n < 0) { //invalid input
			return 0;
		}if(n <= 1) { //end case (1)
			return 1;
		}else { //recursive call (2)
			return n * factorial(n-1);
		}
	}
	
	/**
	 * fibonacci: a recursive algorithm to compute the nth Fibonacci value
	 * 
	 * @param n an integer representing the number of the Fibonacci series to find the value of.
	 * @return the nth value of the Fibonacci sequence
	 * */
	public static int fibonacci(int n) {
		if(n < 1) { //n = 0 || invalid input
			return 0;
		}if(n == 1) { //end case
			return 1;
		}else { //recursive call
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/**
	 * sum: computes the sum of the first n positive integers.
	 * 
	 * @param n the number of positive integers to sum
	 * @return the sum of the first n positive integers
	 * */
	public static int sum(int n) {
		if(n <= 0) { //n = zero || invalid input
			return 0;
		}else {
			return n + sum(n-1);
		}
		
	}
	
	/**
	 * oddSum: computes the sum of the first n positive odd integers.
	 * 
	 * @param n the number of odd integers to sum.
	 * @return the sum of the first n positive odd integers
	 * */
	public static int oddSum(int n) {
		if(n <=0) { //n = zero || invalid input
			return 0;
		}else {
			return n * 2 - 1 + oddSum(n-1);
		}
	}
	
	/**
	 * 
	 * 
	 * */
	public static int factorial(int n) {
		
	}
	
	/**
	 * 
	 * 
	 * */
	public static int factorial(int n) {
		
	}
	
	/**
	 * 
	 * 
	 * */
	public static int factorial(int n) {
		
	}
}
