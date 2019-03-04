package recursion;

/*******************************************************************
 * <p> This class demonstrates a merge sort algorithm.
 *******************************************************************/
public class MergeSort {
	
	/***************************************************************
	 *  merges the given left half and right half into one array.
	 *  @param left side of array
	 *  @param right side of array
	 *  @param data unsorted array of  integer values
	 ***************************************************************/
	private static void merge(int[] data, int[] left, int[] right) {
		//Current left index
		int l = 0;
		
		//Current right index
		int r = 0;
		
		//Current data index
		int i = 0;
		
		//While there are more elements in both the left and right array...
		while ((r < right.length) && (l < left.length)) {
			
			//Put the element with the smallest value in the next available position in data
			if (left[l] < right[r]) {
				data[i] = left[l];
				i++;
				l++;
			}else {
				data[i] = right[r];
				i++;
				r++;
			}
		}
		
		//Once either the left or right array has no more elements to check, 
		// iteratively add the remaining elements from the other array to data.
		while (r < right.length) {
			data[i] = right[r];
			i++;
			r++;
		}while (l < left.length) {
			data[i] = left[l];
			i++;
			l++;
		}
	}
	
	/*********************************************************
	 *  places the values in array in sorted order using
	 *  the merge sort algorithm.
	 *  @param data unsorted array of integer values
	 * *******************************************************/
	public static void mergeSort(int[] data) {
		
		if (data.length > 1) {
			
			/*********************************************************
			 * split: two halves
			 * 		  split unsorted data into two unsorted halves.
			 * *******************************************************/
			int[] left  = splitLeft(data);
			int[] right = splitRight(data);	

			
			/*********************************************************
			 * recursion: two halves
			 * 		 	  recursively sort the left and right halves.
			 * *******************************************************/
			mergeSort(left);				//recursion
			mergeSort(right);				//recursion
			
			/*********************************************************
			 * merge: two halves
			 * 		  merge sorted halves into a sorted whole array.
			 * *******************************************************/
			merge(data, left, right);
			
		}else{
			System.out.println("End: one item array.");
		}
	}
	
	/***************************************************************
	 *	prints contents of array.
	 * *************************************************************/
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
	
	/***************************************************************
	 *  returns first half of array.
	 *  @param data unsorted array of integer values.
	 * *************************************************************/
	private static int[] splitLeft(int[] data) {
		int size = data.length / 2;
		int[] leftHalf = new int[size];
		for (int i = 0; i < size; i++) {
			leftHalf[i] = data[i];
		}
		return leftHalf;
	}
	
	/***************************************************************
	 *  returns second half of array.
	 *  @param data unsorted array of integer values.
	 * *************************************************************/
	private static int[] splitRight(int[] data) {
		int len = data.length;
		int start = len / 2;
		int[] rightHalf = new int[len - start];
		for (int i = 0; i < (len - start); i++) {
			rightHalf[i] = data[i + start];
		}
		return rightHalf;
	}
	
	/******************************************************
	 * 	runs the program. Tests an array of integers.
	 *	@param args system values.
	 ******************************************************/
	public static void main(String[] args) {
		int[] data = {2, 9, 5, 4, 8, 1, 6, 7};
		print(data);
		mergeSort(data);
		System.out.println();
		print(data);
	}

}
