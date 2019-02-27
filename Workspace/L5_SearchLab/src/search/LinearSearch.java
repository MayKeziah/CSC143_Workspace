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
	
	/***************************************************************
	 *  creates a bit of tom foolery that attempts to generate
	 *  an illogical randomized data set.
	 *  @param numbers integer array
	 ***************************************************************/
	public static int[] dataSet(int n) {
		long startTime = System.currentTimeMillis();
		
		//Creates an array of length n.
		int[] data = new int[n];
		
		//Sets each value is equal to its index.
		for (int i = 0; i < n; i++) {
			data[i] = i;
		}
		
		long endTime   = System.currentTimeMillis();
		
		System.out.print("DataSet:  n = " + n + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
		return data;
	}

	/******************************************************
	 *  returns the index at which the given target value
	 *  first appears in the given input array, or -1 if
	 *  not found.
	 *  @param data array of integers
	 *  @param target value
	 ******************************************************/
	public static int indexOf(int[] data, int target) {
		
		System.out.println("target value: " + target);

		for (int i = 0; i < data.length; i ++) {
			if(data[i] == target) {
				return i;
			}
		}
		return -1;
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
		
		testIndexOf();

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
	
	public static void testIndexOf() {
		System.out.println("Data Set - 1 to 8");
		int[] data1  = dataSet(2000);
		int[] data2  = dataSet(4000);
		int[] data3  = dataSet(8000);
		int[] data4  = dataSet(16000);
		int[] data5  = dataSet(32000);
		int[] data6  = dataSet(64000);
		int[] data7  = dataSet(128000);
		int[] data8  = dataSet(256000);
		
		System.out.println();
		System.out.println("Data Set - 9 to 18 for Range 3 & Linear Search");
		
		int[] data9  = dataSet(512000);
		int[] data10 = dataSet(1024000);
		int[] data11 = dataSet(2048000);
		int[] data12 = dataSet(4096000);
		int[] data13 = dataSet(8192000);
		int[] data14 = dataSet(16384000);
		int[] data15 = dataSet(32768000);
		int[] data16 = dataSet(65536000);
		int[] data17 = dataSet(131072000);
		int[] data18 = dataSet(262144000);
		
		System.out.println();
		System.out.println("Linear Search: indexOf(int[], int) - Run Time Analysis");
		timeLinearSearch(data1, 262144001);
		timeLinearSearch(data2, 262144001);
		timeLinearSearch(data3, 262144001);
		timeLinearSearch(data4, 262144001);
		timeLinearSearch(data5, 262144001);
		timeLinearSearch(data6, 262144001);
		timeLinearSearch(data7, 262144001);
		timeLinearSearch(data8, 262144001);
		timeLinearSearch(data9, 262144001);
		timeLinearSearch(data10, 262144001);
		timeLinearSearch(data11, 262144001);
		timeLinearSearch(data12, 262144001);
		timeLinearSearch(data13, 262144001);
		timeLinearSearch(data14, 262144001);
		timeLinearSearch(data15, 262144001);
		timeLinearSearch(data16, 262144001);
		timeLinearSearch(data17, 262144001);
		timeLinearSearch(data18, 262144001);
	}
	
	/***************************************************************
	 *  approximates how long the method takes to run.
	 *  @param numbers integer array
	 ***************************************************************/
	public static void timeLinearSearch(int[] numbers, int target) {
		long startTime = System.currentTimeMillis();
		indexOf(numbers, target);
		long endTime   = System.currentTimeMillis();
		System.out.print("DataSet:  n = " + numbers.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
}
