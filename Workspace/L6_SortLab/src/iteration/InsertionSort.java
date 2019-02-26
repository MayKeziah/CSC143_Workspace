package iteration;

/*******************************************************************
 * <p> This class demonstrates an insertion sort algorithm.
 *******************************************************************/
public class InsertionSort {

	/*****************************************************
	 *  sorts array using the insertion sort algorithm
	 *  @param data array of integers.
	 *****************************************************/
	public static void insertionSort(int[] data) {

	}
	
	/*********************************************
	 *  prints contents of array.
	 *  @param data array of integers.
	 *********************************************/
	public static void print(int[] data) {
		
		for(int i = 0; i < data.length; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		
		for(int item : data) {
			System.out.print(" " + item + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	/******************************************************
	 *  runs the program. Tests a data of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		int[] data = {2, 9, 5, 4, 8, 1, 6};
		print(data);
		insertionSort(data);
		print(data);
		print(data);
	}

}
