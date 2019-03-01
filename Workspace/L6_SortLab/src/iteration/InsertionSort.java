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
		//For all unsorted indecies...
		for (int i = 1; i < data.length; i++) {
			int j = i - 1;
			int elt = data[i];
			
			//...if the element is less than the last element in the sorted list, shift right
			while((j >= 0) && (data[j] > elt)) {
				data[j+1] = data[j];
				j--;
			}
			
			//Insert the current element into the appropriate part of the list.
			data[j+1] = elt;
		}		
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
