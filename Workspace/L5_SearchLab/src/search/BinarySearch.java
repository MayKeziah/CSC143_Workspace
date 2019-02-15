package search;

/***************************************************************************
 * <p>This class demonstrates the use of a binary search algorithm. 
 * <br> Algorithm:   
 * <br> A target value is compared with the middle index value.
 * 		Initially the low end and high end index is set to 0 and 
 * 		length - 1 respectively, and the middle index is set to
 * 		the integer average of high and low.
 *      (a) if target value is less than the middle element, search only
 *          in the front half of the array for index.
 *      (b) if target value is greater than the middle element, search only
 *          in the back half of the array for index.
 *      (c) if target value matches the middle element, return the index
 *          of the middle value.
 *      (d) if a match is not found it returns -1.
 ***************************************************************************/
public class BinarySearch {

	/******************************************************
	 *  returns an index at which the target appears in the  
	 *  given input array, or -1 if not found.
	 *  @param data array of integers
	 *  @param target value
	 * ****************************************************/
	public static int binarySearch(int[] data, int target) {
		
		System.out.println("target value: " + target);
		
		return 0;
	}
	
	/******************************************************
	 *  runs the program. Tests a data of numbers
	 ******************************************************/
	public static void main(String[] args) {
		
		int[] data = {1, 3, 5, 7, 8, 9};
		print(data);
		
		int index = binarySearch(data, 2);
		showLocation(index);
		index = binarySearch(data, 5);
		showLocation(index);
		index = binarySearch(data, 9);
		showLocation(index);
	}
	
	/****************************************************
	 *    prints contents of data.
	 ****************************************************/
	public static void print(int[] data) {
		System.out.print(" ");
		for(int i = 0; i < data.length; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		
		String result = "[ " + data[0];
		for(int i = 1; i < data.length; i++) {
			result  += ", " + data[i];
		}
		result += " ]";
		
		System.out.println(result);
		System.out.println();
	}
	
	/*********************************************************
	 *   formats and prints out the target location in
	 *   array if found.
	 *********************************************************/
	public static void showLocation(int index) {
		
		if (index == -1) {
			System.out.println("no match found ");
		}else {
			System.out.println("match found at index: " + index);
		}
		System.out.println();
			
	}

}
