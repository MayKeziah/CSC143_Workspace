package recursion;

/*******************************************************************
 * <p>This class demonstrates a quick sort algorithm.
 *******************************************************************/
public class QuickSort {

	/******************************************************
	 * runs the program. Tests an array of integers.
	 ******************************************************/
	public static void main(String[] args) {
		int[] data = {5, 2, 9, 3, 8, 4, 0, 1, 6, 7};
		print(data);
		quickSort(data);
		print(data);
	}
	
	/***************************************************************
	 * 	returns the pivot index.
	 * 	@param data array of integers.
	 * 	@param low  index.
	 * 	@param high index.
	 ***************************************************************/
	private static int partition(int[] data, int low, int high) {
		return 0;
	}
	
	/*********************************************
	 *  prints contents of data.
	 * 	@param data array of integers.
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
	
	/***************************************************************
	 *  initial call to sort data using quick sort algorithm.
	 ***************************************************************/
	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}
	
	/*****************************************************************
	 *  sorts data using quick sort algorithm using recursion.
	 * 	@param data array of integers.
	 *	@param low  index.
	 * 	@param high index.  
	 *****************************************************************/
	private static void quickSort(int[] data, int low, int high) {
		
		int last;				// last item in low partition
		
		//insert base case etc.
		
		/*****************************************************************
		 * partition: index
		 *            partition the data within the array. Value returned
		 *        	  from partitioning is the location of the last item 
		 *            in low partition.
		 * ***************************************************************/
		last = partition(data, low, high);
		
		/**********************************************************
		 * recursion: sort
		 *        	  recursively sort low partition (low to last) 
		 *            and high partition (last + 1 to high).
		 * ********************************************************/
		quickSort(data, low, last);
		quickSort(data, last + 1, high);
	}
	
}
