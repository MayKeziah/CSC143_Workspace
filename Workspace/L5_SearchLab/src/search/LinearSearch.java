package search;
/****************************************************************************
 * <p>This class demonstrates the use of a linear search algorithm. 
 * <br> Algorithm:  
 * <br> A target value is compared with each index value.
 * 		The target is checked against each element in the array.
 *      (a) if target matches a value in an index, return the index
 *          of the value.
 *      (b) if a match is not found it returns -1.
 ****************************************************************************/
public class LinearSearch {
	
	/******************************************************
	 *  returns the index at which the given target value
	 *  first appears in the given input array, or -1 if
	 *  not found.
	 *  @param data array of integers
	 *  @param target value
	 ******************************************************/
	public static int indexOf(int[] data, int target) {
		
		System.out.println("target value: " + target);
		
		return 0;
	}
	
	/******************************************************
	 *   runs the program. Tests an array of integers.
	 ******************************************************/
	public static void main(String[] args) {
		
		int[] data = {2, 3, 1, 5, 8, 6};
		print(data);
		
		int index  = indexOf(data, 3);
		showLocation(index);
		
		index      = indexOf(data, 7);
		showLocation(index);
		
		index      = indexOf(data, 8);
		showLocation(index);

	}
	
	/*********************************************************
	 *    prints contents of data.
	 *********************************************************/
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
	
	/********************************************************
	 *   formats and prints out the target location in
	 *   array if found.
	 ********************************************************/
	public static void showLocation(int index) {
		
		if (index == -1) {
			System.out.println("no match found ");
		}else {
			System.out.println("match found at index: " + index);
		}
		System.out.println();
			
	}

}
